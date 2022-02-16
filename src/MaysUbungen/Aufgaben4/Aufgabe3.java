package MaysUbungen.Aufgaben4;

public class Aufgabe3 {
    public static void main(String[] args) {
        int intDarstellung = 8;
        String stringDarstellung = "0001010";
        int idLength = 1;
        while((Math.pow(2,idLength)-1)<intDarstellung){
            idLength++;
        }
        int iDChange = 0;
        for(int x = 0;x<idLength;x++){
            iDChange = iDChange+(((intDarstellung&(1<<x))!=0)?0:1);
            intDarstellung = intDarstellung|1<<x;
        }
        int sDChange = 0;
        String sDneu = "";
        for(int x = 0; x<stringDarstellung.length();x++){
            sDChange = sDChange + ((stringDarstellung.charAt(x)=='0')?1:0);
            sDneu = sDneu+"1";
        }
        System.out.println("intDarstellung = "+intDarstellung+". Es mussten "+iDChange+" nullen verändert werden.");
        System.out.println("stringDarstellung = "+sDneu+". Es mussten "+sDChange+" nullen verändert werden.");
    }
}
