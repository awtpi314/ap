package ap.week14;

import ap.week14.Card.Rank;
import ap.week14.Card.Suit;

/**
 * <h3>DeckOfCards</h3>
 * <p>
 * This class represents a deck of cards. The constructor initializes the deck
 * in order, and {@link #shuffle() shuffle} can be called to shuffle the deck.
 * Shuffle is a three-pass shuffle system, iterating through the deck three
 * times. The method {@link #distributeToFourHands() distributeToFourHands}
 * returns a 2D card array with the four hands in it.
 * </p>
 * <p>
 * Finally, the sort method will sort the deck based on suit and rank.
 * </p>
 * 
 * @author awtpi314
 * @since 4 December 2020
 * @version 1.0.0
 * @see {@link ap.week14.Card}
 * @see {@link ap.week14.Card.Rank}
 * @see {@link ap.week14.Card.Suit}
 */
public class DeckOfCards {
    private final int MAX_SIZE = 52;
    private Card[] deck;

    /**
     * Constructs a deck of cards in order
     */
    public DeckOfCards() {
        deck = new Card[MAX_SIZE];
        final String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
        for (int i = 0; i < suits.length; i++) {
            for (int j = 1; j <= 13; j++) {
                deck[i * 13 + j - 1] = new Card(Suit.valueOf(suits[i]), Rank.getRankFromInt(j));
            }
        }
    }

    /**
     * Shuffles the deck using a three-pass shuffle to ensure better randomization.
     */
    public void shuffle() {
        // Three-pass shuffle
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < MAX_SIZE; j++) {
                int shuffleWith = (int) (Math.random() * MAX_SIZE);
                Card temp = deck[j];
                deck[j] = deck[shuffleWith];
                deck[shuffleWith] = temp;
            }
        }
    }

    /**
     * Distributes cards to four hands and returns those hands in a 2D
     * {@link ap.week14.Card Card} array.
     * 
     * @return the 2D array with the four hands
     */
    public Card[][] distributeToFourHands() {
        final int HAND_SIZE = 13;
        Card[][] hands = new Card[4][HAND_SIZE];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < HAND_SIZE; j++) {
                hands[i][j] = deck[j * 4 + i];
            }
        }

        return hands;
    }

    /**
     * Format a 2D {@link ap.week14.Card Card} array using hands format:
     * 
     * <pre>
     *Hand 1:
     *...
     *...
     *...
     *Hand 2:
     *...
     *...
     *...
     * </pre>
     * 
     * @param hands the 2D array to format
     * @return the formatted string
     */
    public String handsToString(Card[][] hands) {
        StringBuilder sb = new StringBuilder();
        int handCounter = 1;
        for (Card[] cards : hands) {
            sb.append("Hand " + handCounter++ + ":\n");
            for (Card card : cards) {
                sb.append(card.toString() + "\n");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Sorts the deck by suit and value
     */
    public void sort() {
        sortBySuit();
        sortByValue();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MAX_SIZE; i += 2) {
            sb.append(String.format("%s| %s\n", deck[i].toString(), deck[i + 1].toString()));
        }
        return sb.toString();
    }

    /**
     * Insertion sort the deck by suit
     */
    private void sortBySuit() {
        int n = MAX_SIZE;

        for (int i = 1; i < n; i++) {
            Card key = deck[i];
            int j = i - 1;

            while (j >= 0 && deck[j].getSuit().compareTo(key.getSuit()) > 0) {
                deck[j + 1] = deck[j];
                j--;
            }

            deck[j + 1] = key;
        }
    }

    /**
     * Divides the deck into four sections, which assumes that the deck is already
     * sorted by suit
     */
    private void sortByValue() {
        Card[] cardList = new Card[MAX_SIZE / 4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < cardList.length; j++) {
                cardList[j] = deck[i * 13 + j];
            }
            sortByValue(cardList);
            for (int j = 0; j < cardList.length; j++) {
                deck[i * 13 + j] = cardList[j];
            }
        }
    }

    /**
     * Sorts an array based on the value
     * @param inArray the array to sort
     */
    private void sortByValue(Card[] inArray) {
        for (int i = 1; i < inArray.length; i++) {
            Card key = inArray[i];
            int j = i - 1;

            while (j >= 0 && inArray[j].getRank().compareTo(key.getRank()) > 0) {
                inArray[j + 1] = inArray[j];
                j--;
            }

            inArray[j + 1] = key;
        }
    }

    /**
     * Get the deck of cards
     * 
     * @return the current deck of cards
     */
    public Card[] getDeck() {
        return deck;
    }

    public static void main(String[] args) {
        DeckOfCards doC = new DeckOfCards();
        System.out.println(doC.toString());
        System.out.println("Shuffling...\n-------------------------------------------------");
        doC.shuffle();
        System.out.println("Shuffled deck: ");
        System.out.println(doC.toString());
        System.out.println("Distributing to hands...\n-------------------------------------------------");
        System.out.println(doC.handsToString(doC.distributeToFourHands()));
        System.out.println("Sorting...\n-------------------------------------------------");
        doC.sort();
        System.out.println(doC.toString());

    }
}
