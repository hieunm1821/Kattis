//Name: Nguyen Minh Hieu
//https://open.kattis.com/problems/kattissquest
import java.util.*;
import java.io.*;
public class kattissquest {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        Integer n = Integer.parseInt(br.readLine());
        TreeMap <Integer, PriorityQueue<Integer>> data = new TreeMap<Integer, PriorityQueue<Integer>>();

        for (Integer i = 0; i < n; i ++) {
        	String[] command = br.readLine().split(" ");
        	
        	if (command[0].equals("add")) {
        		Integer energy = Integer.parseInt(command[1]);
        		Integer gold = Integer.parseInt(command[2]);
        		if (!data.containsKey(energy)) data.put(energy, new PriorityQueue<Integer>(Comparator.reverseOrder())); 
        		data.get(energy).add(gold);
        	}

        	if (command[0].equals("query")) {
        		Integer x = Integer.parseInt(command[1]);
        		long result = 0;
        		while (data.size() > 0) {
        			Integer energy = data.floorKey(x);
        			if (energy == null) break;
        			result += data.get(energy).poll();
        			x -= energy;
        			if (data.get(energy).size() == 0) data.remove(energy);
        		}
        		pw.println(result);
        	}

        }
        pw.flush();
	}
}
