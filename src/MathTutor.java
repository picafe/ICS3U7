import java.util.Scanner;
/*Name: Surya T
Class: ICS3U7
Date: Sept.13,2022
Program: Generates a random equation using numbers from 1-10 and checks if it is correct
PG65 Q6
 */
public class MathTutor {
    public static void main(String[] args) {
        int rand_num1 = 0, rand_num2 = 0, operator = 0, answer = 0, input = 0;
        Scanner bob = new Scanner(System.in);
        rand_num1 = (int) (Math.random() * 10 + 1);
        rand_num2 = (int) (Math.random() * 10 + 1);
        operator = (int) (Math.random() * 4 + 1);
        if (operator == 1) {
            System.out.print("What is " + rand_num1 + " * " + rand_num2 + " in Java? ");
            answer = rand_num1 * rand_num2;
        }
        else if (operator == 2) {
            System.out.print("What is " + rand_num1 + " + " + rand_num2 + " in Java? ");
            answer = rand_num1 + rand_num2;
        }
        else if (operator == 3) {
            System.out.print("What is " + rand_num1 + " - " + rand_num2 + " in Java? ");
            answer = rand_num1 - rand_num2;
        }
        else  {
            System.out.print("What is " + rand_num1 + " / " + rand_num2 + " in Java? ");
            answer = rand_num1 / rand_num2;
        }
        input = bob.nextInt();
        if (input == answer) {
            System.out.println("Correct!");
        }
        else {
            System.out.println("Incorrect. Try Again!");
        }
    }
}
