import java.util.Scanner;
/*Name: Surya T
Class: ICS3U7
Date: Sept.26,2022
Program: Asks for total amount of minutes spent on each part of a java project and finds the percentage
PG92 Q1
 */
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int num = 0;
        boolean isPrime = true;
        System.out.print("Enter a number: ");
        num = sc.nextInt();

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.print("Not a prime number.");
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("Prime");
        }
    }
}
