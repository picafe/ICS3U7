import java.io.*;
import java.util.*;
public class testaaa {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> jokes = new ArrayList<String>();
        String tmp = "";
        Scanner scFile = new Scanner(new File("C:\\Users\\Surya\\IdeaProjects\\ICS3U7\\src\\jokes.txt"));
        while (scFile.hasNext()) {
            tmp = scFile.nextLine();
            jokes.add(tmp);
        }
        Collections.shuffle(jokes);
    }
}






