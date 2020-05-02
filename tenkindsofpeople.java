import java.util.*;
import java.io.*;
class IntegerPair {
	public int first,second;
	public IntegerPair(int row, int col) {
		first = row;
		second = col;
	}
}
public class tenkindsofpeople {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputrc = br.readLine().split(" ");
        int r = Integer.parseInt(inputrc[0]);
        int c = Integer.parseInt(inputrc[1]);

        int[][] map = new int[r][c];
        int[][] visited = new int[r][c];
        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
                visited[i][j] = 0;
            }
        }

        int count = 1;

        for(int i = 0; i < r; i ++) {
        	for (int j = 0; j < c; j ++) {
        		if (map[i][j] == 0) {
        			if (visited[i][j] == 0) {
        				visited[i][j] = count;
        				Queue<IntegerPair> queue = new LinkedList<IntegerPair>();
        				queue.offer(new IntegerPair(i,j));
        				while (queue.size() > 0) {
        					IntegerPair v = queue.poll();
        					int a = v.first;
        					int b = v.second;
        					if (a > 0 && map[a-1][b] == 0 && visited[a-1][b] == 0) {
        						queue.offer(new IntegerPair(a - 1,b));
        						visited[a-1][b] = count;
        					}
        					if (a < r - 1 && map[a+1][b] == 0 && visited[a+1][b] == 0) {
        						queue.offer(new IntegerPair(a + 1,b));
        						visited[a+1][b] = count;
        					}
        					if (b > 0 && map[a][b-1] == 0 && visited[a][b-1] == 0) {
        						queue.offer(new IntegerPair(a,b - 1));
        						visited[a][b-1] = count;
        					}
        					if (b < c - 1 && map[a][b+1] == 0 && visited[a][b+1] == 0) {
        						queue.offer(new IntegerPair(a,b + 1));
        						visited[a][b+1] = count;
        					}
        				}
        				count ++;
        			}
        		} else {
        				if (visited[i][j] == 0) {
	        				visited[i][j] = count;
	        				Queue<IntegerPair> queue = new LinkedList<IntegerPair>();
	        				queue.offer(new IntegerPair(i,j));
	        				while (queue.size() > 0) {
	        					IntegerPair v = queue.poll();
	        					int a = v.first;
	        					int b = v.second;
	        					if (a > 0 && map[a-1][b] == 1 && visited[a-1][b] == 0) {
	        						queue.offer(new IntegerPair(a - 1,b));
	        						visited[a-1][b] = count;
	        					}
	        					if (a < r - 1 && map[a+1][b] == 1 && visited[a+1][b] == 0) {
	        						queue.offer(new IntegerPair(a + 1,b));
	        						visited[a+1][b] = count;
	        					}
	        					if (b > 0 && map[a][b-1] == 1 && visited[a][b-1] == 0) {
	        						queue.offer(new IntegerPair(a,b - 1));
	        						visited[a][b-1] = count;
	        					}
	        					if (b < c - 1 && map[a][b+1] == 1 && visited[a][b+1] == 0) {
	        						queue.offer(new IntegerPair(a,b + 1));
	        						visited[a][b+1] = count;
	        					}
	        				}
        				count ++;
        				}
        			}
        	}
        }

        int queries = Integer.parseInt(br.readLine());
        for (int i = 0; i < queries; i ++) {

	        String[] input = br.readLine().split(" ");
	        int r1 = Integer.parseInt(input[0]) - 1;
	        int c1 = Integer.parseInt(input[1]) - 1;      	
	        int r2 = Integer.parseInt(input[2]) - 1;
	        int c2 = Integer.parseInt(input[3]) - 1;

	        if (map[r1][c1] == 0 && visited[r1][c1] == visited[r2][c2]) System.out.println("binary");
	        else if (map[r1][c1] == 1 && visited[r1][c1] == visited[r2][c2]) System.out.println("decimal");
	        else System.out.println("neither");
	    }
	}

}