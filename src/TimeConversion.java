import java.util.Scanner;
/*Name: Surya T
Class: ICS3U7
Date: Sept.13,2022
Program: Converts minutes into hours
PG45 Q9
 */
public class TimeConversion {
    public static void main (String[] args){
        int total_minutes = 0, hours = 0, minutes = 0;
        Scanner bob = new Scanner(System.in);
        System.out.print("Enter the time in minutes: ");
        total_minutes = bob.nextInt();
        hours = total_minutes/60;
        minutes = total_minutes%60;
        System.out.println("The time is: " + hours + ":" + minutes);
    }
}