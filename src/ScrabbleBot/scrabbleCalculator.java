package ScrabbleBot;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class    scrabbleCalculator {
    public static ArrayList<String> scrabbleWordList = new ArrayList();
    public static int[] scrabbleLetterPoints = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    public static ArrayList<String> existingStrings = new ArrayList();
    public static ArrayList<String> WLStringFiltered = new ArrayList();
    public static ArrayList<String> filteredList = new ArrayList();
    public static String[][] boardListPairings;
    public static int totalCalcs = 0;

    public static void sWLSetup() throws Exception {
        BufferedReader reader = new BufferedReader(
                new FileReader(scrabbleCalculator.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/ScrabbleBot/scrabblewords.txt")
        );
        String line = reader.readLine();
        while (line != null) {
            if(line.length()>2){scrabbleWordList.add(line);}
            line = reader.readLine();
        }
        System.out.println(scrabbleWordList.size());
    }

    public static int getLetterValue(char letter) {
        int letterIndex = Character.getNumericValue(letter) - 10;
        return scrabbleLetterPoints[letterIndex];
    }

    public static int calculateWordValue(String word) {
        int totalValue = 0;
        for (int x = 0; x < word.length(); x++) {
            totalValue = totalValue + getLetterValue(word.charAt(x));
            totalCalcs++;
        }
        return totalValue;
    }

    public static void calculateExistingStrings(JButton[] allBoardTiles) {
        existingStrings.clear();
        for (int x = 0; x < allBoardTiles.length; x++) {
            totalCalcs = totalCalcs+5;
            if (!allBoardTiles[x].getText().equals("")) {
                int maxpos = x;
                String word = "";
                if (isStartOfWord(allBoardTiles, x, true)) {
                    while (maxpos<224) {
                        maxpos++;
                        if(allBoardTiles[maxpos].getText().equals("")){
                            maxpos--;
                            break;
                        }
                    }
                    for (int pos = x; pos <= maxpos; pos++) {
                        word = word + allBoardTiles[pos].getText();
                    }
                    if(!existingStrings.contains(word.toLowerCase()))existingStrings.add(word.toLowerCase());
                }
                maxpos = x;
                word = "";
                if (isStartOfWord(allBoardTiles, x, false)) {
                    while (maxpos<210) {
                        maxpos = maxpos + 15;
                        if(allBoardTiles[maxpos].getText().equals("")){
                            maxpos=maxpos-15;
                            break;
                        }
                    }
                    for (int pos = x; pos <= maxpos; pos = pos + 15) {
                        word = word + allBoardTiles[pos].getText();
                    }
                    if(!existingStrings.contains(word.toLowerCase()))existingStrings.add(word.toLowerCase());
                }
            }
        }

    }

    public static boolean isStartOfWord(JButton[] allBoardTiles, int position, boolean horizontal) {
        boolean isStart;
        if (horizontal) {
            if ((position % 15) == 0) {
                isStart = true;
            } else if (position % 15 == 14) {
                isStart = false;
            } else {
                isStart = allBoardTiles[position - 1].getText().equals("");
            }
        } else {
            if (position > 209) {
                isStart = false;
            } else if (position < 15) {
                isStart = true;
            } else {
                isStart = allBoardTiles[position - 15].getText().equals("");
            }
        }
        return isStart;
    }
    public static void filterWithStrings(){
        WLStringFiltered.clear();
        ArrayList<String> tempSWL = new ArrayList();
        for(String x : scrabbleWordList){tempSWL.add(x);totalCalcs++;}
        for (String existStr: existingStrings){
            for(String scrabbleWord:tempSWL){
                totalCalcs++;
                if(scrabbleWord.contains(existStr)){
                    WLStringFiltered.add(scrabbleWord);
                }
            }
            tempSWL.removeAll(WLStringFiltered);
            totalCalcs++;
        }

        boardListPairings = new String[existingStrings.size()][WLStringFiltered.size()];
        for(int x = 0;x<boardListPairings.length;x++) {
            for (int y = 0; y < WLStringFiltered.size(); y++) {
                totalCalcs++;
                if (WLStringFiltered.get(y).contains(existingStrings.get(x))) {
                    boardListPairings[x][y] = WLStringFiltered.get(y);
                }
            }
        }
//        int test = 0;
//        for(String[] x:boardListPairings){
//            System.out.println("Current Word ============================================ " +existingStrings.get(test++));
//            for(String y:x){
//                if(y!=null){
//                System.out.println(y);
//                }
//            }
//            System.out.println();
//        }
//        System.out.println("Next run!");
    }
    public static void filterWithHand(String hand) {
        ArrayList<String> tempList = new ArrayList();
        int maxindex = 0;
        int maxvalue = 0;

        for (int x = 0; x < boardListPairings.length; x++) {
            String handCopy = hand + existingStrings.get(x);
            for (int y = 0; y < WLStringFiltered.size(); y++) {
                totalCalcs++;
                if (boardListPairings[x][y] == null) {
                    continue;
                }
                ArrayList<Character> handAndBoardCopy = new ArrayList();
                for (char z : handCopy.toCharArray()) {
                    totalCalcs++;
                    handAndBoardCopy.add(z);
                }
                boolean hasAll = true;
                for (int blep = 0; blep < boardListPairings[x][y].length(); blep++) {
                    totalCalcs++;
                    if (handAndBoardCopy.indexOf(boardListPairings[x][y].charAt(blep)) != -1) {
                        handAndBoardCopy.remove(handAndBoardCopy.indexOf(boardListPairings[x][y].charAt(blep)));
                    } else {
                        hasAll = false;
                        break;
                    }
                }
                if (hasAll) {
                    tempList.add(boardListPairings[x][y]);
                }
                totalCalcs++;
            }
        }
        filteredList.clear();
        int duration = tempList.size();
        for (int x = 0; x < duration; x++) {
            for (String z : tempList) {
                totalCalcs++;
                int value = calculateWordValue(z);
                maxindex = (value > maxvalue) ? tempList.indexOf(z) : maxindex;
                maxvalue = (value > maxvalue) ? value : maxvalue;
            }
            filteredList.add(tempList.get(maxindex) + " = " + maxvalue);
            tempList.remove(maxindex);
            maxindex = 0;
            maxvalue = 0;
            totalCalcs++;
        }
    }
}
