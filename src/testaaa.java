import java.util.*;
public class testaaa {
    public static void main(String[] args) {
        ArrayList<String> songs = new ArrayList<String>();
        Scanner sc = new Scanner (System.in);
        int button = 0, num = 0;
        String tmp;
        songs.add("A");
        songs.add("B");
        songs.add("C");
        songs.add("D");
        songs.add("E");
        while (button != 4) {
            button = sc.nextInt();
            num = sc.nextInt();
            if (button == 1) {
                for (int i = 0; i < num; i++) {
                    songs.add(songs.get(0));
                    songs.remove(0);
                }
            }
            else if (button == 2) {
                for (int i = 0; i < num; i++) {
                    songs.add(0, songs.get(4));
                    songs.remove(5);
                }
            }
            else if (button == 3 ) {
                for (int i = 0; i < num; i++) {
                    songs.add(0, songs.get(1));
                    songs.remove(2);
                }
            }
        }
        for (int j = 0; j < songs.size(); j++) {
            System.out.print(songs.get(j) + " ");
        }
    }
}




