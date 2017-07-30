/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
//     public void connect(TreeLinkNode root) {
//         // constant space, O(1), cannot use recursion or queue. Therefore, should use the next pointer.
        
//         // TreeLinkNode levelStart = root;
//         // while (levelStart != null) {
//         //     TreeLinkNode curt = levelStart;
//         //     while (curt != null) { 
//         //         if (curt.left != null) {
//         //             curt.left.next = curt.right;
//         //         }
//         //         if (curt.right != null && curt.next != null) {
//         //             curt.right.next = curt.next.left;
//         //         }
//         //         curt = curt.next;
//         //     }
//         //     levelStart = levelStart.left;
//         // }
//         if (root == null) {
//             return;
//         }
//         TreeLinkNode levelStart = root;
//         while (levelStart.left != null) {
//             TreeLinkNode curt = levelStart;
//             while (curt != null) {
//                 curt.left.next = curt.right; // if levelStart.left != null, then curt.left, curt.right != null, perfect tree
//                 if (curt.next != null) {
//                     curt.right.next = curt.next.left;
//                 }
//                 curt = curt.next;
//             }
//             levelStart = levelStart.left;
//         }
//     }
    // divide & conquer, O(logn) space
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        connect(left);
        connect(right);
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
    
//     // their recursion, O(logn) space
//     public void connect(TreeLinkNode root) {
//         if (root == null)
//             return;

//         if (root.left != null) {
//             root.left.next = root.right;
//             if (root.next != null) {
//                 root.right.next = root.next.left;
//             }
//         }

//         connect(root.left);
//         connect(root.right);
//     }
}