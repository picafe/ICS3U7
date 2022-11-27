import java.io.*;
import java.util.*;
/*Name: Surya T
Class: ICS3U7
Date: Nov.26, 2022
Program: Main Class for BlackJack Project
 */
public class BlackJack {

    static Scanner sc = new Scanner(System.in);
    static Deck deck = new Deck();
    static Player player = new Player(askName());
    static Dealer dealer = new Dealer();
    static boolean roundPlaying = true;
    public static void main(String[] args) throws Exception {
        boolean isPlaying = true;
        deck.loadCards();
        System.out.println(deck);
        deck.shuffleCards();


        while (isPlaying) {
            while (roundPlaying) {
                System.out.println(deck);
                Decision();
            }
            if (deck.getNumCards() - 1 < 10) {
                deck.loadCards();
                deck.shuffleCards();
            }
            isPlaying = playAgain();
        }
    }
    public static String askName() {
        System.out.println("What is your name?");
        return sc.nextLine();
    }
    public static void Decision() throws Exception {
        if (dealer.Decision()) {
            whoWon();
            roundPlaying = false;
            return;
        }
        System.out.println("hit or stand?");
        char decision = Character.toLowerCase(sc.next().charAt(0));
        if (decision == 's') {
            whoWon();
            roundPlaying = false;
        }
        else {
            player.getCard(deck.dealCard());
            dealer.getCard(deck.dealCard());
            Results();
        }
    }

    public static void Results() {
        System.out.println(player.toString() + "\n\n" + dealer.toHiddenString());
    }

    public static void whoWon() throws Exception {
        char winner = ' ';
        System.out.println(player.toString() + "\n\n" + dealer.toString());
        if (player.getTotal() <= 21 && player.getTotal() <= 21 && player.getTotal() > dealer.getTotal()) {
            System.out.println("You won!");
            winner = 'p';
        }
        else if (player.getTotal() <= 21 && player.getTotal() <= 21 && player.getTotal() < dealer.getTotal()) {
            System.out.println("You lost!");
            winner = 'd';
        }
        else if (player.getTotal() > 21 && dealer.getTotal() > 21) {
            System.out.println("Both bust, **dealer wins**!");
            winner = 'd';
        }
        else if (dealer.getTotal() > 21) {
            System.out.println("Dealer bust, **you won**!");
            winner = 'p';
        }
        else if (player.getTotal() > 21) {
            System.out.println("You bust and **lost**!");
            winner = 'd';
        }
        else if (player.getTotal() == dealer.getTotal()) {
            System.out.println("Tie, **dealer wins**!");
            winner = 'd';
        }
        else
            System.out.println("something weird happened!");

        if (winner == 'p')
            System.out.println(player.getName() + " says: " + Jokes.nextJoke());
        else
            System.out.println(dealer.getName() + " says: " + Jokes.nextJoke());
    }

    public static boolean playAgain() {
        player.clearCards();
        dealer.clearCards();
        System.out.print("would you like to play again? [y/n] ");
        char decision = Character.toLowerCase(sc.next().charAt(0));
        //will play again if y is entered, if not, it will exit
        if (decision == 'y') {
            roundPlaying = true;
            return true;
        }
        return false;
    }
}

/*Name: Surya T
Class: ICS3U7
Date: Nov.26, 2022
Program: Player Class for BlackJack Project
 */
class Player {
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void getCard(int card) {
        cards.add(card);
    }

    public void clearCards() {
        cards.clear();
    }

    public String getName() {
        return name;
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

/*Name: Surya T
Class: ICS3U7
Date: Nov.26, 2022
Program: Dealer Class for BlackJack Project
 */
class Dealer extends Player {
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    private String name;

     public Dealer() {
         super("Dealer");
         name = "Dealer";
     }

     public String toHiddenString() {
         String showSum;
         if (getTotal() > 10) {
             showSum = "> 10";
         } else {
             showSum = "< 10";
         }

         return name + "'s Hand:   " + getHands().substring(0, 2) + " ?\t\tSum: " + showSum;
     }

     public String toString() {
         return super.toString();
     }

    public boolean Decision() {
        if (getTotal() >= 18) {
            System.out.println("**Dealer Stands**");
            return true;
        }
        return false;
    }
 }


/*Name: Surya T
Class: ICS3U7
Date: Nov.26, 2022
Program: Deck Class for BlackJack Project
 */
class Deck {
    private int cards[];
    private int numCards;
    public void loadCards() {
        cards = new int[52];
        for (int i = 0; i < 52; i++)
            cards[i] = i;
        numCards = 52;
    }

    public int getNumCards() {
        return numCards;
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
/*Name: Surya T
Class: ICS3U7
Date: Nov.26, 2022
Program: Jokes Class for BlackJack Project
 */
class Jokes {

    private static ArrayList<String> jokes = new ArrayList<String>();

    public static void loadJokes() throws Exception {
        String tmp;
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
        int rnd = (int) (Math.random() * jokes.size());
        out = jokes.get(rnd);
        jokes.remove(rnd);
        return out;
    }
}
