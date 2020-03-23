//Name: Nguyen Minh Hieu
//https://open.kattis.com/problems/t9spelling
import java.util.*;
public class T9Spelling {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		n = sc.nextInt();
		sc.nextLine();

		Map<String,String> dict = new HashMap<String, String>();
		dict.put("a","2");
		dict.put("b","22");
		dict.put("c","222");
		dict.put("d","3");
		dict.put("e","33");
		dict.put("f","333");
		dict.put("g","4");
		dict.put("h","44");
		dict.put("i","444");
		dict.put("j","5");
		dict.put("k","55");
		dict.put("l","555");
		dict.put("m","6");
		dict.put("n","66");
		dict.put("o","666");
		dict.put("p","7");
		dict.put("q","77");
		dict.put("r","777");
		dict.put("s","7777");
		dict.put("t","8");
		dict.put("u","88");
		dict.put("v","888");
		dict.put("w","9");
		dict.put("x","99");
		dict.put("y","999");
		dict.put("z","9999");
		dict.put(" ","0"); 
		for (int i = 1; i <= n; i++) {
			char[] input  = sc.nextLine().toCharArray();
			String[] temp = new String[input.length];
			String output = "";
			for (int j = 0; j < input.length; j++) {
				String value = dict.get(Character.toString(input[j]));
				temp[j] = value;
			}
			output = temp[0];
			for (int k = 1; k <= temp.length - 1; k++ ) {
				if (temp[k].charAt(0) == temp[k-1].charAt(0)) {
					output += " ";
				} 
				output += temp[k];
			}
			System.out.println("Case #" + i +":" + " " + output);
		}
	}
}	
