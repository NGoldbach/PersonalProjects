package MaysUbungen.Aufgaben6;

import java.util.Scanner;

public class ArraySortieren {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        System.out.println("Wie viele Werte möchtest du maximal eingeben?");
        int[] zahlen = new int[eingabe.nextInt()];
        int counter = 0;
        System.out.println("Okay, gib nun nacheinander deine Werte ein. Sobald du fertig bist, gib fertig ein. Du musst nicht alle stellen füllen");
        while(eingabe.hasNextInt()){
            zahlen[counter] = eingabe.nextInt();
            counter++;
        }
        eingabe = new Scanner(System.in);
        System.out.println("Gib true ein, wenn es von max to min sortiert werden soll. Gib false für das Gegenteil ein");
        sortArray(zahlen, eingabe.nextBoolean());
        System.out.println("Möchtest du den index bei der Ausgabe auch sehen? true oder false eingeben.");
        printArray(zahlen,eingabe.nextBoolean());
    }

    public static void sortArray(int[] array, boolean max) {
        for (int y = 0; y < array.length; y++) {
            int minmax = array[y];
            int minmaxindex = y;
            for (int x = y; x < array.length; x++) {
                if ((max) ? array[x] > minmax : array[x] < minmax) {
                    minmax = (max) ? Math.max(array[x], minmax) : Math.min(array[x], minmax);
                    minmaxindex = x;
                }
            }
            array[minmaxindex] = array[y];
            array[y] = minmax;
        }
    }

    public static void printArray(int[] array, boolean index){
        for(int x = 0; x<array.length; x++){
            System.out.print((index)? "index"+x+" = "+array[x]:array[x]);
            if(x!=array.length-1) System.out.print(", ");
        }
    }
}