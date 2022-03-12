
public class test {
    public static void main(String[] args) {
        System.out.println(fraction(5));

    }
    public static double fraction(double number){
        if (number==1) return 1;
        else return fraction(number-1)-(1/(number*(number-1)));
    }
}


