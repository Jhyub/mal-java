package dev.jhyub;

public class REPL {
    public static String read(String s) {
        return s;
    }

    public static String eval(String s) {
        return s;
    }

    public static String print(String s) {
        return s;
    }

    public static String rep(String s) {
        var readRes = read(s);
        var evalRes = eval(readRes);
        return print(evalRes);
    }
}
