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
    // // divide & conquer, but this method needs a while loop to find the left end, so the time maybe larger than O(n)
    // public void flatten(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     TreeNode left = root.left;
    //     TreeNode right = root.right;
    //     flatten(left);
    //     flatten(right);
    //     root.right = left;
    //     root.left = null;
    //     TreeNode tmp = root;
    //     while (tmp.right != null) {
    //         tmp = tmp.right;
    //     }
    //     tmp.right = right;
    // }
    
//     // should optimize the while loop cost, O(n)
//     public void flatten(TreeNode root) {
//         helper(root);
//     }
    
//     private TreeNode helper(TreeNode root) {
//         if (root == null) {
//             return null;
//         }
        
//         TreeNode leftEnd = helper(root.left);
//         TreeNode rightEnd = helper(root.right);
        
//         if (leftEnd != null) {
//             leftEnd.right = root.right;
//             root.right = root.left;
//             root.left = null;
//         }
//         if (rightEnd != null) {
//             return rightEnd;
//         }
//         if (leftEnd != null) {
//             return leftEnd;
//         }
//         return root;
//     }
    
    
    // // traversal-preorder-from-top-to-down
    // private TreeNode prev = null;
    // public void flatten(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     if (prev != null) {
    //         prev.right = root;
    //         prev.left = null;
    //     }
    //     prev = root;
    //     TreeNode right = root.right; // must store root.right as right, otherwise flatten(root.left) will change root.right
    //     flatten(root.left);
    //     flatten(right);
    // }
    
    // // traversal-reverse-preorder-from-down-to-up, eaiser logic but more difficult to come up with this down->top method
    // private TreeNode prev = null;
    // public void flatten(TreeNode root) {
    //     if (root == null) {
    //         return;
    //     }
    //     flatten(root.right);
    //     flatten(root.left);
    //     root.right = prev;
    //     root.left = null;
    //     prev = root;
    // }
    
    // // avoid member variable
    // public void flatten(TreeNode root) {
    //     flatten(root,null);
    // }
    // private TreeNode flatten(TreeNode root, TreeNode pre) {
    //     if(root==null) return pre;
    //     pre=flatten(root.right,pre);    
    //     pre=flatten(root.left,pre);
    //     root.right=pre;
    //     root.left=null;
    //     pre=root;
    //     return pre;
    // }
    
    // iterative-preorder
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
            if (!stack.isEmpty()) {
                tmp.right = stack.peek();
            }
            tmp.left = null;
        }
    }
}