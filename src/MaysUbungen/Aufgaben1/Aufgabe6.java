package MaysUbungen.Aufgaben1;

import java.util.Scanner;

public class Aufgabe6 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        double kosten = eingabe.nextDouble();
        // Was die Eingabe angeht: Komma statt Punkt. Also 5,20 und nicht 5.20, ansonsten Error(dies könnte umgedreht sein, sollte es aber nicht)
        int euro = (int)kosten;
        int cent = (int)(kosten%1*100); //alternativ geht hier auch kosten-euro, würde ebenso den "Rest" ermitteln.
        String kostensatz = "Der Apfel kostet "+euro+" Euro und "+cent+" Cent.";
        System.out.println(kostensatz);
        System.out.println();
    }
}
