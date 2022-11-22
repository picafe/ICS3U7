import java.io.*;
import java.util.*;
public class BlackJackWIP {
    public static void main(String[] args) throws Exception {
        Deck deck = new Deck();
        Player bob = new Player("Bob");
        deck.loadCards();
        System.out.println(deck);

        deck.shuffleCards();

        System.out.println(deck);
        bob.getCard(deck.dealCard());
        bob.getCard(deck.dealCard());
        bob.getCard(deck.dealCard());

        System.out.println(bob);

        System.out.println(deck.toString());
        System.out.println(Jokes.nextJoke());

    }
}

class Player {
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    private String name;

    public Player(String theName) {
        name = theName;
    }

    public void getCard(int card) {
        cards.add(card);
    }

    public int getTotal() {
        int total = 0, aces = 0;
        for (int i = 0; i < cards.size(); i++) {
            if (Deck.cardToValue(cards.get(i)) == 11)
                aces++;
            total += Deck.cardToValue(cards.get(i));
        }
        if (total > 21 && aces == 1)
            total -= 10;
        else if (total > 21 && aces == 2) {
            total -= 10;
            if (total > 21)
                total -=10;
        }
        return total;
    }

    public String getHands() {
        String out = "";
        for (int i = 0; i < cards.size(); i++) {
            out += Deck.cardToString(cards.get(i)) + " ";
        }
        return out;
    }

    public String toString() {
        return name + "'s Hand:   " + getHands() + "\tsum: " + getTotal();
    }

class Dealer extends Player {

    public Dealer(String theName) {
        super(theName);
    }

}


}
class Deck {
    private int cards[];
    private int numCards = 52;
    public void loadCards() {
        cards = new int[52];
        for (int i = 0; i < 52; i++) {
            cards[i] = i;
        }
    }

    public int[] getCards() {
        return cards;
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
        for (int i = cards.length-1; i > 0; i--) {
            if (cards[i] != -1) {
                out = cards[i];
                cards[i] = -1;
                numCards--;
                return out;
            }
        }
        return out;
    }

    public String toString() {
        String out = "";
        for (int i = numCards-1; i > 0; i--) {
            out += cardToString(cards[i]) + " ";
        }
        return out;
    }

    public static String cardToString(int num) {
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
    public static int cardToValue(int num) {
        int out = num % 13;
        if (out == 0 || out == 11 || out == 12)
            return 10;
        else if (out == 1)
            return 11;
        else
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
