package MaysUbungen.Aufgaben2;

import java.util.Scanner;

public class Aufgabe4 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int a = eingabe.nextInt();
        int b = eingabe.nextInt();
        int c = eingabe.nextInt();
        int loesung = (a>b)? (a>c)?a:c : (b>c)?b:c;
        System.out.println(loesung);
    }
}
