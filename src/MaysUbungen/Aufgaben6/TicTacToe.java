package MaysUbungen.Aufgaben6;


import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int player = 2;
        int[][] gameboard = new int[3][3];
        while (!checkComplete(gameboard, player)) {
            player = (player != 1) ? 1 : 2;
            printBoard(gameboard);
            readInput(gameboard, player);
        }
    }

    public static boolean alternateCheckComplete(int[][] gameboard, int player){
        boolean win = false;
        int[] felder = new int[9];
        int counter = 0;
        for(int[] x:gameboard){
            for(int y: x){
                felder[counter++] = y;
            }
        }
        for(int x = 0;x<3;x++){
            win = alternateCheckField(felder, player, x, 3) || win;
            win = alternateCheckField(felder, player, x*3, 1) || win;
        }
        win = alternateCheckField(felder, player, 0, 4) || win;
        win = alternateCheckField(felder, player, 2, 2) || win;
        if(win) return true;
        for(int x:felder){if (x == 0) return false;}
        return true;
    }

    public static boolean alternateCheckField(int[] felder, int player, int startwert, int delta){
        int counter = 0;
        for(int x = 0;x<3;x++){
            counter = (felder[startwert]==player)? counter + 1 : counter;
            startwert = startwert + delta;
        }
        if (counter==3) return true;
        else return false;
    }

    public static boolean checkComplete(int[][] gameboard, int player) {
        boolean win = false;
            for (int x = 0; x < 8; x++) {
                if (x < 3) win = checkField(gameboard, x, 0, 0, 1, player);
                else if (x < 6) win = checkField(gameboard, 0, x - 3, 1, 0, player);
                else if (x == 7) win = checkField(gameboard, 0, 0, 1, 1, player);
                else win = checkField(gameboard, 0, 2, 1, -1, player);
                if (win) {
                    printBoard(gameboard);
                    System.out.println("\nDas Spiel ist beendet. Spieler " + player + " hat gewonnen!");
                    return true;
                }
            }
        for (int[] x : gameboard) {
            for (int y : x) {
                if (y == 0) return false;
            }
        }
        printBoard(gameboard);
        System.out.println("Das Spiel ist beendet. Keiner der Spieler hat gewonnen.");
        return true;
    }

    public static boolean checkField(int[][] gameboard, int zeile, int spalte, int d, int r, int player) {
        int wincounter = 0;
        for (int z = 0; z < 3; z++) {
            wincounter = (gameboard[zeile][spalte] == player) ? wincounter + 1 : wincounter;
            zeile = zeile + d;
            spalte = spalte + r;
        }
        return wincounter == 3;
    }

    public static void printBoard(int[][] gameboard) {
        System.out.println();
        int counter = 0;
        int linecounter = 0;
        for (int[] x : gameboard) {
            for (int y : x) {
                if (counter < 2) {
                    counter++;
                    System.out.print(" " + y + " |");
                } else {
                    System.out.println(" " + y);
                    counter = 0;
                }
            }
            if (linecounter < 2) {
                linecounter++;
                System.out.println("-----------");
            } else System.out.println();
        }
    }

    public static void readInput(int[][] gameboard, int player) {
        Scanner eingabe = new Scanner(System.in);
        boolean validInput = false;
        int[] validCode = {0, 1, 2, 10, 11, 12, 20, 21, 22};
        while (!validInput) {
            System.out.println("\nBitte gib deinen nächsten Zug an. Nutze zwei Ziffern, zb. 02, um Zeile/Spalte anzugeben\n");
            String pos = eingabe.nextLine();
            if (Arrays.stream(validCode).anyMatch(i -> i == Integer.parseInt(pos))) {
                validInput = gameboard[Character.getNumericValue(pos.charAt(0))][Character.getNumericValue(pos.charAt(1))] == 0;
                if (validInput) {
                    gameboard[Character.getNumericValue(pos.charAt(0))][Character.getNumericValue(pos.charAt(1))] = player;
                } else System.out.println("Diese Position ist bereits besetzt. Prozess wird nun wiederholt.");
            } else System.out.println("Du hast einen inkorrekten Zug angegeben. Prozess wird nun wiederholt");
        }
    }
}