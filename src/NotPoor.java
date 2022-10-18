/*Name: Surya T
Class: ICS3U7
Date: Oct.12, 2022
Program: replaces "not"..."poor" with "good"
Q6
 */
import java.util.Scanner;
public class NotPoor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int not, poor;

        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        not = str.indexOf("not");
        poor = str.indexOf("poor");
        if (not == -1 && poor == -1)
            System.out.println("Both words not and poor do not appear in the string you entered!");
        else if (not > poor)
            System.out.println("The word poor appears before not!");
        else {
            System.out.println(str.replace(str.substring(not, poor + 4), "good"));
        }
    }
}
