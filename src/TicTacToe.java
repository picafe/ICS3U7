import java.util.*;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char array[][] = new char[3][3];
        int xaxis, yaxis;
        String move[] = new String[2];
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                array[i][j] = '.';
            }
        }
        System.out.print("Please enter the move: ");
        xaxis = sc.nextInt();
        yaxis = sc.nextInt();
        array[xaxis][yaxis] = 'x';

        System.out.println(Arrays.deepToString(array));

        for (int k = 0; k <=2; k++) {
            for (int l = 0; l <=2; l++) {
                System.out.print(array[k][l] + " ");
            }
            System.out.println("");
        }
    }
}
