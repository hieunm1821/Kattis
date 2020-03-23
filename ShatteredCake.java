//Name: Nguyen Minh Hieu
//https://open.kattis.com/problems/shatteredcake
import java.util.*;
public class ShatteredCake {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w,n,a,b;
		int area = 0;

		w = sc.nextInt();
		sc.nextLine();
		n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < n; i ++) {
			a = sc.nextInt();
			b = sc.nextInt();
			sc.nextLine();
			area += a*b;			
		}

		System.out.println(area/w);
	}
}
