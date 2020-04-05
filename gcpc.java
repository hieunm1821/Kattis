//Name: Nguyen Minh Hieu
//Matric number: A0200814W
import java.util.*;
import java.io.*;
public class gcpc {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        String[] first = br.readLine().split(" ");
        Integer n = Integer.parseInt(first[0]);
        Integer m = Integer.parseInt(first[1]);
        int[] sol = new int[n];
        int[] pen = new int[n];

        AVL tree = new AVL();
        //intialization
        for (int i = 0; i < n; i++) {
            tree.insert(new Vertex(new Team(i,0,0)));
            sol[i] = 0;
            pen[i] = 0;
        }

        for (int i = 0; i < m; i ++) {
            String[] input = br.readLine().split(" ");
            Integer t = Integer.parseInt(input[0]);
            Integer p = Integer.parseInt(input[1]);

            //delete old vertex
            tree.delete(new Vertex(new Team(t-1,sol[t-1], pen[t-1])));

            //update new vertex
            sol[t-1]++;
            pen[t-1]+=p;
            tree.insert(new Vertex(new Team(t-1,sol[t-1],pen[t-1])));

            //find position of fav team
            int position = n - tree.rank(new Vertex(new Team(0,sol[0],pen[0])));
            pw.println(position);
        }

        pw.flush(); 
    }
}


class Team implements Comparable<Team> {
    public int solved, penalty, teamNo;
    public Team(int teamNo, int solved, int penalty) {
        this.teamNo = teamNo;
        this.solved = solved;
        this.penalty = penalty;
    }
    public int compareTo(Team a) {
        if (this.solved != a.solved) return this.solved - a.solved;
        else if (this.penalty != a.penalty) return a.penalty - this.penalty;
        return a.teamNo - this.teamNo;
    }
}

class Vertex implements Comparable<Vertex>{
    public Vertex parent, left, right;
    public Team key;
    public int height;
    public int size;

    Vertex(Team v) {
        key = v; 
        parent = left = right = null; 
        height = 0;  
        size = 1;
    }
    public int compareTo(Vertex a) {return key.compareTo(a.key);}
}

class AVL {

    public Vertex root;

    public AVL() {root = null;}

    public Vertex search(Vertex v) {
    	Vertex res = search(root,v);
    	return res == null ? null : res;
    }
    public Vertex search(Vertex T, Vertex v) {
    	if (T == null) return null;
    	else if (T.compareTo(v) == 0) return T;
    	else if (T.compareTo(v) < 0) return search(T.right,v);
    	return search(T.left, v);
    }

    public Vertex findMin() {return findMin(root);}

    public Vertex findMin(Vertex T) {
        if (T.left == null) return T;
        return findMin(T.left);
    }

    public Vertex findMax() {return findMax(root);}

    public Vertex findMax(Vertex T) {
        if (T.right == null) return T;
        return findMin(T.right);
    }

    public Vertex successor(Vertex T) {
        if (T.right != null) return findMin(T.right);
        else {
            Vertex par = T.parent;
            Vertex cur = T;
            while ((par != null) && (cur == par.right)) {
                cur = par;
                par = cur.parent;
            }
            return par == null ? null : par;
        }
    }
    public Vertex predecessor(Vertex T) {
        if (T.left != null) return findMax(T.left);
        else {
            Vertex par = T.parent;
            Vertex cur = T;
            while ((par != null) && (cur == par.left)) {
                cur = par;
                par = cur.parent;
            }
            return par == null ? null : par;
        }
    }

    public void inorder() {
    	inorder(root);
    	System.out.println();
    }

    public void inorder(Vertex T) {
        if (T == null) return;
        inorder(T.left);
        //print T
        inorder(T.right);
    }    

    public void insert(Vertex v) { root = insert(root, v);}

    public Vertex insert(Vertex T, Vertex v) {
        if (T == null) return v;
        if (T.compareTo(v) < 0) {
            T.right = insert(T.right , v);
            T.right.parent = T;
        } else {
            T.left = insert(T.left, v);
            T.left.parent = T;
        }
        update(T);
        return balance(T);
    }

    public void delete(Vertex v) { root = delete(root, v);}

    public Vertex delete(Vertex T, Vertex v) {
        if (T.compareTo(v) < 0) T.right = delete(T.right,v);
        else if (T.compareTo(v) > 0) T.left = delete(T.left, v);
        else {
            if (T.left == null) return T.right;
            else if (T.right == null) return T.left;
            else {
            	Vertex temp = T;
                T = successor(temp);
                T.right = delete(temp.right,successor(temp));
                T.left = temp.left;
            }
        }
        update(T);
        return balance(T);
    }

    public int height(Vertex v) {
        if (v == null) return -1;
        return v.height;
    }
    public int size(Vertex v) {
        if (v == null) return 0;
        return v.size;
    }

    public void update(Vertex T) {
        T.height = 1 + Math.max(height(T.left), height(T.right));
        T.size = 1 + size(T.left) + size(T.right);
    }

    public int bf(Vertex T) {return height(T.left) - height(T.right);}

    public Vertex rotateLeft (Vertex T) {
        Vertex W = T.right;
        W.parent = T.parent;
        T.parent = W;
        T.right = W.left;
        if (W.left != null) W.left.parent = T;
        W.left = T;
        update(T);
        update(W);
        return W;
    }

    public Vertex rotateRight (Vertex T) {
            Vertex W = T.left;
            W.parent = T.parent;
            T.parent = W;
            T.left = W.right;
            if (W.right != null) W.right.parent = T;
            W.right = T;
            update(T);
            update(W);
            return W; 
    }

    public Vertex balance(Vertex T) {
        if (bf(T) > 1) {
            if (bf(T.left) < 0) T.left = rotateLeft(T.left);
            T = rotateRight(T);
        }
        if (bf(T) < -1) {
            if (bf(T.right) > 0) T.right = rotateRight(T.right);
            T = rotateLeft(T);
        }
        return T;
    }

    public int rank(Vertex v) {return rank(root, v);}

    public int rank(Vertex T, Vertex v) {
        int i = 0;
        while (T != null) {
            if (T.compareTo(v) > 0) {
                T = T.left;
            } else if (T.compareTo(v) < 0) {
            	i += 1 + size(T.left);
                T = T.right;
            } else return i + size(T.left);
        }
        return i;
    }

}