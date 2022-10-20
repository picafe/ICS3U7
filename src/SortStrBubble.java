import java.util.*;
import java.io.*;
/*Name: Surya T
Class: ICS3U7
Date: Oct.19, 2022
Program: takes input from a txt file with an unknown number of strings and sorts them alphabetically, manually using bubble sort method
 */
public class SortStrBubble {
    public static void main(String[] args) throws Exception {
        Scanner scFile = new Scanner(new File("C:\\Users\\Surya\\IdeaProjects\\ICS3U7\\src\\SortStrBubble.txt"));
        String txt = scFile.nextLine();
        String[] arr = txt.split(" ");
        System.out.println(Arrays.toString(arr));

        String temp;
        int i, j;
        boolean swapped;
        for (i = 0; i < arr.length - 1; i++){
            swapped = false;
            for (j = 0; j < arr.length - i - 1; j++){
                if (arr[j].compareTo(arr[j + 1]) > 0){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
        }
        System.out.println(Arrays.toString(arr));
    }
}