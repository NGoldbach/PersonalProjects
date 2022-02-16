package MaysUbungen.Aufgaben3;

import java.util.Scanner;

public class Aufgabe5 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int zahl = 0;
        while(zahl<1){
            zahl = eingabe.nextInt();
        }
        String folge = ""+zahl;
        int maximum = zahl;
        int elemente = 1;
        while(zahl>1){
            elemente++;
            zahl = (zahl%2!=0) ? (zahl*3)+1 : zahl/2;
            folge = folge+", "+zahl;
            maximum = (zahl>maximum) ? zahl:maximum; //alternative : maximum = Math.max(zahl, maximum);
        }
        System.out.println(folge);
        System.out.println("Höchster Wert = "+maximum);
        System.out.println("Anzahl der Elemente = "+elemente);
    }
}
