package MaysUbungen.Aufgaben3;

import java.util.Scanner;

public class Aufgabe1 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int versuche = 0;
        System.out.println("Was ergibt 25 + 133?");
        while(true){
            versuche++;
            if( eingabe.nextInt()==158 ){
                System.out.println("Die Antwort ist korrekt.");
                break;
            } else{
                System.out.println("Die Antwort ist falsch. Versuche es erneut.");
            }

        }
        System.out.println("Nächste Frage:");
        System.out.println("Was ist 5-20?");
        boolean korrekt = false;
        while(!korrekt){
            versuche++;
            korrekt = eingabe.nextInt() == -15;
            System.out.println((korrekt)? "Die Antwort ist korrekt":"Die Antwort ist falsch. Versuche es erneut.");
        }
        System.out.println("Quiz fertig! Anzahl der nötigen Versuche: "+versuche);
    }
}
