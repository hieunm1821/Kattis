
import java.util.*;
import java.lang.Math;

class Node {
	int row,col,height,diff;
	public Node(int x, int y, int _diff) {
		row = x;
		col = y;
		diff = _diff;
	}
}

class newComparator implements Comparator<Node> {
	public int compare(Node t, Node o) {
		return o.diff - t.diff;
	}
}

public class millionairemadness {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int[][] map = new int[m][n];
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				map[i][j] = sc.nextInt();
				visited[i][j] = false;
			}
		}

		int minLadder = 0;
		PriorityQueue<Node> pq = new PriorityQueue<Node>(new newComparator());
		pq.offer(new Node(0,0,0));
		visited[0][0] = true;

		while (visited[m-1][n-1] == false && !pq.isEmpty()) {
			Node v = pq.poll();
			visited[v.row][v.col] = true;
			if (minLadder > v.diff) minLadder = v.diff;

			if (v.row > 0 && visited[v.row - 1][v.col] == false) 
				pq.offer(new Node(v.row-1,v.col, map[v.row][v.col] - map[v.row - 1][v.col]));

			if (v.row < m - 1 && visited[v.row + 1][v.col] == false) 
				pq.offer(new Node(v.row+1,v.col, map[v.row][v.col] - map[v.row + 1][v.col]));

			if (v.col > 0 && visited[v.row][v.col-1] == false) 
				pq.offer(new Node(v.row,v.col-1, map[v.row][v.col] - map[v.row][v.col - 1]));

			if (v.col < n - 1 && visited[v.row][v.col+1] == false) 
				pq.offer(new Node(v.row,v.col+1, map[v.row][v.col] - map[v.row][v.col + 1]));
		}
		System.out.println(Math.abs(minLadder));
	}
}