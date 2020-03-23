import java.util.*;
public class Conformity {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();

		HashMap <String, Integer> map = new HashMap <String, Integer>();
		for (int i = 0; i < n; i ++) {
			String[] input = sc.nextLine().split(" ");
			Arrays.sort(input); // count combination in different order
			String key = String.join("", input); //make a key
			if (!map.containsKey(key)) map.put(key,0);
			int value = map.get(key);
			value++;
			map.put(key, value);
		}
		
		//find the maximun in value
		Integer[] values = new Integer[map.values().size()];
		map.values().toArray(values);
		Integer max = 0;
		for (int i =0; i < values.length; i++) {
			if(values[i] > max) max = values[i];
		}

		Integer result = 0;
		for (int i =0; i < values.length; i++) {
			if(values[i] == max) result += max;
		}
		System.out.println(result);
	}
}