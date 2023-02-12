package algorithms.graphs;

import java.util.Arrays;
import java.util.Scanner;

public class UFDS {

    static int[] par;
    static int[] rank; // optional speedup
    static int[] setSize; // optional feature
    static int numSets; // optional feature

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        par = new int[N];
        for (int i=0; i<N; i++) par[i] = i;
        rank = new int[N];  // optional speedup
        setSize = new int[N]; // optional feature
        Arrays.fill(setSize, 1);
        numSets = N; // optional feature

        unionSet(sc.nextInt(), sc.nextInt());
        unionSet(sc.nextInt(), sc.nextInt());
        unionSet(sc.nextInt(), sc.nextInt());
        System.out.println(numDisjointSets());
        System.out.println(sizeOfSet(2));
    }

    private static void unionSet(int i, int j) {
        if (isSameSet(i, j)) return;
        int x = findSet(i), y = findSet(j);
        if (rank[x] > rank[y]) { // always attach smaller rank to larger
            // swap
            int temp = x;
            x = y;
            y = temp;
        }

        par[x] = y;
        if (rank[x] == rank[y]) rank[y]++;
        setSize[y] += setSize[x];
        --numSets;
    }

    private static int findSet(int i) {
        return (par[i] == i) ? i : (par[i] = findSet(par[i]));
    }

    private static boolean isSameSet(int i, int j) {
        return findSet(i) == findSet(j);
    }

    private static int numDisjointSets() {
        return numSets;
    }

    private static int sizeOfSet(int i) {
        return setSize[findSet(i)];
    }
}
