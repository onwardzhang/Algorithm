public class Solution {
    // this method is straightforward, but will cause TLE, because recusion嵌套, O(2n)， better to have one recusion fuction to get all the data we need


//     public int maxPathSum(TreeNode root) { //any - any
//         if (root == null) {
//           return Integer.MIN_VALUE;
//         }
//         int left = maxPathSum(root.left);
//         int right = maxPathSum(root.right);
        // int cross = root.val + Math.max(0, maxPathSumr2a(root.left)) + Math.max(0, maxPathSumr2a(root.right));
        // // int cross = root.val;
        // // if (left > 0) {
        // //     cross += Math.max(0, maxPathSumr2a(root.left));
        // // }
        // // if (right > 0) {
        // //     cross += Math.max(0, maxPathSumr2a(root.right));
        // // }
//         return Math.max(cross, Math.max(left, right));
//     }
    
//     private int maxPathSumr2a(TreeNode root) { //root - any
//         if (root == null) {
//           return Integer.MIN_VALUE;
//         }
//         return root.val + Math.max(0, Math.max(maxPathSumr2a(root.left), maxPathSumr2a(root.right)));
//     }

    
        // standard, O(n)
//     private class ResultType {
//         public int r2aMax; // root to any max path sum
//         public int a2aMax; // any to any max path sum
//         public ResultType(int r2aMax, int a2aMax) {
//             this.r2aMax = r2aMax;
//             this.a2aMax = a2aMax;
//         }
//     }
    
//     private ResultType helper(TreeNode root) {
//         if (root == null) {
//             return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
//         }
//         ResultType left = helper(root.left);
//         ResultType right = helper(root.right);
//         int r2aMax = root.val + Math.max(Math.max(left.r2aMax, right.r2aMax), 0);
//         int cross = root.val + Math.max(0, left.r2aMax) + Math.max(0, right.r2aMax);
//         int a2aMax = Math.max(cross, Math.max(left.a2aMax, right.a2aMax));
//         return new ResultType(r2aMax, a2aMax);
//     }
    
//     public int maxPathSum(TreeNode root) {
//         return helper(root).a2aMax;
//     }
    
    // use a member variable, O(n)
    private int a2aMax;
    
    public int maxPathSum(TreeNode root) {
        a2aMax = Integer.MIN_VALUE;
        helper(root);
        return a2aMax;
    }
    
    private int helper(TreeNode root) { // return max r2a path sum (can have 0 node) and update the a2aMax
        if (root == null) {
            return 0;
        }
        
        // 3 Math.max
        int left = helper(root.left);
        int right = helper(root.right);
        a2aMax = Math.max(a2aMax, root.val + left + right);
        return Math.max(0, root.val + Math.max(left, right));
    }
    

}