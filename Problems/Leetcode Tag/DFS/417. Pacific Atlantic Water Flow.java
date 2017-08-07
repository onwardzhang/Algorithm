public class Solution {
    
    private final static int[] dx = {1,-1,0,0};
    private final static int[] dy = {0,0,1,-1};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        // TODO
        // dfs or bfs
        // from edges to inner-nodes or from inner-nodes to edges
        
        // dfs + from edges to inner-nodes
        List<int[]> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        boolean[][] pacConnected = new boolean[row][col];
        boolean[][] atlConnected = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            dfs(matrix, visited, 0, i, pacConnected);
        }
        for (int i = 1; i < row; i++) {
            dfs(matrix, visited, i, 0, pacConnected);
        }
        
        visited = new boolean[row][col];
        for (int i = 0; i < col; i++) {
            dfs(matrix, visited, row - 1, i, atlConnected);
        }
        for (int i = 0; i < row - 1; i++) {
            dfs(matrix, visited, i, col - 1, atlConnected);
        }
        
        // combine results
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacConnected[i][j] && atlConnected[i][j]) {
                    res.add(new int[]{i, j});
                }
            }
        }
        return res;
    }
    
    private void dfs(int[][] matrix, boolean[][] visited, int x, int y, boolean[][] connected) {
        if (visited[x][y]) {
            return;
        }
        connected[x][y] = true;
        visited[x][y] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= matrix.length || nextY < 0 || nextY >= matrix[0].length ||
                visited[nextX][nextY] || matrix[nextX][nextY] < matrix[x][y]) {
                continue;
            }
            dfs(matrix, visited, nextX, nextY, connected);
        }
    }
}