/*Name: Surya T
Class: ICS3U7
Date: idk
Program: idk
 */
public class Question4 {
    public static void main(String[] args) {
        double total_money = 2069;
        double tickets = Math.floor(total_money/113.15);
        System.out.format("With %.0f dollars you can buy %.0f tickets.", total_money, tickets);
        double change_dollars = total_money - 113.15 * tickets;
        double change_cents = (change_dollars - Math.floor(change_dollars)) * 100;
        System.out.format("%nThe change is %.0f dollars and %.0f cents.", change_dollars, change_cents);
    }
}
