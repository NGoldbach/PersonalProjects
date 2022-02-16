package WordlBot;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordlGUI {
    public static theBot bot;
    public static boolean wordCycle = true;
    public static boolean differentWord = false;
    public static JTextField textField;
    public static JButton answerButton;
    public static JTextArea textArea;

    public static void useInput(){
        if (!wordCycle) {
            String dWord = "You used the word " + theBot.wordlist.get(theBot.bestindex) + "." +
                    "\nIt offered this amount of expected information instead: " + String.format("%.5f", theBot.bestinfo) + " bits\n\n";
            theBot.wordArrayEdit(textFieldConverter(textField.getText()));
            textField.setText("");
            if (theBot.wordlist.size() <= 16) {
                String a = "";
                for (String x : theBot.wordlist) {
                    a = a + x + "\n";
                }
                textArea.setText(((differentWord) ? dWord : "") + "These are the only remaining words:\n" + a + theBot.calculateBestWord());
            } else {
                textArea.setText(((differentWord) ? dWord : "")
                        + theBot.calculateBestWord()
                        +"\n\nThe average amount of expected information per word is: "+theBot.averagebit+" Bits."
                        +"\n\nThe remaining amount of possible words is: " + theBot.wordlist.size());
            }
            wordCycle = true;
            differentWord = false;
            answerButton.setText("Enter Word");
        } else {
            if (!(textField.getText().equals(theBot.wordlist.get(theBot.bestindex)))) {
                theBot.bestinfo = 0;
                theBot.bestindex = 0;
                theBot.wordEvaluator(textField.getText(), theBot.wordlist.indexOf(textField.getText()));
            }
            wordCycle = false;
            textField.setText("");
            differentWord = true;
            answerButton.setText("Enter Result");
        }
    }

    public static void main(String[] args) throws Exception {
        Font textFont = new Font(Font.SERIF, 1, 25);
        bot = new theBot();

        JFrame frame = new JFrame();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("World Bot!");
        frame.setSize(800, 600);

        JPanel MainPanel = new JPanel();
        MainPanel.setLayout(new GridLayout(2, 2));
        textField = new JTextField();
        textField.setFont(new Font(Font.SERIF, 1, 125));
        textField.setBackground(Color.black);
        textField.setForeground(Color.white);

        textArea = new JTextArea(20, 20);
        theBot.makeWordArray();
        theBot.makewordObjectList();
        theBot.wordEvaluator("tares", 10694);
        String textSetup = "The best word is " + theBot.wordlist.get(theBot.bestindex) +
                ". It offers this much information on average:\n" + String.format("%.5f", theBot.bestinfo) + " Bits."
                +"\n\nThe average expected amount of information per word is: 4.54606 Bits.";
        textArea.setText(textSetup);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(textFont);
        textArea.setBackground(Color.black);
        textArea.setForeground(Color.white);

        answerButton = new JButton();
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useInput();
            }
        });
        answerButton.setText("Enter Word");
        answerButton.setFont(textFont);

        JButton restartButton = new JButton();
        restartButton.setText("Restart Game");
        restartButton.setFont(textFont);
        restartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                theBot.wordlist.clear();
                try {
                    theBot.makeWordArray();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                theBot.makewordObjectList();
                theBot.bestinfo = 0;
                theBot.bestindex = 0;
                theBot.wordEvaluator("tares", 10694);
                String textSetup = "The best word is " + theBot.wordlist.get(theBot.bestindex) +
                        ". It offers this much information:\n" + String.format("%.5f", theBot.bestinfo) + " Bits."
                        +"\n\nThe average expected amount of information per word is: 4.54606 Bits.";
                textArea.setText(textSetup);
            }
        });

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                useInput();
            }
        });
        MainPanel.add(textField);
        MainPanel.add(answerButton);
        MainPanel.add(textArea);
        JScrollPane txtscroll = new JScrollPane(textArea);
        MainPanel.add(txtscroll);
        MainPanel.add(restartButton);
        frame.add(MainPanel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public static int textFieldConverter(String text) {
        text.toLowerCase();
        String converted = "";
        for (int x = 0; x < 5; x++) {
            switch (text.charAt(x)) {
                case 'n':
                    converted = converted + "0";
                    break;
                case 'y':
                    converted = converted + "1";
                    break;
                case 'g':
                    converted = converted + "2";
                    break;
                default:
                    break;
            }
        }
        return Integer.parseInt(converted);
    }
}
