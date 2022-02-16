package MaysUbungen.Aufgaben1;

import java.util.Scanner;

public class Aufgabe5 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int kostenint = eingabe.nextInt();
        String kostensatz = "Der Apfel kostet "+kostenint+" Euro und ";
        kostenint = eingabe.nextInt();
        kostensatz = kostensatz+kostenint+" Cent.";
        System.out.println(kostensatz);
        System.out.println();
    }
}
