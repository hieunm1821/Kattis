import java.util.*;
import java.math.*;
public class humancannonball {
	public static double cal_dist(double[] a, double[] b) {
		return Math.sqrt((a[0]-b[0])*(a[0]-b[0]) + (a[1]-b[1])*(a[1]-b[1]));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[] start = new double[2];
		double[] end = new double[2];
		start[0] = sc.nextDouble();
		start[1] = sc.nextDouble();
		end[0] = sc.nextDouble();
		end[1] = sc.nextDouble();


		int n = sc.nextInt();

		double[][] map = new double[n+2][2];
		for (int i = 1; i <= n; i ++ ) {
			map[i][0] = sc.nextDouble();
			map[i][1] = sc.nextDouble();
		}

		map[0] = start;
		map[n+1] = end;

		double[][] adjMatrix = new double[n+2][n+2];
		for (int i = 0; i < n+2; i ++ ) {
			Arrays.fill(adjMatrix[i],Double.MAX_VALUE);
			adjMatrix[i][i] = 0;
		}

		for (int i = 1; i < n + 2; i ++) {
			adjMatrix[0][i] = cal_dist(map[0], map[i])/5;
		}

		for (int i = 1; i < n + 1; i ++) {
			for (int j = 1; j < n + 2; j ++) {
				adjMatrix[i][j] = Math.min(2 + Math.abs(cal_dist(map[i], map[j])-50)/5, cal_dist(map[i], map[j])/5);
			}
		}

		for (int k = 0; k < n + 2; k ++) {
			for (int i = 0; i < n + 2; i ++) {
				for (int j = 0; j < n + 2; j ++) {
					adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k]+adjMatrix[k][j]);
				}
			}
		}
		
		System.out.println(adjMatrix[0][n+1]);

	}
}