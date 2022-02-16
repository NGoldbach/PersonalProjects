package MaysUbungen.Aufgaben3;

import java.util.Scanner;

public class Aufgabe6 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        String satz = eingabe.nextLine();
        for(int x = 0;x<satz.length();x++){
            System.out.println(satz.charAt(x));
        }
        int anzahl = 0;
        while(anzahl<satz.length()){
            System.out.println(satz.charAt(anzahl));
            anzahl++;
        }
    }
}
