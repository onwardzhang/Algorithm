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
//     public int rob(TreeNode root) {
//         // divide & conquer, too slow, because overlapping compute
//         if (root == null) {
//             return 0;
//         }
//         int takeRoot = root.val;
//         int notTakeRoot = 0;
//         if (root.left != null) {
//             takeRoot += rob(root.left.left) + rob(root.left.right);
//             notTakeRoot += rob(root.left);
//         }
//         if (root.right != null) {
//             takeRoot += rob(root.right.left) + rob(root.right.right);
//             notTakeRoot += rob(root.right);
//         }
        
//         return Math.max(takeRoot, notTakeRoot);
//     }
    
//    // memoriable search, O(N) time, O(N) space
//     public int rob(TreeNode root) {
//         
//         if (root == null) {
//             return 0;
//         }
//         Map<TreeNode, Integer> map = new HashMap<>();
//         return helper(root, map);
//     }
    
//     private int helper(TreeNode root, Map<TreeNode, Integer> map) {
//         if (root == null) {
//             return 0;
//         }
//         if (map.containsKey(root)) {
//             return map.get(root);
//         }
//         int takeRoot = root.val;
//         int notTakeRoot = 0;
//         if (root.left != null) {
//             takeRoot += helper(root.left.left, map) + helper(root.left.right, map);
//             notTakeRoot += helper(root.left, map);
//         }
//         if (root.right != null) {
//             takeRoot += helper(root.right.left, map) + helper(root.right.right, map);
//             notTakeRoot += helper(root.right, map);
//         }
//         int result = Math.max(takeRoot, notTakeRoot);
//         map.put(root, result);
//         return result;
//     }
    
    public int rob(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] helper(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        res[0] = root.val + left[1] + right[1]; // take root
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // not take root
        return res;
    }
    
    
}