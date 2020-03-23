//Name: Nguyen Minh Hieu
//https://open.kattis.com/problems/workstations
import java.util.*;
public class Workstations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Integer n = sc.nextInt();
		Integer m = sc.nextInt();
		sc.nextLine();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		ArrayList<Integer[]> researchers = new ArrayList<Integer[]>();
		for (Integer i = 0; i < n; i ++) {
			Integer start = sc.nextInt();
			Integer stay = sc.nextInt();
			sc.nextLine();
			Integer time[] = {start, start+stay-1}; //format (start, end)
			researchers.add(time);
		}

		//sort researchers by starting time
		Collections.sort(researchers, (a,b) -> a[0]-b[0]);

		Integer saves = 0;
		for (Integer[] researcher: researchers) {
			if (pq.size() == 0) {
				pq.add(researcher[1]);
				continue;
			}

			while (pq.size() > 0) {
				Integer w = pq.peek();
				if (w >= researcher[0]) {
					pq.add(researcher[1]);
					break;
				}
				if (w < researcher[0] && researcher[0] <= w + m +1) {
					pq.poll();
					pq.add(researcher[1]);
					saves++;
					break;
				}
				if (researcher[0] > w + m + 1) {
					pq.poll();
				}
			}

		}

		System.out.println(saves);
	}
}
