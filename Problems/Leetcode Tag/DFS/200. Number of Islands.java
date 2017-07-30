public class Solution {
    
    private final int[] dx = {1, -1, 0, 0};
    private final int[] dy = {0, 0, 1, -1};
    
//     public int numIslands(char[][] grid) {
//         if (grid == null || grid.length == 0 || grid[0].length == 0) {
//             return 0;
//         }
//         int row = grid.length;
//         int col = grid[0].length;
//         boolean[][] visited = new boolean[row][col];
//         int count = 0;
//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 if (grid[i][j] == '1' && !visited[i][j]) {
//                     // mark by bfs
//                     bfs(i, j, visited, grid, row, col);
//                     //dfs(i, j, visited, grid); // mark by dfs, not recommend, because if all one, may stack overflow
//                     count++;
//                 }
//             }
//         }
//         return count;
//     }
    
//     private void bfs(int x, int y, boolean[][] visited, char[][] grid, int row, int col) {
//         Queue<Integer> queue = new LinkedList<>();
//         queue.offer(x * col + y);
//         visited[x][y] = true;
//         while (!queue.isEmpty()) {
//             int pos = queue.poll();
//             int tempX = pos / col;
//             int tempY = pos % col;
//             for (int k = 0; k < dx.length; k++) {
//                 int nextX = tempX + dx[k];
//                 int nextY = tempY + dy[k];
//                 if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited[nextX][nextY] ||
//                     grid[nextX][nextY] == '0') {
//                     continue;
//                 }
//                 queue.offer(nextX * col + nextY);
//                 visited[nextX][nextY] = true;
//             }
//         }
//     }
    
// //     private void dfs(int x, int y, boolean[][] visited, char[][] grid) {
// //         visited[x][y] = true;
// //         for (int k = 0; k < dx.length; k++) {
// //             int nextX = x + dx[k];
// //             int nextY = y + dy[k];
// //             if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length || visited[nextX][nextY] ||
// //                 grid[nextX][nextY] == '0') {
// //                 continue;
// //             }
// //             dfs(nextX, nextY, visited, grid);
// //         }
// //     }
    
    // union find
    private int[] father;
    private int count;
    
    private int find(int x) {
        if (father[x] == x) {
            return x;
        }
        return father[x] = find(father[x]);
    }
    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
            count--;
        }
    }
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        Set<Integer> visitedIslands = new HashSet<>();
        //boolean[][] visited = new boolean[row][col];
        father = new int[row * col];
        for (int i = 0; i < row * col; i++) {
            father[i] = i;
        }
        count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    continue;
                }
                // grid[i / col][i % col] == '1', reduce one level indent
                count++;
                visitedIslands.add(i * col + j);
                for (int k = 0; k < dx.length; k++) {
                    int nextX = i + dx[k];
                    int nextY = j + dy[k];
                    if (nextX < 0 || nextX >= grid.length || nextY < 0 || nextY >= grid[0].length) {
                        continue;
                    }
                    if (visitedIslands.contains(nextX * col + nextY)) {
                        union(nextX * col + nextY, i * col + j);
                    }
                }
            }
        }
        return count;
    }
//     // union find， number of island ii, http://www.lintcode.com/en/problem/number-of-islands-ii/
//     /**
//  * Definition for a point.
//  * class Point {
//  *     int x;
//  *     int y;
//  *     Point() { x = 0; y = 0; }
//  *     Point(int a, int b) { x = a; y = b; }
//  * }
//  */
// public class Solution {
//     /**
//      * @param n an integer
//      * @param m an integer
//      * @param operators an array of point
//      * @return an integer array
//      */
//     private int[] father;
//     private int count;
    
//     private int find(int x) {
//         if (father[x] == x) {
//             return x;
//         }
//         return father[x] = find(father[x]);
//     }
    
//     private void connect(int a, int b) {
//         int rootA = find(a);
//         int rootB = find(b);
//         if (rootA != rootB) {
//             father[rootA] = rootB;
//             count--;
//         }
//     }

//     public List<Integer> numIslands2(int n, int m, Point[] operators) {
//         // Write your code here
//         List<Integer> res = new ArrayList<>();
//         if (operators == null || operators.length == 0) {
//             return res;
//         }
//         Set<Integer> island = new HashSet<>();
//         father = new int[n * m];
//         for (int i = 0; i < n * m; i++) {
//             father[i] = i;
//         }
//         count = 0;
//         int[] dx = {1, -1, 0, 0};
//         int[] dy = {0, 0, 1, -1};
//         for (Point point : operators) {
//             island.add(point.x * m + point.y);
//             count++;
//             for (int i = 0; i < 4; i++) {
//                 int x = point.x + dx[i];
//                 int y = point.y + dy[i];
//                 if (x < 0 || x >= n || y < 0 || y >= m) {
//                     continue;
//                 }
//                 if (island.contains(x * m + y)) {
//                     connect(point.x * m + point.y, x * m + y);
//                 }
//             }
//             res.add(count);
//         }
//         return res;
//     }
// }
}