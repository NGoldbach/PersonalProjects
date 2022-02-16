package MaysUbungen.Aufgaben4;


import java.util.Scanner;

public class Aufgabe1 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);
        boolean weiter = true;
        while ( weiter ){
            System.out.println("bin = Binär zu Dezimal, dec = Dezimal zu Binär");
            boolean toDeci = eingabe.nextLine().toLowerCase().equals("bin");
            System.out.println("Gib nun deine Zahl ein.");
            String input = eingabe.nextLine();
            if (toDeci) {
                double deci = 0;
                for (int x = 0; x < input.length(); x++) {
                    double temp = Character.getNumericValue(input.charAt(x));
                    deci = deci + (temp * Math.pow(2, (input.length() - 1 - x)));
                }
                System.out.println("In Dezimal: " + (int) deci);
            } else {
                int deci = Integer.parseInt(input, 10);
                String bina = "";
                while (deci != 0) {
                    bina = (deci % 2) + bina;
                    deci = deci / 2;
                }
                System.out.println("In Binär: " + bina);
            }
            System.out.println("Soll noch eine Zahl umgewandelt werden? Ja oder Nein?");
            weiter = eingabe.nextLine().toLowerCase().equals("ja");
        }
    }
}
