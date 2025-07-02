package dev.jhyub;

import dev.jhyub.objects.MalObject;

import java.io.IOException;

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

    public static MalObject eval(MalObject obj) {
        return obj;
    }

    public static String print(MalObject obj) {
        return obj.print();
    }

    public static String rep(String s) throws IOException {
        var readRes = read(s);
        var evalRes = eval(readRes);
        return print(evalRes);
    }
}
