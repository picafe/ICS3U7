/*Name: Surya T
Class: ICS3U7
Date: Oct.12, 2022
Program: Generates a random password
Q5
 */
public class RandPasswd {
    public static void main (String[] args) {
        int first, second, third;
        char fourth;
        String fourthall = "~$&@*%_";
        first = (int) (Math.random() * 26) + 97;
        second = (int) (Math.random() * 9) + 48;
        third = (int) (Math.random() * 26) + 65;
        fourth = fourthall.charAt((int) (Math.random() * 7));

        System.out.println((char)first + "" + (char)second + "" + (char)third + "" + fourth);
    }
}
