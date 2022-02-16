package MaysUbungen.Aufgaben2;

public class Aufgabe6 {
    public static void main(String[] args) {
        String satz = "Dies ist ein Beispielsatz";
        boolean hatWort = satz.contains("ich");
        System.out.println( (hatWort)? "Das Wort existiert.":"Das Wort existiert nicht" );
    }
}
