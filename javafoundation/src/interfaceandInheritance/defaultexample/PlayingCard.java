package interfaceandInheritance.defaultexample;

/**
 * created by dbx on 2019/3/9
 */
public class PlayingCard implements Card {

    private Rank rank;
    private Suit suit;

    public PlayingCard(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Card) {
            if (((Card)obj).getRank() == this.rank &&
                    ((Card)obj).getSuit() == this.suit) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }


    public int hashCode() {
        return ((suit.value()-1)*13)+rank.value();
    }

    public int compareTo(Card o) {
        return this.hashCode() - o.hashCode();
    }

    public String toString() {
        return this.rank.text() + " of " + this.suit.text();
    }

    public static void main(String... args) {
        new PlayingCard(Rank.ACE, Suit.DIAMONDS);
        new PlayingCard(Rank.KING, Suit.SPADES);
    }
}