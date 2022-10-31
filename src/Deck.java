import java.util.*;

public class Deck {
    List<Card> cards = new ArrayList<>();

    private final Comparator<Card> cardValueComparator = Comparator.comparingInt(Card::getSortValue); // private final Comparator<Card> cardValueComparator = (card1, card2) -> card1.getSortValue() - card2.getSortValue();
    private final Comparator<Card> cardSuitComparator = Comparator.comparingInt(Card::getSuitValue); // private final Comparator<Card> cardSuitComparator = (card1, card2) -> card1.cardSuit.value - card2.cardSuit.value;

    public Deck() {
        for (CardValue cardValue : CardValue.values()) {
            for (CardSuit cardSuit : CardSuit.values()) {
                Card card = new Card(cardValue, cardSuit);
                cards.add(card);
            }
        }
    }

    public int getRemainingCardCount() {
        return cards.size();
    }

    public Deck shuffle() {
        Collections.shuffle(cards);
        return this;
    }

    public List<Card> sortDeck(boolean byValue, boolean bySuit) {
        if (byValue) {
            Collections.sort(cards, cardValueComparator);
        }
        if (bySuit) {
            Collections.sort(cards, cardSuitComparator);
        }
        return cards;
    }

    public List<Card> sortDeckInNumberOrder() {
        return sortDeck(true, false);
    }

    public List<Card> sortDeckIntoSuits() {
        return sortDeck(false, true);
    }

    public Card dealCard() {
        return cards.remove(cards.size() - 1);
    }

    @Override
    public String toString() {
        return cards.toString();
    }

    public static void testSortingMethods() {
        Deck deck = new Deck();

        System.out.println("New deck order:");
        System.out.println(deck);

        System.out.println("Shuffling:");
        System.out.println(deck.shuffle());

        System.out.println("Dealing card:");
        System.out.println(deck.dealCard());

        System.out.println("After dealing card:");
        System.out.println(deck);

        System.out.println("Suit order:");
        System.out.println(deck.sortDeckIntoSuits());

        System.out.println("Shuffling:");
        System.out.println(deck.shuffle());

        System.out.println("Number order:");
        System.out.println(deck.sortDeckInNumberOrder());
    }
}