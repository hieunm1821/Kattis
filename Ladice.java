//Name: Nguyen Minh Hieu
//Matric number: A0200814W
import java.util.*;
import java.io.*;
public class Ladice {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] first = br.readLine().split(" ");
        Integer n = Integer.parseInt(first[0]);
        Integer l = Integer.parseInt(first[1]);
        
        UnionFind UF  = new UnionFind(l);

        for (int i = 0; i < n; i ++) {
            String[] input = br.readLine().split(" ");
            Integer a = Integer.parseInt(input[0]);
            Integer b = Integer.parseInt(input[1]);

            UF.unionSet(a-1,b-1); //UF start from 0 while drawers start from 1
            if (UF.updateUsed(a-1)) pw.println("LADICA");
            else pw.println("SMECE");
        }

        pw.flush();	
	}
}

//modified UnionFind class from Lecture Kruskal Demo.
class UnionFind {
  public int[] p;
  public int[] rank;
  public int[] setSize;
  public int[] used;

  public UnionFind(int N) {
    p = new int[N];
    rank = new int[N];
    setSize = new int[N];
    used = new int[N];

    for (int i = 0; i < N; i++) {
      p[i] = i;
      rank[i] = 0;
      setSize[i] = 1;
      used[i] = 0;
    }
  }

  public int findSet(int i) { 
    if (p[i] == i) return i;
    else {
      p[i] = findSet(p[i]);
      return p[i]; 
    } 
  }

  public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

  public void unionSet(int i, int j) { 
    if (!isSameSet(i, j)) { 
      int x = findSet(i), y = findSet(j);
      // rank is used to keep the tree short
      if (rank[x] > rank[y]) { 
        p[y] = x; 
        setSize[x] = setSize[x] + setSize[y];
        used[x] = used[x] + used[y];  
      }
      else { 
        p[x] = y; 
        setSize[y] = setSize[y] + setSize[x];
        used[y] = used[y] + used[x];  
        if (rank[x] == rank[y]) 
          rank[y] = rank[y]+1; 
      } 
    } 
  }

  public Boolean updateUsed(int i) {
    int x = findSet(i);
    used[x]++;
    if (used[x] <= setSize[x]) return true;
    else {
        used[x]--;
        return false;
    }
  }
}

