public class Solution {
    // different from Number of Island!
    // union find, fast!
    // TODO dfs, bfs 
    private final static int[] dx = {1,-1,0,0};
    private final static int[] dy = {0,0,1,-1};
    private int[] father;
    private int count;
    
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
        // return father[x] = find(father[x]);
    }
    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            count--;
            father[rootA] = rootB;
        }
    }
    
    public int findCircleNum(int[][] M) {
        // union find
        if (M == null || M.length == 0 || M[0].length == 0 || M.length != M[0].length) { // row == col
            return 0;
        }
        int n = M.length;
        count = n;
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return count;
    }
}