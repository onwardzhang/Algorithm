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
    // dfs - top to down
    // // iterative - pop stack order is postorder, push stack order is like dfs
    // public int sumNumbers(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int totalSum = 0;
    //     int pathSum = 0;
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode curt = root;
    //     TreeNode prev = null;
    //     while (!stack.isEmpty() || curt != null) {
    //         while (curt != null) {
    //             pathSum = pathSum * 10 + curt.val;
    //             stack.push(curt);
    //             curt = curt.left;
    //         }
    //         curt = stack.peek();
    //         if (curt.left == null && curt.right == null) {
    //             totalSum += pathSum;
    //             stack.pop();
    //             pathSum /= 10;
    //             prev = curt;
    //             curt = null;
    //         } else if (curt.right != null && curt.right != prev) {
    //             curt = curt.right;
    //         } else {
    //             stack.pop();
    //             pathSum /= 10;
    //             prev = curt;
    //             curt = null;
    //         }
    //     }
    //     return totalSum;
    // }
    
    // // iterative - traditional
    // public int sumNumbers(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     int pathSum = root.val;
    //     int totalSum = 0;
    //     Stack<TreeNode> stack = new Stack<>();
    //     Set<TreeNode> visited = new HashSet<>();
    //     stack.push(root);
    //     visited.add(root);
    //     while (!stack.isEmpty()) {
    //         TreeNode tmp = stack.peek();
    //         if (tmp.left == null && tmp.right == null) {
    //             totalSum += pathSum;
    //             stack.pop();
    //             pathSum /= 10;
    //         } else if (tmp.left != null && !visited.contains(tmp.left)) {
    //             stack.push(tmp.left);
    //             visited.add(tmp.left);
    //             pathSum = pathSum * 10 + tmp.left.val;
    //         } else if (tmp.right != null && !visited.contains(tmp.right)) {
    //             stack.push(tmp.right);
    //             visited.add(tmp.right);
    //             pathSum = pathSum * 10 + tmp.right.val;
    //         } else {
    //             stack.pop();
    //             pathSum /= 10;
    //         }
    //     }
    //     return totalSum;
    // }
    
//     // recursion 
//     public int sumNumbers(TreeNode root) {
//         int[] sum = new int[2]; // sum[0] totalSum, sum[1] pathSum
//         helper(root, sum);
//         return sum[0];
//     }
    
//     private void helper(TreeNode root, int[] sum) {
//         if (root == null) {
//             return;
//         }
//         sum[1] = sum[1] * 10 + root.val;
//         if (root.left == null && root.right == null) {
//             sum[0] += sum[1];
//         }
//         helper(root.left, sum);
//         helper(root.right, sum);
//         sum[1] /= 10;
//     }
    
    // recursion - actually this is like a preorder traversal.
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        }
        return helper(root.left, sum) + helper(root.right, sum);
    }
    
}