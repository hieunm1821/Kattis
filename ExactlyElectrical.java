//Name: Nguyen Minh Hieu
//https://open.kattis.com/problems/exactlyelectrical
import java.util.*;
import java.lang.*;

public class ExactlyElectrical {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,c,d,t,distance,remain;
		a = sc.nextInt();
		b = sc.nextInt();
		sc.nextLine();
		c = sc.nextInt();
		d = sc.nextInt();
		sc.nextLine();
		t = sc.nextInt();

		distance = Math.abs(a-c) + Math.abs(b-d);
		if (t < distance) {
			System.out.println("N");	
		} else {
			remain = t - distance;
			if (remain % 2 == 0) {
				System.out.println("Y");
			} else {
				System.out.println("N");
			}
		}
		//System.out.println("N");
	}
}
