import java.util.Scanner;

abstract class CardGame{
    public final String name;
    public final int playerCount;
    public int turnPlayerNumber = 1;

    protected Deck deckOfCards = new Deck();
    protected Card lastPlayedCard;
    protected final Scanner scanner = new Scanner(System.in);

    public CardGame(String name, int playerCount){
        this.name = name;
        this.playerCount = playerCount;
        deckOfCards.shuffle();
    }

    protected enum EndState {
        WIN,
        LOSE,
        DRAW
    }

    protected final void resetGlobalGameVars() {
        deckOfCards = new Deck();
        deckOfCards.shuffle();
        lastPlayedCard = null;
        turnPlayerNumber = 1;
    }

    protected abstract void startGame();
    protected abstract void nextTurn();
    protected abstract void endGame();
    protected abstract void resetLocalGameVars();
}
