import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestComparable {
    static class Card implements Comparable<Card> {
        private String rank;
        private String suit;

        public Card(String rank, String suit) {
            this.rank = rank;
            this.suit = suit;
        }

        @Override
        public boolean equals(Object obj) {
            // 1.看 this 和 Obj 的身份是否相等
            if (this == obj) {
                return true;
            }
            // 2. 看 obj 是否为空
            if (obj == null) {
                return false;
            }
            // 3.看 obj 是否可以强转为 Card
            if (!(obj instanceof Card)) {
                return false;
            }
            // 4.类型转换，将 obj 转换成 Card 类型
            Card other = (Card) obj;
            // 5.真正按照指定规则来进行
            return this.rank.equals(other.rank);
        }

        @Override
        public int compareTo(Card o) {
            int rank1 = this.convertRank();
            int rank2 = o.convertRank();
            return rank1 - rank2;
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
            // 将 string 转换成 integer
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
    public static void main(String[] args) {
        Card card1 = new Card("K","");
        Card card2 = new Card("10","");
        Card card3 = card1;

        //System.out.println(card1.equals(card2));
        //System.out.println(card1.equals(card3));

        System.out.println(card1.compareTo(card2));

        List<Card> cards = new ArrayList<>();
        cards.add(new Card("A",""));
        cards.add(new Card("K",""));
        cards.add(new Card("J",""));
        cards.add(new Card("Q",""));

        Collections.sort(cards);
        System.out.println(cards);

    }
}