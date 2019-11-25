package com.yangcc.Lambda.methodReference;

public class MethodMain {
    public static void main(String[] args) {
        printString((s)->{
            System.out.println(s);
        });
        printString(System.out::println);
    }
    private static void printString(Printable p){
        p.print("hellow");
    }
}
