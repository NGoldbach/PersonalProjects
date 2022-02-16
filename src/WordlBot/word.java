package WordlBot;

public class word {
    public char c0;
    public char c1;
    public char c2;
    public char c3;
    public char c4;
    public int ic0;
    public int ic1;
    public int ic2;
    public int ic3;
    public int ic4;
    public int maxvalue;

    public int patternCode(){
        String code = "";
        String word = this.fullWord();
        code = code+this.ic0+this.ic1+this.ic2+this.ic3+this.ic4;
        int a = Integer.parseInt(code);
        return a;
    }
    public String fullWord(){
        String a = ""+c0+c1+c2+c3+c4;
        return a;
    }
    public word(char a,char b, char c, char d, char e){
        this.c0 = a;
        this.c1 = b;
        this.c2 = c;
        this.c3 = d;
        this.c4 = e;
    }
}
