package ScrabbleBot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScrabbleGUI {
    public static JTextField wordInputArea;
    public static int inputCycle = 0;
    public static JButton[] buttonArray;
    public static int pos1;
    public static int pos2;
    public static String savedWord = "";
    public static JTextArea words = new JTextArea(20,20);
    public static JTextField myHand = new JTextField();

    public static void buttonArraySetup(){
        buttonArray = new JButton[225];
        int counter = 0;
        for(int x = 0;x<225;x++) {
            JButton buttonTemplate = new JButton();
            buttonTemplate.setFont(new Font(Font.SERIF,1,50));
            buttonTemplate.setBackground(Color.white);
            buttonTemplate.setText("");
            buttonTemplate.setBorder(BorderFactory.createLineBorder(Color.black));
            buttonTemplate.setName(Integer.toString(counter++));
            buttonTemplate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    switch(inputCycle) {
                        case 1:
                            pos1 = Integer.parseInt(buttonTemplate.getName());
                            inputCycle++;
                            break;
                        case 2:
                            inputCycle = 0;
                            pos2 = Integer.parseInt(buttonTemplate.getName());
                            addWord();
                            break;
                        default:
                            break;
                    }
                }
            });
            buttonArray[x] = buttonTemplate;
        }
    }

    public static void addWord(){
        boolean isHorizontal = (pos2-pos1)<15;
        if(isHorizontal){
            for(int x = 0;x<savedWord.length();x++){
                buttonArray[(pos1+x)].setText(""+savedWord.charAt(x));
            }
        }else{
            for (int x= 0;x<savedWord.length();x++){
                buttonArray[(pos1+(x*15))].setText(""+savedWord.charAt(x));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        JFrame boardFrame = new JFrame();
        boardFrame.setSize(800,800);
        boardFrame.setTitle("Scrabble Board!");
        boardFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        boardFrame.setResizable(false);

        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(15,15));
        boardPanel.setBackground(Color.white);
        buttonArraySetup();
        for(JButton x :buttonArray){
            boardPanel.add(x);
        }
        boardFrame.add(boardPanel);
        boardFrame.setVisible(true);
        boardFrame.setLocationRelativeTo(null);



        JFrame interfaceFrame = new JFrame();
        interfaceFrame.setSize(800,800);
        interfaceFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        interfaceFrame.setResizable(false);

        JPanel interfacePanel = new JPanel();
        interfacePanel.setLayout(new GridLayout(2,2));
        wordInputArea = new JTextField();
        wordInputArea.setFont(new Font(Font.SERIF,1,50));
        wordInputArea.setBackground(Color.black);
        wordInputArea.setForeground(Color.white);
        wordInputArea.setHorizontalAlignment(wordInputArea.CENTER);
        wordInputArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(wordInputArea.getText().equals("delete all")){
                    for(JButton x :buttonArray){
                        x.setText("");
                    }
                    wordInputArea.setText("");
                    return;
                }
                if(inputCycle == 0){
                    inputCycle++;
                    savedWord = wordInputArea.getText().toUpperCase();
                    wordInputArea.setText("");
                }
            }
        });

        JButton calculateWord = new JButton();
        calculateWord.setText("Calculate Word");
        calculateWord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateAnswer();
            }
        });

        words.setFont(new Font(Font.SERIF,1,25));
        words.setText("Hello!");
        words.setLineWrap(true);
        words.setWrapStyleWord(true);
        words.setEditable(false);
        words.setBackground(Color.black);
        words.setForeground(Color.white);

        myHand.setFont(new Font(Font.SANS_SERIF,1,75));
        myHand.setBackground(Color.black);
        myHand.setForeground(Color.white);
        myHand.setHorizontalAlignment(myHand.CENTER);
        myHand.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myHand.setText("");
            }
        });

        interfacePanel.add(wordInputArea);
        interfacePanel.add(calculateWord);
        interfacePanel.add(words);
        JScrollPane scroll = new JScrollPane(words);
        interfacePanel.add(scroll);
        interfacePanel.add(myHand);
        interfaceFrame.add(interfacePanel);
        interfaceFrame.setVisible(true);

        scrabbleCalculator.sWLSetup();
    }
    public static void calculateAnswer(){
        scrabbleCalculator.totalCalcs = 0;
        scrabbleCalculator.existingStrings.clear();
        scrabbleCalculator.calculateExistingStrings(buttonArray);
        scrabbleCalculator.filterWithStrings();
        scrabbleCalculator.filterWithHand(myHand.getText());
        StringBuilder sb = new StringBuilder();
        sb.append("These are the best words in order:\n\n");
        for(String x: scrabbleCalculator.filteredList){
            sb.append(x+" Points \n");
        }
        sb.append("\nEstimation of amount of required calcs/steps to solve this: "+scrabbleCalculator.totalCalcs);
        words.setText(sb.toString());
    }
}

