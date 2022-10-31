import Helpers.STR;

public enum CardValue {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);
    public final int value;
    public final String label;
    public final String abbreviation;
    private CardValue(int value) {
        this.value = value;
        label = STR.titleWord(this.name());
        abbreviation = switch (value) {
            case 11, 12, 13, 14 -> this.name().substring(0, 1);
            default -> Integer.valueOf(value).toString();
        };
    }
}