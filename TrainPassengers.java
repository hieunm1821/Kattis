//Name: Nguyen Minh Hieu
//https://open.kattis.com/problems/trainpassengers
import java.util.*;
public class TrainPassengers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int capacity = sc.nextInt();
		int no_stations = sc.nextInt();
		sc.nextLine();
		//int last = 0;
		int on_train = 0;
		for (int i = 0; i < no_stations; i++) { 
			int left = sc.nextInt();
			int enter = sc.nextInt();
			int stay = sc.nextInt();
			sc.nextLine();
			on_train += enter;
			on_train -= left;
			if (i == no_stations-1 && (stay != 0 || enter !=0 || on_train != 0)) {
				System.out.println("impossible");
				return;
			} else if (on_train > capacity || on_train < 0) {
				System.out.println("impossible");
				return;
			} else if (on_train < capacity && stay > 0) {
				System.out.println("impossible");
				return;
			}
		}
		System.out.println("possible");
	}
}
