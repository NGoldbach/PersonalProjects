package MaysUbungen.Aufgaben5;

import java.util.Locale;
import java.util.Scanner;

public class Aufgabe4 {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in).useLocale(Locale.ENGLISH);
        System.out.println("Gib deinen Text ein");
        String text = eingabe.nextLine();
        System.out.println("Gib deinen Code ein. Er muss eine Zahl größer 0 sein");
        int code = eingabe.nextInt();
        System.out.println("Schreibe true für codieren, false für decodieren");
        boolean codieren = eingabe.nextBoolean();
        StringBuilder newtext = new StringBuilder();
        for (int x = 0; x<text.length(); x++) {
            char y = verschieben(text.charAt(x), code, codieren);
            newtext.append(y);
        }
        System.out.println(newtext.toString());
    }

    public static char verschieben(char c, int code, boolean codieren) {
        if (Character.isLowerCase(c)) {
            code = berechnung(code * 5, codieren, false, false);
            c = (char) ((int) c - code);
            if (!Character.isLowerCase(c)) c = (codieren) ? (char) ((int) c + 26) : (char) ((int) c - 26);
        } else if (Character.isUpperCase(c)) {
            code = berechnung(code * code, codieren, true, false);
            c = (char) ((int) c + code);
            if (!Character.isUpperCase(c)) c = (codieren) ? (char) ((int) c - 26) : (char) ((int) c + 26);
        } else if (Character.isDigit(c)) {
            code = berechnung(code, codieren, false, true);
            c = (char) ((int) c - code);
            if (!Character.isDigit(c)) c = (codieren) ? (char) ((int) c + 10) : (char) ((int) c - 10);
        }
        return c;
    }

    public static int berechnung(int code, boolean codieren, boolean g, boolean z) {
        int limit = 15;
        if(g|z) limit = (g)? 25:5;
        while(code>limit){
            code = quersumme(code);
            if(g|z) code = (g)? code+5:code+1;
        }
        if(!codieren) code = code*(-1);
        return code;
    }

    public static int quersumme(int code) {
        int answer = 0;
        while(code!=0){
            answer = answer+code%10;
            code = code/10;
        }
        return answer;
    }
}
