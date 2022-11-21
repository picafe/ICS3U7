import java.io.*;
import java.util.*;
public class BlackJackWIP {
    public static void main(String[] args) throws Exception {
        Deck deck = new Deck();
        deck.loadCards();
        System.out.println(deck.toString());
        System.out.println(deck.toAString(deck.getCards()));
        deck.shuffleCards();
        System.out.println(deck.toAString(deck.getCards()));
        System.out.println(deck.toString());
        System.out.println(deck.dealCard());
        System.out.println(deck.dealCard());
        System.out.println(deck.dealCard());
        System.out.println(deck.dealCard());

        System.out.println(deck.toAString(deck.getCards()));
        System.out.println(Jokes.nextJoke());

    }
}

class Player {
    ArrayList<Integer> cards = new ArrayList<Integer>();

    public ArrayList<Integer> getCards() {
        return cards;
    }

//    public String toString() {
//        for (int i = 0; i < cards.size(); i++) {
//            String out = Integer.toString(cards.get(i) % 13);
//            // adding exceptions for cards that are not numbers
//            if (out.equals("1"))
//                out = "A";
//            else if (out.equals("11"))
//                out = "J";
//            else if (out.equals("12"))
//                out = "Q";
//            else if (out.equals("0"))
//                out = "K";
//
//            // adding the card symbol
//            if (num / 13 == 0)
//                out += "♣";
//            else if (num / 13 == 1)
//                out += "♦";
//            else if (num / 13 == 2)
//                out += "♥";
//            else
//                out += "♠";
//        }
//
//        return out;
//    }

    public void addCard(int card) {
        cards.add(card);
    }
}
class Deck {
    private int cards[];
    public void loadCards() {
        cards = new int[52];
        for (int i = 0; i < 52; i++) {
            cards[i] = i;
        }
    }

    public int[] getCards() {
        return cards;
    }
    public String toString() {
        return Arrays.toString(cards);
    }

    public void shuffleCards() {
        int rnd, tmp;
        for (int i = 0; i < cards.length; i++) {
            rnd = (int) (Math.random() * 52);
            tmp = cards[i];
            cards[i] = cards[rnd];
            cards[rnd] = tmp;
        }
    }

    public int dealCard() {
        int out = -1;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] != -1) {
                out = cards[i];
                cards[i] = -1;
                return out;
            }
        }
        return out;
    }

    public String toAString(int[] deck) {
        int cnt = 0;
        for (int j : deck) {
            if (j == -1)
                cnt++;
        }
        String out[] = new String[deck.length - cnt - 1];
        for (int i = 0; i < out.length; i++) {
            if (deck[i] == -1)
                continue;
            else
                out[i] = toString(deck[i]);
        }
        return Arrays.toString(out);
    }
    public static String toString(int num) {
        String out = Integer.toString(num % 13);
        // adding exceptions for cards that are not numbers
        if (out.equals("1"))
            out = "A";
        else if (out.equals("11"))
            out = "J";
        else if (out.equals("12"))
            out = "Q";
        else if (out.equals("0"))
            out = "K";

        // adding the card symbol
        if (num / 13 == 0)
            out += "♣";
        else if (num / 13 == 1)
            out += "♦";
        else if (num / 13 == 2)
            out += "♥";
        else
            out += "♠";
        return out;
    }

}

class Jokes {

    private static ArrayList<String> jokes = new ArrayList<String>();

    public static void loadJokes() throws Exception {
        String tmp = "";
        Scanner scFile = new Scanner(new File("C:\\Users\\Surya\\IdeaProjects\\ICS3U7\\src\\jokes.txt"));
        //reading all the jokes in the file (separated by newline)
        while (scFile.hasNext()) {
            tmp = scFile.nextLine();
            jokes.add(tmp);
        }
        Collections.shuffle(jokes);
    }
    public static String nextJoke() throws Exception {
        String out;
        if (jokes.isEmpty())
            loadJokes();
        int rnd = (int) (Math.random()* jokes.size());
        out = jokes.get(rnd);
        jokes.remove(rnd);
        return out;
    }
}
