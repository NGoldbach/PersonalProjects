package MaysUbungen.Aufgaben1;

import java.util.Scanner;

public class Aufgabe4 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        double kosten = eingabe.nextDouble();
        // Was die Eingabe angeht: Komma statt Punkt. Also 5,20 und nicht 5.20, ansonsten Error(dies könnte umgedreht sein, sollte es aber nicht)
        String kostensatz = "Der Apfel kostet "+String.format("%.2f",kosten)+"€.";
        System.out.println(kostensatz);
        System.out.println();
    }
}
