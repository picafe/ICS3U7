/*Name: Surya T
Class: ICS3U7
Date: Oct.30, 2022
Program: Nim Game
PG 138 Q9
 */

import java.util.*;
public class Nim {
    static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        int stones = (int) (Math.random() * 16) + 15;
        while (stones > 0) {
            System.out.print("There are " + stones + " stones. How many would you live to take (max of 3): ");
            int input = sc.nextInt();
            // calls function to test valid input
            input = isValidEntry(input, stones);
            // tests to see if you lost by taking the last stone
            if (stones - input == 0) {
                System.out.println("You lost by taking the last stone!");
                break;
            }
            stones -= input;
            // calls computer input function
            int computer = drawStones(stones);
            System.out.println("There are " + stones + " stones. The computer takes " + computer);
            // tests to see if the computer lost by taking the last stone
            if (stones - computer == 0) {
                System.out.println("You won!");
                break;
            }
            stones -= computer;
        }
    }
    public static int isValidEntry (int input, int stones) {
        while (input > stones || input <= 0 || input > 3) {
            System.out.print("Please re-enter a value: ");
            input = sc.nextInt();
        }
        return input;
    }
    public static int drawStones (int stones) {
        int computer;
        if (stones == 4)
            computer = 3;
        else if (stones == 3)
            computer = 2;
        else if (stones == 2)
            computer = 1;
        else {
            computer = (int) (Math.random() * 3) + 1;
            while (computer > stones) {
                computer = (int) (Math.random() * 3) + 1;
            }
        }
        return computer;
    }

}
