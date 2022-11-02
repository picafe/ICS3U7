import java.util.*;
public class testaaa {
    public static void main(String[] args) {
        String str = notReplace("This is right");
        System.out.println(str);
    }
    public static String notReplace(String str) {
        str = " " + str + " ";
        for (int i = 1; i < str.length()-1; i++) {
            if (str.substring(i, i+2).equals("is")  && !Character.isLetter(str.charAt(i + 2)) && !Character.isLetter(str.charAt(i - 1))) {
                str = str.substring(0, i) + "is not" + str.substring(i+2);
            }
        }
        return str.substring(1, str.length() - 1);
    }
}




