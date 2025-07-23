package dev.jhyub;

import dev.jhyub.objects.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class REPL {
    public static MalObject read(String s) throws IOException {
        try {
            var tokens = Tokenizer.tokenize(s);
            /*
            for(var token : tokens) {
                System.out.print("\"");
                System.out.print(token);
                System.out.println("\"");
            }
            */
            Parser p = new Parser(tokens);
            return p.parse();
        } catch (IOException e) {
            System.err.println("Error while reading: " + e.getMessage());
            throw e;
        }
    }

    public static EvalSession eval(EvalSession session) {
        var obj = session.getObject();
        var env = session.getEnv();
        var localEnv = session.getLocalEnv();
        if (obj instanceof MalList list) {
            if (list.getItems().getFirst() instanceof MalSymbol sym) {
                if(sym.getName().equals("def!")) {
                    MalSymbol name = (MalSymbol) list.getItems().get(1);
                    MalObject value = eval(new EvalSession(list.getItems().get(2), env, localEnv)).getObject();
                    env.put(name.getName(), value);
                    return new EvalSession(value, env, new HashMap<>());
                } else if (sym.getName().equals("let*")) {
                    List<MalObject> definitions =  ((MalList) list.getItems().get(1)).getItems();
                    MalObject target = list.getItems().get(2);

                    HashMap<String, MalObject> newLocalEnv = new HashMap<>(localEnv);
                    for(int i=0; i+1<definitions.size(); i+=2) {
                        MalSymbol name = (MalSymbol) definitions.get(i);
                        EvalSession ret = eval(new EvalSession(definitions.get(i+1), env, localEnv));
                        env = ret.getEnv();
                        MalObject value = ret.getObject();

                        newLocalEnv.put(name.getName(), value);
                    }

                    return eval(new EvalSession(target, env, newLocalEnv));
                }
            }

            List<MalObject> evaluated = new ArrayList<>();
            for(var i: list.getItems()) {
                EvalSession ret = eval(new EvalSession(i, env, localEnv));
                env = ret.getEnv();
                evaluated.add(ret.getObject());
            }

            if(evaluated.getFirst() instanceof MalFunction fn) {
                List<MalObject> args = evaluated.subList(1, evaluated.size());
                return new EvalSession((MalObject) fn.getFunction().apply(args), env, localEnv);
            } else {
                return new EvalSession(new MalList(evaluated), env, localEnv);
            }
        } else if (obj instanceof MalSymbol sym) {
            return new EvalSession(localEnv.getOrDefault(sym.getName(), env.getOrDefault(sym.getName(), new MalNil())), env, new HashMap<>());
        }
        return new EvalSession(obj, env, localEnv);
    }

    public static String print(MalObject obj) {
        return obj.print();
    }

    public static Map<String, MalObject> env;
    static {
        env = new HashMap<>();
        env.put("+", MalFunction.add);
        env.put("-", MalFunction.sub);
        env.put("*", MalFunction.mul);
        env.put("/", MalFunction.div);
    }

    public static String rep(String s) throws IOException {
        var readRes = read(s);
        var evalRes = eval(new EvalSession(readRes, env, new HashMap<>()));
        env = evalRes.getEnv();
        return print(evalRes.getObject());
    }
}
