import java.util.*;
public class Coconut {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();
		int n = sc.nextInt();
		ArrayList<Integer[]> list = new ArrayList<Integer[]>(); ;

		// state 0 = hand foled, 1 = fist, 2 = palm down

		// create ((0,1),(0,2),...,(0,n)) 
		for (int i = 1; i <= n; i++) {
			Integer[] create = new Integer[] {0,i};
			list.add(i-1, create);
		}

		int index = 0;

		while (list.size() > 1) {
			index = (index + s - 1) % list.size();

			if (list.get(index)[0] == 0) {
				list.get(index)[0] = 1;
				// add [1, x] into the postion index
				Integer[] add_ele = new Integer[] {1, list.get(index)[1]};
				list.add(index, add_ele);

			} else if (list.get(index)[0] == 1) {
				list.get(index)[0] = 2;
				index += 1;

			} else {
				//remove lst[index]
				list.remove(list.get(index));

			}
		}
		System.out.println(list.get(0)[1]);
	}
}
