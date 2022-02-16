package WordlBot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class theBot {

    public static ArrayList<String> wordlist = new ArrayList();
    public static int bestindex = 0;
    public static double bestinfo = 0;
    public static word[] wordObjectList;
    public static double averagebit;

    public static void makeWordArray() throws Exception {
        wordlist.clear();
        BufferedReader br = new BufferedReader(
                new FileReader(theBot.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/WordlBot/words.txt")
        );
        String cLine = br.readLine();
        while (cLine != null) {
            wordlist.add(cLine);
            cLine = br.readLine();
        }
    }

    public static void makewordObjectList() {
        word[] tempList = new word[wordlist.size()];
        int tempListPos = 0;
        for (String x : wordlist) {
            tempList[tempListPos++] = new word(x.charAt(0), x.charAt(1), x.charAt(2), x.charAt(3), x.charAt(4));
        }
        wordObjectList = tempList;
    }

    public static String calculateBestWord() {
        makewordObjectList();
        bestinfo = 0;
        bestindex = 0;
        for (int x = 0; x < wordlist.size(); x++) {
            wordEvaluator(wordlist.get(x), x);
        }
        String answer = "The best word is now " + wordlist.get(bestindex) + ". It offers this much information on average:\n" + String.format("%.5f", bestinfo) + " Bits.";
        averagebit = averagebit/wordlist.size();
        return answer;
    }

    public static void icEvaluator(String currentWord, word x) {
        x.ic0 = (x.fullWord().indexOf(currentWord.charAt(0)) != -1) ? 1 : 0;
        x.ic0 = (x.c0 == currentWord.charAt(0)) ? x.ic0 + 1 : x.ic0;
        x.ic1 = (x.fullWord().indexOf(currentWord.charAt(1)) != -1) ? 1 : 0;
        x.ic1 = (x.c1 == currentWord.charAt(1)) ? x.ic1 + 1 : x.ic1;
        x.ic2 = (x.fullWord().indexOf(currentWord.charAt(2)) != -1) ? 1 : 0;
        x.ic2 = (x.c2 == currentWord.charAt(2)) ? x.ic2 + 1 : x.ic2;
        x.ic3 = (x.fullWord().indexOf(currentWord.charAt(3)) != -1) ? 1 : 0;
        x.ic3 = (x.c3 == currentWord.charAt(3)) ? x.ic3 + 1 : x.ic3;
        x.ic4 = (x.fullWord().indexOf(currentWord.charAt(4)) != -1) ? 1 : 0;
        x.ic4 = (x.c4 == currentWord.charAt(4)) ? x.ic4 + 1 : x.ic4;
    }

    public static void wordEvaluator(String currentWord, int wordIndex) {
        int[] patternArray = new int[22223];
        double currentWordinfo = 0;
        for (word x : wordObjectList) {
            icEvaluator(currentWord, x);
            patternArray[x.patternCode()] = patternArray[x.patternCode()] + 1;
        }
        for (int x : patternArray) {
            if (x > 0) {
                double currentLength = wordlist.size();
                double probabilityForX = x / currentLength;
                double reducingFactor = currentLength / x;
                double informationAmount = Math.log(reducingFactor) / Math.log(2);
                currentWordinfo = currentWordinfo + (probabilityForX * informationAmount);
            }
        }
        averagebit = averagebit+currentWordinfo;
        if (currentWordinfo > bestinfo) {
            bestindex = wordIndex;
            bestinfo = currentWordinfo;
            for (word x : wordObjectList) {
                x.maxvalue = x.patternCode();
            }
        }
    }

    public static void wordArrayEdit(int result) {
        ArrayList<String> templist = new ArrayList();
        for (int x = 0; x < wordlist.size(); x++) {
            if (wordObjectList[x].maxvalue == result) {
                templist.add(wordlist.get(x));
            }
        }
        wordlist = templist;
    }

    public static void main(String[] args) throws Exception {
        makeWordArray();
        int botResult;
        while (true) {
            System.out.println(calculateBestWord());
            System.out.println("The average amount of expected information for any word is: "+averagebit);
            Scanner eingabe = new Scanner(System.in);
            System.out.println("Wie war das result? Nutze bitte 01212 als Format. 0 = Nix, 1 = Gelb, 2 = Grün");
            botResult = eingabe.nextInt();
            wordArrayEdit(botResult);
            if (botResult == 22222) {
                System.out.println("Lösung gefunden!");
                break;
            }
            System.out.println("Es gibt noch " + wordlist.size() + " Möglichkeiten.");
        }
    }
}
