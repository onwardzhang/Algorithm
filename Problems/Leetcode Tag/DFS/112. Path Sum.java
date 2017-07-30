public class Solution {
    // // divide & conquer, recursion dfs, O(n) time, O(n) space
    // public boolean hasPathSum(TreeNode root, int sum) {
    //     if (root == null) {
    //         return false;
    //     }
    //     if (root.left == null && root.right == null) {
    //         return root.val == sum;
    //     }
    //     return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    // }
    
    // iterative, post order
    public boolean hasPathSum(TreeNode root, int sum) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        TreeNode pre = null;
        int pathSum = 0;
        while (!stack.isEmpty() || curt != null) {
            while (curt != null) {
                pathSum += curt.val;
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.peek();
            if (curt.left == null && curt.right == null && pathSum == sum) {
                return true;
            }
            if (curt.right != null && pre != curt.right) { // when to visit curt.right? when curt.right != null && the node that previously visited is not curt.right(not traverse up)
                curt = curt.right;
            } else { // otherwise pop an element
                pre = curt;
                stack.pop();
                pathSum -= curt.val;
                curt = null;
            }
        }
        return false;
    }
    
    // // iterative dfs
    // public boolean hasPathSum(TreeNode root, int sum) {
    //     if (root == null) {
    //         return false;
    //     }
    //     Stack<TreeNode> stack = new Stack<>();
    //     Set<TreeNode> visited = new HashSet<>();
    //     stack.push(root);
    //     visited.add(root);
    //     int pathSum = root.val;
    //     while (!stack.isEmpty()) {
    //         TreeNode tmp = stack.peek();
    //         if (tmp.left == null && tmp.right == null) { // leaf node
    //             if (pathSum == sum) {
    //                 return true;
    //             }
    //             pathSum -= tmp.val;
    //             stack.pop();
    //         } else if (tmp.left != null && !visited.contains(tmp.left)) { // non-leaf node, left son has not been visited
    //             stack.push(tmp.left);
    //             visited.add(tmp.left);
    //             pathSum += tmp.left.val;
    //         } else if (tmp.right != null && !visited.contains(tmp.right)) { // non-leaf node, right son has not been visited
    //             stack.push(tmp.right);
    //             visited.add(tmp.right);
    //             pathSum += tmp.right.val;
    //         } else { // non-leaf node, both sons have been visited
    //             pathSum -= tmp.val;
    //             stack.pop();
    //         }
    //     }
    //     return false;
    // }
}