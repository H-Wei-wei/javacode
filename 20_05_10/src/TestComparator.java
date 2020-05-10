
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int convertRank() {
        if ("A".equals(rank)) {
            return 14;
        }
        if ("K".equals(rank)) {
            return 13;
        }
        if ("Q".equals(rank)) {
            return 12;
        }
        if ("J".equals(rank)) {
            return 11;
        }
        return Integer.parseInt(rank);
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }


}

class CardComparator implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        int rank1 = o1.convertRank();
        int rank2 = o2.convertRank();
        return rank1 - rank2;
    }
}

public class TestComparator {

    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card("A","j"));
        cards.add(new Card("K","j"));
        cards.add(new Card("J","j"));
        cards.add(new Card("10","j"));
        Collections.sort(cards,new CardComparator());
        System.out.println(cards);
    }
}
