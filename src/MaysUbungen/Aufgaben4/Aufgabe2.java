package MaysUbungen.Aufgaben4;

import java.util.Scanner;

public class Aufgabe2 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.println("Antworte auf jede Frage bitte einfach nur mit einer Zahl.");
        System.out.println("Deine Zahl?:");
        int zahl = eingabe.nextInt();
        System.out.println("An welcher Binärstelle soll etwas geändert werden?:");
        int stelle = eingabe.nextInt();
        System.out.println("Soll an jener Stelle der Wert auf 1 oder auf 0 gesetzt werden?:");
        boolean aufEinsSetzen = eingabe.nextInt()==1;
        int bitmaske = (aufEinsSetzen)? (1 << stelle):~(1 << stelle);
        int vorherigerWert = ((zahl&(1<<stelle))!=0)? 1:0;
        zahl = (aufEinsSetzen)? zahl|bitmaske:zahl&bitmaske;
        System.out.println("An der "+stelle+". Stelle deiner Zahl stand vorher eine "+vorherigerWert+". Dieser Wert soll auf "+((aufEinsSetzen)?1:0)+" geändert werden.");
        System.out.println("Dein neuer Zahlenwert ist: "+zahl);
    }
}
