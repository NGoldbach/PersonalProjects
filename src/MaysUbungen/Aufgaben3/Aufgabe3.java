package MaysUbungen.Aufgaben3;

import java.util.Scanner;

public class Aufgabe3 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.println("Welche Farbe gefällt dir am meisten von diesen: Rot,Blau,Gelb,Pink oder Schwarz?");
        String farbe = eingabe.nextLine();
        farbe = farbe.toLowerCase();
        switch(farbe){
            case "rot":
                System.out.println("rot");
                break;
            case "blau":
                System.out.println("blau");
                break;
            case "gelb":
                System.out.println("gelb");
                break;
            case "pink":
                System.out.println("pink");
                break;
            case "schwarz":
                System.out.println("schwarz");
                break;
            default:
                System.out.println("Diese Farbe war nicht Teil der Auswahl.");
                break;
        }
    }
}
