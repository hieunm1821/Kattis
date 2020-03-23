//Name: Nguyen Minh Hieu
//https://open.kattis.com/problems/fizzbuzz
import java.util.*;
public class FizzBuzz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x,y,n;
		x = sc.nextInt();
		y = sc.nextInt();
		n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			if (i % y == 0 && i % x == 0) {
				System.out.println("FizzBuzz");
			} else if (i % y == 0){
				System.out.println("Buzz");
			} else if (i % x == 0) {
				System.out.println("Fizz");
			} else {
				System.out.println(i);
			}
		}
	}
}
