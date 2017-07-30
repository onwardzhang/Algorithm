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
    // Bonus points if you could solve it both recursively and iteratively.
/*    // recursively
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return helper(p.left, q.right) && helper(p.right, q.left);
    }*/
    
    // iteratively
 /*   Stack / queue
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            TreeNode q = stack.pop();
            if (p.val != q.val) {
                return false;
            }
            if (p.left != null && q.right != null) {
                stack.push(p.left);
                stack.push(q.right);
            } else {
                if (p.left != q.right) { // null == null -> true
                    return false;
                }
            }
            if (p.right != null && q.left != null) {
                stack.push(p.right);
                stack.push(q.left);
            } else {
                if (p.right != q.left) { // null == null -> true
                    return false;
                }
            }
        }
        return true;
    }*/
    
    // shorter version iterative, stack and queue both work, no difference
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode p = queue.poll();
            TreeNode q = queue.poll();
            if (p == null && q == null) {
                continue;
            } else if (p == null || q == null) {
                return false;
            } else {
                if (p.val != q.val) {
                    return false;
                }
                queue.offer(p.left);
                queue.offer(q.right);
                queue.offer(p.right);
                queue.offer(q.left);
            }
        }
        return true;
    }
}