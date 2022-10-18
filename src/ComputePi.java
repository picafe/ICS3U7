/*Name: Surya T
Class: ICS3U7
Date: Oct.12, 2022
Program: Computes pi using 100k iterations of the algorithm
Q1
 */
public class ComputePi {
    public static void main(String[] args) {
        double pi = 0;
        int counter = 1;
        for (int i = 0; i < 100000; i++) {
            if (i % 2 == 0)
                pi += 1.0/counter;
            else
                pi -= 1.0/counter;
            counter += 2;
        }
        pi *= 4;
        pi = Math.round(pi * 1000) / 1000.0;
        System.out.println(pi);
    }
}
