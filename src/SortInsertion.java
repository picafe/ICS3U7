/*Name: Surya T
Class: ICS3U7
Date: Oct.18, 2022
Program: takes input from a txt file (100 ints) and sorts using Insertion sort method
 */
import java.util.*;
import java.io.*;
public class SortInsertion {
    public static void main(String[] args) throws Exception {
        Scanner scFile = new Scanner(new File("C:\\Users\\Surya\\IdeaProjects\\ICS3U7\\src\\SortInsertion.txt"));
        int arr[] = new int[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = Integer.parseInt(scFile.next());
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
}

