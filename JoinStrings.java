//Name: Nguyen Minh Hieu
//https://open.kattis.com/problems/joinstrings
import java.util.*;
import java.io.*;
public class JoinStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine());

        String[] input = new String[n + 1];
        for (int i = 1; i < n + 1; i++) {
            input[i] = br.readLine();
        }

        int[] updated = new int[n + 1];
        int[] order = new int[n + 1];

        int a = 0;
        int b = 0;
        for (int i = 0; i < n - 1; i++) {
            String[] command = br.readLine().split(" ");
            a = Integer.parseInt(command[0]);
            b = Integer.parseInt(command[1]);

            if (updated[a] == 0) {
                updated[a] = b;
                order[a] = b;
            } else {
                int temp = updated[a];
                while (updated[temp] != 0) {
                    temp = updated[temp];
                }
                updated[a] = b;
                order[temp] = b;  
            }
        }

        while (order[a] != 0) {
            pw.append(input[a]);
            a = order[a];
        }
        pw.append(input[a]);
        pw.flush();
    }
}
