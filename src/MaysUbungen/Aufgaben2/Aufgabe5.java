package MaysUbungen.Aufgaben2;

import java.util.Scanner;

public class Aufgabe5 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int a = eingabe.nextInt();
        int b;
        a = (a>(b = eingabe.nextInt())) ? a:b;
        a = (a>(b = eingabe.nextInt())) ? a:b;
        a = (a>(b = eingabe.nextInt())) ? a:b;
        a = (a>(b = eingabe.nextInt())) ? a:b;
        System.out.println(a);
        //example with just 1 variable below, using Math.max(this simply checks which one is bigger)
        a = eingabe.nextInt();
        a = Math.max(a,eingabe.nextInt());
        a = Math.max(a,eingabe.nextInt());
        a = Math.max(a,eingabe.nextInt());
        a = Math.max(a,eingabe.nextInt());
        System.out.println(a);
    }
}
