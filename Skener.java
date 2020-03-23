import java.util.*;
public class Skener {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r,c,zr,zc;
		r = sc.nextInt();
		c = sc.nextInt();
		zr = sc.nextInt();
		zc = sc.nextInt();
		sc.nextLine();
		String[] output = new String[r*zr];
		int count = 0;

		for (int i = 0; i < r; i ++) {
			char[] input  = sc.nextLine().toCharArray();
			int k = 0;
			char[] temp = new char[c*zc];

			for (int j = 0; j < c; j++) {
				for (int m = 0; m < zc; m++) {
					temp[k++] = input[j];
				}
			}

			for (int m = 0; m < zr; m++) {
				output[count++] = String.copyValueOf(temp);
			}
		}

		for (int i = 0; i < r*zr; i ++) {
			System.out.println(output[i]);
		}
	}
}