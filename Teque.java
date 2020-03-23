//Name: Nguyen Minh Hieu
//Student number: A0200814W
import java.util.*;
import java.io.*;
public class Teque {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

		int n = Integer.parseInt(br.readLine());

		HashMap<Integer, Integer> first = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> second = new HashMap<Integer, Integer>();
		int firstHead = 0;
		int firstTail = 0;
		int secondHead = 0;
		int secondTail = 0;

		for (int i = 0; i < n; i ++) {
			String[] command = br.readLine().split(" ");
			int num = Integer.parseInt(command[1]);

			if (command[0].equals("push_back")) {
				second.put(secondTail, num);
				secondTail++;
				if (second.size() > first.size() + 1) {
					first.put(firstTail,second.get(secondHead));
					firstTail++;
					secondHead++;
					second.remove(secondHead-1);
				}
			} else if (command[0].equals("push_front")) {
					firstHead--;
					first.put(firstHead,num);
					if (first.size() > second.size()) {
						firstTail--;
						secondHead--;
						second.put(secondHead,first.get(firstTail));
						first.remove(firstTail);
					}
			} else if (command[0].equals("push_middle")) {
					if (first.size() == second.size()) {
						secondHead--;
						second.put(secondHead,num);
					} else {
						first.put(firstTail,second.get(secondHead));
						firstTail++;
						second.put(secondHead, num);
					}
			} else if (command[0].equals("get")) {
				if (num < firstTail - firstHead) {
					pw.println(first.get(firstHead + num));	
				} else {
					pw.println(second.get(secondHead + num - (firstTail -firstHead)));
				}
			}
		}
		pw.flush();
	}
}
