package dev.jhyub;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the mal REPL!");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("user> ");
            System.out.flush();
            String s = sc.nextLine();
            try {
                System.out.println(REPL.rep(s));
            } catch (IOException ignored) {

            }
        }
    }
}