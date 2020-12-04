package ap.week14;

public class Card {
    private Suit suit;
    private Rank rank;

    public Card(Suit s, Rank r) {
        suit = s;
        rank = r;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getValue() {
        return rank.rank;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s%-3d", suit.getSuit(), rank.getRankString(), rank.getRank());
    }

    public static enum Rank {
        Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(11), Queen(12),
        King(13);

        private final int rank;

        Rank(int r) {
            rank = r;
        }

        public static Rank getRankFromInt(int n) {
            if (n >= 0 && n <= 13) {
                return Rank.values()[n - 1];
            } else {
                return null;
            }
        }

        public String getRankString() {
            if (rank > 1 && rank < 11) {
                return Integer.toString(rank);
            } else if (rank > 10) {
                final String highRanks[] = { "Jack", "Queen", "King" };
                return highRanks[rank - 11];
            } else {
                return "Ace";
            }
        }

        public int getRank() {
            return rank;
        }
    }

    public static enum Suit {
        Spades("Spades"), Hearts("Hearts"), Diamonds("Diamonds"), Clubs("Clubs");

        private final String suit;

        Suit(String s) {
            suit = s;
        }

        public String getSuit() {
            return suit;
        }
    }
}
