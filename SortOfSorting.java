import java.util.*;

public class SortOfSorting {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num_case = 1;
		while (num_case != 0) {
			num_case = sc.nextInt();
			sc.nextLine();
			if (num_case == 0) break;

			String[] list = new String[num_case];

			for (int i = 0; i < num_case; i++) {
				list[i] = sc.nextLine();
			}

			Comparator<String> c = new Comparator<String>() {
				@Override
				public int compare(String s1, String s2) {
					if (s1.charAt(0) != s2.charAt(0)) {
					return s1.charAt(0) - s2.charAt(0);
					} else {
						return s1.charAt(1) - s2.charAt(1);
					}
				}
			};

			Arrays.sort(list,c);

			for (String result: list)
				System.out.println(result);
			System.out.println("");

		}
	}
}