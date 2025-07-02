package dev.jhyub;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private static boolean isWhitespace(int c) {
        return c == ' ' || c == '\r' || c == '\t';
    }

    private static boolean isParentheses(int c) {
        return c == '(' || c == ')';
    }

    public static List<String> tokenize(String s) throws IOException {
        PushbackInputStream pbis = new PushbackInputStream(new ByteArrayInputStream(s.getBytes()));
        List<String> tokens = new ArrayList<>();

        while (pbis.available() > 0) {
            int c = pbis.read();
            if (isWhitespace(c)) continue;
            if (c == '\n') break;

            StringBuilder sb = new StringBuilder();
            sb.append((char) c);

            if (isParentheses(c)) {

            } else if (c == '"') {
                do {
                    c = pbis.read();
                    sb.append((char) c);
                } while (c != '"' && pbis.available() > 0);
            } else {
                do {
                    c = pbis.read();
                    if (isWhitespace(c) || isParentheses(c)) {
                        pbis.unread(c);
                        break;
                    }
                    sb.append((char) c);
                } while (!isWhitespace(c) && !isParentheses(c) && pbis.available() > 0);
            }
            tokens.add(sb.toString());
        }

        return tokens;
    }
}
