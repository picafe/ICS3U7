import java.io.*;
import java.util.*;
public class BlackJackWIP {

    static Scanner sc = new Scanner(System.in);
    static Deck deck = new Deck();
    static Player player = new Player(Game.askName());
    static Dealer dealer = new Dealer();
    public static void main(String[] args) throws Exception {


        deck.loadCards();

        System.out.println(deck);
        deck.shuffleCards();
        System.out.println(deck);



        System.out.println(deck);

    }
    public static void playerDecision() {
        System.out.println("hit or stand?");
        char decision = Character.toLowerCase(sc.next().charAt(0));
        if (decision == 'h') {
            player.getCard(deck.dealCard());
        }
        //need to finish



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
                total -= 10;
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
        return name + "'s Hand:   " + getHands() + "\t\tSum: " + getTotal();
    }
}

    class Dealer extends Player {
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    private String name;

     public Dealer() {
         super("Dealer");
         name = "Dealer";
     }

     public String toString() {
         String showSum = "";
         if (getTotal() > 10) {
             showSum = "> 10";
         } else {
             showSum = "< 10";
         }

         return name + "'s Hand:   " + getHands().substring(0, 2) + " ?\t\tSum: " + showSum;
     }

    public boolean Decision() {
        return getTotal() <= 18;
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

    //debugging, remove later
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

class Game {
    private static Scanner sc = new Scanner(System.in);
    public static void gameOver(char whichPlayerLost) throws Exception {

        if (whichPlayerLost == 'p') {
            System.out.println("Player says: " + Jokes.nextJoke());
            System.out.println("---------------");
            System.out.println("You Went Over 21 and Busted!");
            System.out.println("You **Lost** this Round!");
        }
        else {
            System.out.println("Dealer says: " + Jokes.nextJoke());
            System.out.println("---------------");
            System.out.println("The Dealer Went Over 21 and Busted!");
            System.out.println("You **Won** this Round!");
        }
    }
    public static String askName() {
        System.out.println("What is your name?");
        return sc.nextLine();
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
