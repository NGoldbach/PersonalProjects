package MaysUbungen.Aufgaben3;

import java.util.Scanner;

public class Aufgabe2 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        StringBuilder myString = new StringBuilder();
        int limit = eingabe.nextInt();
        for(int x = 0;  (limit>0)?x<=limit:x>=limit;  x=(limit>0)?x+1:x-1){
           myString.append((x!=limit)? x+",":x);
        }
        String finishedProduct = myString.toString();
        System.out.println(finishedProduct);
    }
}
