public class Solution {
    // public char[][] updateBoard(char[][] board, int[] click) {
    //     // bfs, slow
    //     if (board == null || board.length == 0 || board[0].length == 0 || click == null || click.length != 2) {
    //         return board;
    //     }
    //     if (board[click[0]][click[1]] == 'M') {
    //         board[click[0]][click[1]] = 'X';
    //         return board;
    //     }
    //     Queue<Integer> queue = new LinkedList<>();
    //     final int row = board.length;
    //     final int col = board[0].length;
    //     // Set<Integer> visited = new HashSet<>(); // can be avoid, change the value to mark as visited, marked elements will be all be judged later, therefore no need to worry about the changes
    //     final int[] dx = {1,1,1,0,0,-1,-1,-1};
    //     final int[] dy = {1,0,-1,1,-1,-1,0,1};
    //     final char MARK = '@';
    //     queue.offer(click[0] * col + click[1]);
    //     // visited.add(click[0] * col + click[1]);
    //     while (!queue.isEmpty()) {
    //         int tmp = queue.poll();
    //         int x = tmp / col;
    //         int y = tmp % col;
    //        // count the # of mines
    //         int mineCount = 0;
    //         for (int i = 0; i < dx.length; i++) {
    //             int nextX = x + dx[i];
    //             int nextY = y + dy[i];
    //             // if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited.contains(nextX * col + nextY)) {
    //             //     continue;
    //             // }
    //             if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
    //                 continue;
    //             }
    //             if (board[nextX][nextY] == 'M') {
    //                 mineCount++;
    //             }
    //         }
    //         if (mineCount == 0) {
    //             board[x][y] = 'B';
    //             for (int i = 0; i < dx.length; i++) {
    //                 int nextX = x + dx[i];
    //                 int nextY = y + dy[i];
    //                 // if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited.contains(nextX * col + nextY)) {
    //                 //     continue;
    //                 // }
    //                 if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || board[nextX][nextY] != 'E') {
    //                     continue;
    //                 }
    //                 queue.offer(nextX * col + nextY);
    //                 board[nextX][nextY] = MARK;
    //                 // visited.add(nextX * col + nextY);
    //             }
    //         } else {
    //             board[x][y] = (char) (mineCount + '0');
    //         }
    //     }
    //     return board;
    // }
    
     private final int[] dx = {1,1,1,0,0,-1,-1,-1};
     private final int[] dy = {1,0,-1,1,-1,-1,0,1};
    
     public char[][] updateBoard(char[][] board, int[] click) {
        // dfs IMPORTANT this is also a way of dfs, kind of abstract, but faster than bfs, because no need to set MARK?
         // because bfs extra space is the queue, at most 8 elements; dfs at worst n elements? why faster?
        if (board == null || board.length == 0 || board[0].length == 0 || click == null || click.length != 2) {
            return board;
        }
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
         
        dfs(board, click[0], click[1]);
        return board;
    }
    
    private void dfs(char[][] board, int x, int y) {
        int row = board.length;
        int col = board[0].length;
        int mineCount = 0;
        
        // count the # of mines
        for (int i = 0; i < dx.length; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX < 0 || nextX >= board.length || nextY < 0 || nextY >= board[0].length) {
                continue;
            }
            if (board[nextX][nextY] == 'M') {
                mineCount++;
            }
        }
        if (mineCount == 0) {
            board[x][y] = 'B';
            for (int i = 0; i < dx.length; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || board[nextX][nextY] != 'E') { // keypoint board[nextX][nextY] != 'E', previous dfs-visited points must not be 'E'
                    continue;
                }
                dfs(board, nextX, nextY);
            }
        } else {
            board[x][y] = (char) (mineCount + '0'); // IMPORTANT: convert int to char
        }
    }
        //     while (!queue.isEmpty()) {
        //     int tmp = queue.poll();
        //     int x = tmp / col;
        //     int y = tmp % col;
        //     int mineCount = 0;
        //     for (int i = 0; i < dx.length; i++) {
        //         int nextX = x + dx[i];
        //         int nextY = y + dy[i];
        //         // if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited.contains(nextX * col + nextY)) {
        //         //     continue;
        //         // }
        //         if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) {
        //             continue;
        //         }
        //         if (board[nextX][nextY] == 'M') {
        //             mineCount++;
        //         }
        //     }
        //     if (mineCount == 0) {
        //         board[x][y] = 'B';
        //         for (int i = 0; i < dx.length; i++) {
        //             int nextX = x + dx[i];
        //             int nextY = y + dy[i];
        //             // if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || visited.contains(nextX * col + nextY)) {
        //             //     continue;
        //             // }
        //             if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col || board[nextX][nextY] != 'E') {
        //                 continue;
        //             }
        //             queue.offer(nextX * col + nextY);
        //             board[nextX][nextY] = MARK;
        //             // visited.add(nextX * col + nextY);
        //         }
        //     } else {
        //         board[x][y] = (char) (mineCount + '0');
        //     }
        // }
        // return board;
}