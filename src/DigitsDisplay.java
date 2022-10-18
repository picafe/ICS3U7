import java.util.Scanner;
/*Name: Surya T
Class: ICS3U7
Date: Sept.23,2022
Program: Takes a positive integer and outputs each digit on a newline
PG93 Q5
 */
public class DigitsDisplay {
    public static void main (String[] args) {
        Scanner bob = new Scanner (System.in);
        int num, digit;
        String out = "";

        System.out.print("Enter a positive integer: ");
        num = bob.nextInt();
        // Checks to see if number is positive
        if (num > 0) {
            while (num > 0) {
                digit = num % 10;
                // Adds the digit to a string in order, so they don't get printed in reverse
                out = digit + "\n" + out;
                num = num / 10;
            }
        }
        else {
            System.out.println("That is not a positive integer!");
        }
        System.out.print(out);
        }
    }
