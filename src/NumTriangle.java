/*Name: Surya T
Class: ICS3U7
Date: Oct.12, 2022
Program: Makes a number triangle
Q2
 */
import java.util.Scanner;
public class NumTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Enter a number: ");
        num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println("");
        }
    }
}
