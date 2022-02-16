package MaysUbungen.Aufgaben3;

import java.util.Scanner;

public class Aufgabe4 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        int zahl = eingabe.nextInt();
        System.out.println("Deine Zahlenreihenfolge lautet:");
        switch(zahl){
            case 1:
                System.out.println(1);
            case 2:
                System.out.println(2);
            case 3:
                System.out.println(3);
            case 4:
                System.out.println(4);
            case 5:
                System.out.println(5);
                break;
            default:
                System.out.println("Du hast keine Zahl zwischen 1 und 5 gewählt.");
        }
        if(1<=zahl&&5>=zahl){
            for(int x = 1;x<zahl;x++){
                System.out.println(x);
            }
        }
    }
}
