//Name: Nguyen Minh Hieu
//Matric number: A0200814W
import java.util.*;
import java.io.*;
public class WeakVertices {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        Integer vertices = Integer.parseInt(br.readLine());

        while (vertices != -1) {
                Integer [][] adjMatrix = new Integer[vertices][vertices];

                for (int i = 0; i < vertices; i ++) {
                        String[] input = br.readLine().split(" ");
                        for (int j = 0; j < vertices; j ++) {
                                adjMatrix[i][j] = Integer.parseInt(input[j]);
                        }
                }

                for (int i = 0; i < vertices; i++) {
                        boolean weak = true;
                        for (int j = 0; j < vertices; j++) {
                                for (int k = 0; k < vertices; k ++) {
                                     if (adjMatrix[i][k]==1 && adjMatrix[i][j]==1 && adjMatrix[j][k]==1 && i!=k && i!=j && j!=k) weak = false; 
                                } 
                        }
                        if (weak) pw.print(i + " ");
                }
                pw.println();
                vertices = Integer.parseInt(br.readLine());
        }

        pw.flush();	
	}
}