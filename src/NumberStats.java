/*Name: Surya T
Class: ICS3U7
Date: Nov.11, 2022
Program: Number Stats
Q1
 */
import java.util.*;
public class NumberStats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter numbers separated by a comma and space: ");
        String input = sc.nextLine();
        String strarr[] = input.split(", ");
        int[] arr = new int[strarr.length];
        for(int i = 0; i < strarr.length; i++) {
            arr[i] = Integer.parseInt(strarr[i]);
        }

        System.out.println("Sum is " + sum(arr));
        System.out.println("Minimum value is " + min(arr));
        // ---
        if (isAllEven(arr))
            System.out.println("All of the values are even numbers");
        else
            System.out.println("All of the values are not even numbers");
        // ---
        if (isArithmetic(arr))
            System.out.println("It is an arithmetic sequence");
        else
            System.out.println("It is not an arithmetic sequence");
        // ---
        if (isMaybeArithmetic(arr))
            System.out.println("The numbers can be rearranged to form an arithmetic sequence");
        else
            System.out.println("The numbers cannot be rearranged to form an arithmetic sequence");
    }
    public static int sum(int[] arr) {
        int sum = 0;
        // I found this from stackoverflow, and it looks much cleaner in my opinion
        for (int i : arr)
            sum += i;
        return sum;
    }
    public static int min(int[] arr) {
        Arrays.sort(arr);
        return arr[0];
    }
    public static boolean isAllEven(int[] arr) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        return sum % 2 == 0;
    }
    public static boolean isArithmetic(int[] arr) {
        int diff = Math.abs(arr[1] - arr[0]);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] != arr[i] + diff) {
                return false;
            }
        }
        return true;
    }
    public static boolean isMaybeArithmetic(int[] arr) {
        Arrays.sort(arr);
        return isArithmetic(arr);
    }
}