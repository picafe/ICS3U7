/*Name: Surya T
Class: ICS3U7
Date: Nov.11, 2022
Program: String Stats
Q2
 */
import java.util.*;
public class StringStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Total words    = " + wordCount(str));
        System.out.println("Average Length = " + wordAvgLength(str));
    }
    public static int wordCount(String str) {
        String[] arr = str.split(" ");
        return arr.length;
    }
    public static float wordAvgLength(String str) {
        char[] arr = str.toCharArray();
        float cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ')
                cnt += 1;
        }
        return cnt / wordCount(str);
    }
}
