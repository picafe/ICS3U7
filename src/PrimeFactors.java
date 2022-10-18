import java.util.Scanner;
/*Name: Surya T
Class: ICS3U7
Date: Sept.28,2022
Program: Finds the prime factors of a number
PG92 Q2
 */
public class PrimeFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        int num = 0, counter = 2;
        System.out.print("Enter a positive integer: ");
        num = sc.nextInt();
        while (counter <= num) {
            if (num % counter == 0) {
                System.out.println(counter);
                num = num / counter;
            }
            else {
                counter++;
            }

        }
    }
}
