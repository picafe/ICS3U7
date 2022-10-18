import java.util.Scanner;
/*Name: Surya T
Class: ICS3U7
Date: Sept.13,2022
Program: Asks for total amount of minutes spent on each part of a java project and finds the percentage
PG46 Q12
 */
public class Project {
    public static void main(String[] args){
        int designing = 0, coding = 0, debugging = 0, testing = 0, total_time = 0;
        double unit = 0;
        Scanner bob = new Scanner(System.in);
        System.out.print("Designing: ");
        designing = bob.nextInt();
        System.out.print("Coding: ");
        coding = bob.nextInt();
        System.out.print("Debugging: ");
        debugging = bob.nextInt();
        System.out.print("Testing: ");
        testing = bob.nextInt();
        total_time = designing + coding + debugging + testing;
        unit = (double) 100 / total_time;
        System.out.format("%-15s %-15s %n", "Task", "% Time" );
        System.out.format("%-15s %-1.2f %1s %n", "Designing", designing * unit, "%");
        System.out.format("%-15s %-1.2f %1s %n", "Coding", coding * unit, "%");
        System.out.format("%-15s %-1.2f %1s %n", "Debugging", debugging * unit, "%");
        System.out.format("%-15s %-1.2f %1s %n", "Testing", testing * unit, "%");
    }
}
