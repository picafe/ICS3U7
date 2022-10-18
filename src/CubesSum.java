import java.util.Scanner;
/*Name: Surya T
Class: ICS3U7
Date: Sept.23,2022
Program: Takes a positive integer and finds the sum of the cubes of the digits
PG93 Q7
 */
public class CubesSum {
    public static void main (String[] args) {
        Scanner bob = new Scanner (System.in);
        int num, sum = 0;
        double digit;

        System.out.print("Enter a positive integer: ");
        num = bob.nextInt();
        // Checks to see if number is positive
        if (num > 0) {
            while (num > 0) {
                digit = Math.pow(num % 10, 3);
                sum += digit;
                num = num / 10;
            }
        }
        else {
            System.out.println("That is not a positive integer!");
        }
        System.out.println("The sum of the cubes of the digits is: " + sum);
    }
}
