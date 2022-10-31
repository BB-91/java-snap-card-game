import java.util.Comparator;

public class Card implements Comparable<Card> {
    final CardValue cardValue;
    final CardSuit cardSuit;
    final String fullName;
    final String abbreviation;
    final String printedName;

    public Card(CardValue cardValue, CardSuit cardSuit) {
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;

        fullName = cardValue.label + " of " + cardSuit.label;
        abbreviation = cardValue.abbreviation + cardSuit.abbreviation;

        printedName = abbreviation;
    }

    @Override
    public String toString() {
        return printedName;
    }

    public int getSortValue(){
        return (cardValue.value * 100) + cardSuit.value;
    }

    public int getSuitValue(){
        return cardSuit.value;
    }

    @Override
    public int compareTo(Card card) {
        return this.getSortValue() - card.getSortValue();
    }
}