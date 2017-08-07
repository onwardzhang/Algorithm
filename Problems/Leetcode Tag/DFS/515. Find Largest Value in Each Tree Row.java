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
    // public List<Integer> largestValues(TreeNode root) {
    //     // bfs
    //     List<Integer> res = new LinkedList<>();
    //     if (root == null) {
    //         return res;
    //     }
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         int max = Integer.MIN_VALUE;
    //         while (size-- > 0) {
    //             TreeNode tmp = queue.poll();
    //             if (tmp.left != null) {
    //                 queue.offer(tmp.left);
    //             }
    //             if (tmp.right != null) {
    //                 queue.offer(tmp.right);
    //             }
    //             max = Math.max(max, tmp.val);
    //         }
    //         res.add(max);
    //     }
    //     return res;
    // }
    
    public List<Integer> largestValues(TreeNode root) {
        // dfs
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    
    private void dfs(TreeNode root, int level, List<Integer> res) {
        if (root == null) {
            return;
        }
        // [IMPORTANT] ArrayList.get(index) Throws: IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
        // [IMPORTANT] ArrayList.add(index, val) won't override the val if [index] has val; use .set(index, val) to override
        // if (level >= res.size() || res.get(level) < root.val) {
        //     res.add(level, root.val);
        // }
        if (level >= res.size()) {
            res.add(root.val); // no need to use index:level, must be the last one
        } else {
            if (res.get(level) < root.val) {
                res.set(level, root.val);
            }
        }
        dfs(root.left, level + 1, res);
        dfs(root.right, level + 1, res);
    }
}