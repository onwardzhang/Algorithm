/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //     // bfs
    // public int findBottomLeftValue(TreeNode root) {
    //     int result = Integer.MIN_VALUE;
    //     if (root == null) {
    //         return result;
    //     }
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         while (size-- > 0) {
    //             TreeNode tmp = queue.poll();
    //             result = tmp.val;
    //             // find left most -> right first in, first out, left in/out later
    //             if (tmp.right != null) {
    //                 queue.offer(tmp.right);
    //             }
    //             if (tmp.left != null) {
    //                 queue.offer(tmp.left);
    //             }
    //         }
    //     }
    //     return result;
    // }
    
    // dfs
    public int findBottomLeftValue(TreeNode root) {
        int[] res = new int[2]; // res[0] result, res[1] results' level
        dfs(root, res, 0);
        return res[0];
    }
    private void dfs(TreeNode root, int[] res, int level) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (level >= res[1]) {
                res[0] = root.val;
                res[1] = level;
            }
            return;
        }
        // right first
        dfs(root.right, res, level + 1);
        dfs(root.left, res, level + 1);
    }
}