import Helpers.STR;

public enum CardSuit {
    CLUBS(1, '?'),     // '\u2663'
    DIAMONDS(2, '?'),  // '\u2666
    HEARTS(3, '?'),    // '\u2665'
    SPADES(4, '?');    // '\u2660'

    public final int value;
    public final String label;
    public final char abbreviation;
    public final char symbol;

    private CardSuit(int value, char symbol) {
        this.value = value;
        this.label = STR.titleWord(this.name());
        this.abbreviation = this.label.charAt(0);
        this.symbol = symbol;
    }
}