package ot.internal;

public class Main {
    public static void main(String[] args) throws ValidationException {
        Text aliceText = Text.empty();
        Text bobsText = Text.empty();
        Changes aliceChange = aliceText.diff("Hi ");
        Changes bobsChange = bobsText.diff("Alice");
        for(Change ch : aliceChange.changes){
           ch.revision = 24;
        }
        for(Change ch : bobsChange.changes){
            ch.revision = 3;
        }

        String aliceSerialized = IO.toString(aliceChange);
        String bobSerialized = IO.toString(bobsChange);

        System.out.println(aliceSerialized);
        System.out.println(bobSerialized);

        Changes aliceRecovered = (Changes) IO.fromString(aliceSerialized);
        Changes bobRecovered = (Changes) IO.fromString(bobSerialized);

        System.out.println(IO.toString(aliceRecovered));
        System.out.println(IO.toString(bobRecovered));
        System.out.println(aliceRecovered.changes.get(0).revision);
        System.out.println(bobRecovered.revision);
    }
}
