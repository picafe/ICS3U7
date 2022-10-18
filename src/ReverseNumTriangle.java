/*Name: Surya T
Class: ICS3U7
Date: Oct.12, 2022
Program: Makes a number triangle counting down aligned to the right
Q3
 */
import java.util.Scanner;
public class ReverseNumTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        String out;
        System.out.print("Enter a number: ");
        num = sc.nextInt();
        for (int i = num; i > 0; i--) {
            for (int spaces = 0; spaces < (num - i); spaces++){
                System.out.print("  ");
            }
            for (int j = i; j > 0; j--) {
                System.out.print(j + " ");
            }
            System.out.println(" ");
        }
    }
}
