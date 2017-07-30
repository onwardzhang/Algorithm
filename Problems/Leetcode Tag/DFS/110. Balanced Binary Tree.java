public class Solution {
    // divide & conquer
    // O(N) time: every node is visited once!, O(N) space at worst
    // private class ResultType {
    //     public boolean isBalanced;
    //     public int depth;
    //     public ResultType(boolean isBalanced, int depth) {
    //         this.isBalanced = isBalanced;
    //         this.depth = depth;
    //     }
    // }
    
    // public boolean isBalanced(TreeNode root) {
    //     return helper(root).isBalanced;
    // }
    // private ResultType helper(TreeNode root) {
    //     if (root == null) {
    //         return new ResultType(true, 0);
    //     }
    //     ResultType left = helper(root.left);
    //     if (!left.isBalanced) {
    //         return new ResultType(false, -1);
    //     }
    //     ResultType right = helper(root.right);
    //     if (!right.isBalanced) {
    //         return new ResultType(false, -1);
    //     }
    //     if (Math.abs(left.depth - right.depth) > 1) {
    //         return new ResultType(false, -1);
    //     } 
    //     return new ResultType(true, Math.max(left.depth, right.depth) + 1);
    // }
    
    // not sure using ResultType is good or not, since already use -1 for false ResultType return, could just use -1
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        if (left == -1) {
            return -1;
        }
        int right = helper(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}