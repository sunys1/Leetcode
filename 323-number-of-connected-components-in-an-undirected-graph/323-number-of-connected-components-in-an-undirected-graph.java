class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        // Connect all the dots
        for (int[] e : edges) {
            uf.union(e[0], e[1]);
        }
        // return the count of connected component
        return uf.count();
    }
}

class UF {
    private int count;
    private int[] parent;

    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }
    
    private int find(int x) {
        while (parent[x] != x)
            x = parent[x];
        return x;
    }
    
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;
        parent[rootP] = rootQ;

        count--;
    }
    
    public int count() { 
        return count;
    }
}