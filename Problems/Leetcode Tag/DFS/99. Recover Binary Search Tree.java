public class Solution {
//     Note:
// A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
    
//     // O(n) space, normal inorder traversal
//     private TreeNode first = null;
//     private TreeNode second = null;
//     private TreeNode predecessor = null;
    
//     public void recoverTree(TreeNode root) {
//         helper(root);
//         if (first != null && second != null) {
//             int temp = first.val;
//             first.val = second.val;
//             second.val = temp;
//         }
//     }
    
//     private void helper(TreeNode root) {
//         if (root == null) {
//             return;
//         }
        
//         helper(root.left);
        
//         if (predecessor != null && root.val <= predecessor.val) {
//             if (first != null) { // very tricky here, test case[0,1], [7,11,5]
//                 second = root;
//             } else {
//                 first = predecessor;
//                 second = root;
//             }
//         }
//         predecessor = root;
        
//         helper(root.right);
//     }
    
    // Moris traversal O(1) space, O(n) time
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        TreeNode pre = null;
        TreeNode curt = root;
        while (curt != null) {
            if (curt.left == null) {
                if (prev != null && curt.val <= prev.val) {
                    if (first == null) {
                        first = prev;
                        second = curt;
                    } else {
                        second = curt;
                    }
                }
                prev = curt;
                curt = curt.right;
            } else {
                pre = curt.left;
                while (pre.right != null && pre.right != curt) {
                    pre = pre.right;
                }
                if (pre.right == null) {
                    pre.right = curt;
                    curt = curt.left;
                } else {
                    pre.right = null;
                    if (prev != null && curt.val <= prev.val) {
                        if (first == null) {
                            first = prev;
                            second = curt;
                        } else {
                            second = curt;
                        }
                    }
                    prev = curt;
                    curt = curt.right;
                }
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }   
    }
}