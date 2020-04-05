//Name: Nguyen Minh Hieu
//Matric number: A0200814W
import java.util.*;
import java.io.*;
public class islands {
    public static char image[][];
    //find all the adjacent point can connect to make a island
    public static void update(int i, int j) {
        if (i >= 0 && i <image.length && j >= 0 && j < image[i].length && (image[i][j] == 'L' ||image[i][j] == 'C')) {
            image[i][j] = 'X';
            update(i+1,j);
            update(i-1,j);
            update(i,j+1);
            update(i,j-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        image = new char[r][];
        int result = 0;

        for (int i = 0; i < r; i ++) image[i] = sc.next().toCharArray();
        for (int i = 0; i < r; i ++) {
            for (int j = 0; j < c; j++) {
                if (image[i][j] == 'L') {
                    result ++; //only the point cannot make connect => new island
                    update(i,j);
                }
            }
        }
        System.out.println(result);
    }
}   