public class Solution {
    // // divide & conquer, dfs, O(N) time, O(N) space at worst
    // public int minDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     // if (root.left == null && root.right == null) {
    //     //     return 1;
    //     // }
    //     if (root.left == null) {
    //         return 1 + minDepth(root.right);
    //     }
    //     if (root.right == null) {
    //         return 1 + minDepth(root.left);
    //     }
    //     return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    // }
    
    // bfs, level order traversal, O(N) time, O(N/2) space
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                TreeNode tmp = queue.poll();
                if (tmp.left == null && tmp.right == null) {
                    return level;
                }
                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }
                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }
        }
        return -1;
    }
}