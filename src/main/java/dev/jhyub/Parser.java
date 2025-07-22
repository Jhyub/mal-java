package dev.jhyub;

import dev.jhyub.objects.*;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<String> tokens;
    private int ptr = 0;

    public Parser(List<String> tokens) {
        this.tokens = tokens;
    }

    public MalObject parse() {
        return read_form();
    }

    private MalObject read_form() {
        String tok = tokens.get(ptr);
        MalObject ret;
        if (tok.equals("(")) {
            ptr++;
            ret = read_list();
        } else {
            ret = read_atom();
        }
        return ret;
    }

    private MalList read_list() {
        MalList ret = new MalList(new ArrayList<>());
        while (true) {
            String tok = tokens.get(ptr);
            if (tok.equals(")")) {
                ptr++;
                break;
            }
            MalObject obj = read_form();
            ret.append(obj);
        }
        return ret;
    }

    private MalObject read_atom() {
        String tok = tokens.get(ptr++);

        if (tok.startsWith("\"") && tok.endsWith("\"")) {
            return new MalString(tok);
        }

        if (tok.equals("nil")) {
            return new MalNil();
        }

        if (tok.equals("true") || tok.equals("false")) {
            return new MalBool(tok);
        }

        try {
            MalNumber mnl = new MalNumber(tok);
            return mnl;
        } catch (NumberFormatException e) {
            if (!Character.isDigit(tok.charAt(0))) {
                return new MalSymbol(tok);
            }
        }

        return new MalUnknown(tok);
    }


}
