import java.util.Scanner;
/*Name: Surya T
Class: ICS3U7
Date: Sept.27,2022
Program: Asks for total amount of minutes spent on each part of a java project and finds the percentage
PG92 Q1B
 */
public class PrimeNumber1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = 0, num2 = 0;
        boolean isPrime = true;
        System.out.print("Enter the first number: ");
        num1 = sc.nextInt();
        System.out.print("Enter the second number: ");
        num2 = sc.nextInt();

        for (int j = num1; j <= num2; j++) {
            int num = j;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime && num != 1) {
                System.out.println(num);
            }
            num = 0;
            isPrime = true;
        }
    }
}