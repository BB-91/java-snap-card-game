import java.util.*;

public class Snap extends CardGame{
    public Snap() {
        super("Snap", 2);
    }

    private boolean timedOut = false;
    private boolean typedSnap = false;
    private int timerDurationInSeconds = 5;

    protected void resetLocalGameVars() {
        timedOut = false;
        typedSnap = false;
    }

    private void promptUserToTypeSnap() {
        System.out.println("'Hurry! Type '" + name + "' to win the game!");

        Timer timer = new Timer(true);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                timedOut = true;
            }
        }, timerDurationInSeconds * 1000);

        while (true) {
            if (timedOut || typedSnap) {
                break;
            } else {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase(name)) {
                    typedSnap = true;
                }
            }
        }

        if (typedSnap) {
            if (!timedOut) {
                printWinMessage("Typed '" + name + "' in time!");
            } else {
                printLoseMessage("Typed '" + name + "' too slow.");
            }
        } else {
            printLoseMessage("Didn't type '" + name + "'.");
        }
    }

    @Override
    public void startGame() {
        System.out.println("\nLet's play '" + name + "'!");
        nextTurn();
    }

    @Override
    public void endGame() {
        System.out.println("Game over.");
        System.out.println("Play again? y/n");
        String input = scanner.nextLine();
        switch (input) {
            case "y":
                resetLocalGameVars();
                resetGlobalGameVars();
                System.out.println("Restarting game.");
                startGame();
                break;
            case "n":
                System.out.println("Thanks for playing!");
                break;
            default:
                endGame();
        }
    }

    private void _printGameOverMessage(EndState endState, String prefix) {
        switch (endState) {
            case WIN, LOSE:
                String verb = endState == EndState.WIN ? "wins!" : "loses!";
                String message = prefix + " Player " + turnPlayerNumber + " " + verb;
                System.out.println(message);
                break;
            case DRAW:
                System.out.println("Game ended in a draw.");
        }
        endGame();
    }

    private void printWinMessage(String prefix) {
        _printGameOverMessage(EndState.WIN, prefix);
    }

    private void printLoseMessage(String prefix) {
        _printGameOverMessage(EndState.LOSE, prefix);
    }

    @Override
    public void nextTurn() {
        if (deckOfCards.getRemainingCardCount() == 0) {
            System.out.println("No more cards!");
        } else {
            Card currentCard = deckOfCards.dealCard();
            System.out.println("--- Player " + turnPlayerNumber + " drew: " + currentCard + " --- (Press 'Enter') ---");
            if (lastPlayedCard != null && (currentCard.cardSuit.label == lastPlayedCard.cardSuit.label)) {
                promptUserToTypeSnap();
            } else {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase(name)) {
                    printLoseMessage("Typed '" + name + "' at incorrect time.");
                } else {
                    turnPlayerNumber++;
                    if (turnPlayerNumber > playerCount) {
                        turnPlayerNumber = 1;
                    }
                    lastPlayedCard = currentCard;
                    nextTurn();
                }
            }
        }
    }
}
