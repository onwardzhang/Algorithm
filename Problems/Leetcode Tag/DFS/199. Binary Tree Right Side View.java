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
    // // straightforward level order bfs
    // // O(n) time, every node be pushed and polled one time, at worst O(n/2) space
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     if (root == null) {
    //         return res;
    //     }
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         int size = queue.size();
    //         while (size-- > 0) {
    //             TreeNode tmp = queue.poll();
    //             if (size == 0) {
    //                 res.add(tmp.val); // level order, right most node
    //             }
    //             if (tmp.left != null) {
    //                 queue.offer(tmp.left);
    //             }
    //             if (tmp.right != null) {
    //                 queue.offer(tmp.right);
    //             }
    //         } 
    //     }
    //     return res;
    // }
    
    // smarter recursion dfs
    // O(n) time, at worst O(n) space, at average O(logn) space
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res, int level) {
        if (root == null) {
            return;
        }
        if (level == res.size()) { // add the root.val into res if level == res.size(), then the res.size() increase by one, the others in the same level will not be added into the res. Right always first
            res.add(root.val);
        }
        helper(root.right, res, level + 1); // right first
        helper(root.left, res, level + 1);
    }

    // // a divide & conquer solution, not effective, O(n^2) time, when highly unbalanced, (1 + 2 + 3 + .. n), also construct & deconstruct list too many times
    // public List<Integer> rightSideView(TreeNode root) {
    //     if(root==null)
    //         return new ArrayList<Integer>();
    //     List<Integer> left = rightSideView(root.left);
    //     List<Integer> right = rightSideView(root.right);
    //     List<Integer> re = new ArrayList<Integer>();
    //     re.add(root.val);
    //     for(int i=0;i<Math.max(left.size(), right.size());i++){
    //         if(i>=right.size())
    //             re.add(left.get(i));
    //         else
    //             re.add(right.get(i));
    //     }
    //     return re;
    // }
}