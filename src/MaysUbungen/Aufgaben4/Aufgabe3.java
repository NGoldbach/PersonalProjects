package MaysUbungen.Aufgaben4;

public class Aufgabe3 {
    public static void main(String[] args) {
        int intDarstellung = 8;
        int idLength = 0;
        int change = 0;
        do {
            change = (intDarstellung % 2 == 0) ? change + 1 : change;
            intDarstellung = intDarstellung >> 1;
            idLength++;
        } while (intDarstellung > 0);
        intDarstellung = (int) (Math.pow(2, idLength) - 1);
        System.out.println("intDarstellung = " + intDarstellung + ". Es mussten " + change + " nullen verändert werden.");

        change = 0;
        String stringDarstellung = "0001010";
        StringBuilder sDneu = new StringBuilder();
        for (int x = 0; x < stringDarstellung.length(); x++) {
            change = change + ((stringDarstellung.charAt(x) == '0') ? 1 : 0);
            sDneu.append("1");
        }
        System.out.println("stringDarstellung = " + sDneu + ". Es mussten " + change + " nullen verändert werden.");
    }
}
