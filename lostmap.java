import java.util.*;
import java.io.*;

class IntegerTriple implements Comparable<IntegerTriple> {
	public Integer _source, _destination, _weight;

	public IntegerTriple(Integer s, Integer d, Integer w) {
	    _source = s;
	    _destination = d;
	    _weight = w;
  	}

	public int compareTo(IntegerTriple o) {
		if (!this.weight().equals(o.weight()))
			return this.weight() - o.weight();
		else
			return this.dest() - o.dest();
  	}

  	Integer source() { return _source; }
  	Integer dest() { return _destination; }
 	Integer weight() { return _weight; }
}

class lostmap {
	public static ArrayList < ArrayList < IntegerTriple > > AdjList;
	public static ArrayList < Boolean > taken;
	public static PriorityQueue < IntegerTriple > pq;

	public static void process(int vtx) {
	    taken.set(vtx, true);
	    for (int j = 0; j < AdjList.get(vtx).size(); j++) {
	    	IntegerTriple v = AdjList.get(vtx).get(j);
	    	if (!taken.get(v.dest())) {
	    		pq.offer(new IntegerTriple(vtx, v.dest(), v.weight())); 
	    	}
	    }
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

		Integer V = Integer.parseInt(br.readLine());
		AdjList = new ArrayList < ArrayList < IntegerTriple > >();
		Integer[][] distance = new Integer[V][V];

		for (int i = 0; i < V; i ++) {
			String[] input = br.readLine().split(" ");
			for (int j = 0; j < V; j++) {
				distance[i][j] = Integer.parseInt(input[j]);
			}
		}

		for (int i = 0; i < V; i ++) {
			ArrayList < IntegerTriple > Neighbor = new ArrayList < IntegerTriple >();
			AdjList.add(Neighbor);
		}

		for (int i = 0; i < V; i ++) {
			for (int j = 0; j < V; j++) {
				AdjList.get(i).add(new IntegerTriple(i,j,distance[i][j])); 
			}
		}

		taken = new ArrayList < Boolean >(); taken.addAll(Collections.nCopies(V, false));
		pq = new PriorityQueue < IntegerTriple > ();

		process(0);

		while (!pq.isEmpty()) {
			IntegerTriple front = pq.poll();
			if (!taken.get(front.dest())) {
				Integer s = front.source() + 1;
				Integer d = front.dest() +1 ;
				pw.println(s + " " + d);
				process(front.dest());
			}
		}
		pw.close();
	}
} 