/*Name: Surya T
Class: ICS3U7
Date: Oct.12, 2022
Program: Makes a sideways * triangle
Q4
 */
import java.util.Scanner;
public class SidewaysTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Enter an integer: ");
        num = sc.nextInt();
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        for (int k = num; k > 0; k--) {
            for (int j = 1; j < k; j++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}
