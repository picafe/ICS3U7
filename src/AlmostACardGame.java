/*Name: Surya T
Class: ICS3U7
Date: Nov.11, 2022
Program: Card Operations
Q3
 */
//Note: I used the order of cards shown on this page, as I thought it looked more clean: https://en.wikipedia.org/wiki/Standard_52-card_deck#Computer_representations
import java.util.*;
public class AlmostACardGame {
    public static void main(String[] args) {
        int cards[] = new int[52];
        for (int i = 0; i < 52; i++) {
            cards[i] = i;
        }
        System.out.println(Arrays.toString(cards));

        for (int i = 0; i < cards.length; i++)
            System.out.print(toTheString(cards[i]) + "    ");
        System.out.println();

        for (int i = 0; i < cards.length; i++)
            System.out.print(getValue(cards[i])+ "    ");
        System.out.println();

        shuffle(cards);

        System.out.println(Arrays.toString(cards));

        for (int i = 0; i < cards.length; i++)
            System.out.print(toTheString(cards[i])+ "   ");
        System.out.println();
    }

     public static String toTheString(int num) {
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
    public static int getValue(int num) {
        int out = num % 13;
        if (out == 0 || out == 11 || out == 12)
            return 10;
        else
            return out;
    }
    public static int[] shuffle(int[] arr) {
        int rnd, tmp;
        for (int i = 0; i < arr.length; i++) {
            rnd = (int) (Math.random()*52);
            tmp = arr[i];
            arr[i] = arr[rnd];
            arr[rnd] = tmp;
        }
        return arr;
    }
}
