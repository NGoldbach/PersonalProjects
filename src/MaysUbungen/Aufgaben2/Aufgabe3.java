package MaysUbungen.Aufgaben2;

import java.util.Scanner;

public class Aufgabe3 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int a = eingabe.nextInt();
        int b = eingabe.nextInt();
        int c = eingabe.nextInt();
        int loesung = (a>b)? a:b;
        loesung = (loesung>c)? loesung:c;
        System.out.println(loesung);
    }
}