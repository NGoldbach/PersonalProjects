package MaysUbungen.Aufgaben2;


import java.util.Scanner;

public class Aufgabe7 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int anzahlRichtig = 0;

        System.out.println("Ist Rot eine Farbe?");
        if (eingabe.nextBoolean()) {
            System.out.println("Die Antwort ist korrekt.");
            anzahlRichtig++;
        } else {
            System.out.println("Die Antwort ist falsch.");
        }

        System.out.println("Ist 4 eine Zahl?");
        if (eingabe.nextBoolean()) {
            System.out.println("Die Antwort ist korrekt.");
            anzahlRichtig++;
        } else {
            System.out.println("Die Antwort ist falsch.");
        }

        System.out.println("Ist 2 größer als 3?");
        if (eingabe.nextBoolean()) {
            System.out.println("Die Antwort ist falsch.");
        } else {
            System.out.println("Die Antwort ist korrekt.");
            anzahlRichtig++;
        }
        System.out.println();
        System.out.println("Anzahl der korrekt beantworteten Fragen:" + anzahlRichtig);
        System.out.println("Anzahl der falsch beantworteten Fragen:" + (3 - anzahlRichtig));
    }
}
