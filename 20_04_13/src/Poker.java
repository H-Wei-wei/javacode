import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static java.util.Collections.swap;

public class Poker {

    static class Card {
        public String suit;// 花色
        public String rank; // 数字

        public Card(String suit, String rank) {
            this.suit = suit;
            this.rank = rank;
        }

        @Override
        public String toString() {
            return suit + rank ;
        }
    }

    // 买牌
    public static List<Card> buyPoker() {
        // List 是个接口，得通过一个类去实现它
        List<Card> poker = new ArrayList<Card>();
        // 一副牌的花色
        String[] array = {"♠","♥","♧","♢"};
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j <= 10 ; j++) {
                // 实例化一个 Card，得到一张牌
                Card card = new Card(array[i],""+j);
                // 将这一张牌加入到这副牌中
                poker.add(card);
            }
            poker.add(new Card(array[i],"J"));
            poker.add(new Card(array[i],"Q"));
            poker.add(new Card(array[i],"K"));
            poker.add(new Card(array[i],"A"));
        }
        return poker;
    }

    // 洗牌
    public static void shuffle(List<Card> poker){
        Random random = new Random();
        // 从后开始遍历 poker
        for (int i = poker.size()-1; i > 0; i--) {
            // 随机数取 [0，i)
            int r = random.nextInt(i);
            // 让后边的数与前边的数调换位置
            swap(poker,i,r);
        }
    }

    public static void swap(List<Card> poker,int i,int r) {
        Card tmp = poker.get(i);
        poker.set(i,poker.get(r));
        poker.set(r,tmp);
    }

    public static void main(String[] args) {
        // 创建一副牌
        List<Card> poker = buyPoker();
        System.out.println(poker);

        System.out.println("=================================");

        // 洗牌
        //Collections.shuffle(poker);
        shuffle(poker);
        System.out.println(poker);

        // 发牌,将牌发给三个人
       /* List<List<Card>> persons = new ArrayList<List<Card>>();
        persons.add(new ArrayList<Card>());
        persons.add(new ArrayList<Card>());
        persons.add(new ArrayList<Card>());*/

       ArrayList<ArrayList<Card>> persons = new ArrayList<ArrayList<Card>>();
       // [  [], [], []  ]
       // 牌分给三个人，每人手中五张牌
       ArrayList<Card> person1 = new ArrayList<>();
       ArrayList<Card> person2 = new ArrayList<>();
       ArrayList<Card> person3 = new ArrayList<>();
       persons.add(person1);
       persons.add(person2);
       persons.add(person3);

        for (int cardIndex = 0; cardIndex < 5; cardIndex++) {
            for (int personIndex = 0; personIndex < 3 ; personIndex++) {
                List<Card> person = persons.get(personIndex);
                Card topCard = poker.remove(0);
                person.add(topCard);
            }
        }
        System.out.println("玩家一的手牌");
        System.out.println(persons.get(0));
        System.out.println("玩家二的手牌");
        System.out.println(persons.get(1));
        System.out.println("玩家三的手牌");
        System.out.println(persons.get(2));

        System.out.println("剩余的牌");
        System.out.println(poker);
    }
}
