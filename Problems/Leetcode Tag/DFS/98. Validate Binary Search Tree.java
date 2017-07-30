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
    // method 1 inorder traversal - recursion or iterative
/*    // recursion
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> vals = new ArrayList<>();
        inorder(root, vals);
        for (int i = 0; i < vals.size() - 1; i++) {
            if (vals.get(i) >= vals.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    
    private void inorder(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        inorder(root.left, vals);
        vals.add(root.val);
        inorder(root.right, vals);
    }*/
    
    // Under the hood recursive function involves a stack so that the program can back trace. The space usage is O(tree height), which could be O(lgn) in the best case and O(n) for the worst.
    // Auxiliary Space : If we don’t consider size of stack for function calls then O(1) otherwise O(n).
    // Time O(n)
    // // iterative
    /*public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        //List<Integer> vals = new ArrayList<>();
        TreeNode pre = null;
        TreeNode curt = root;
        while (curt != null || !stack.isEmpty()) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            //vals.add(curt.val);
            if (pre != null && pre.val >= curt.val) {
                return false;
            }
            pre = curt;
            curt = curt.right;
        }
        // for (int i = 0; i < vals.size() - 1; i++) {
        //     if (vals.get(i) >= vals.get(i + 1)) {
        //         return false;
        //     }
        // }
        return true;
    }
    */
    
     // method 2 divide & conquer
/*    // clear version
    // Basically what I am doing is recursively iterating over the tree while defining interval <minVal, maxVal> for each node which value must fit in.
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }*/
    
    // use Integer(Object) instead of long primitive type
    public boolean isValidBST(TreeNode root) {
        return help(root, null, null);
    }
    private boolean help(TreeNode p, Integer low, Integer high) {
        if (p == null) return true;
        return (low == null || p.val > low)
            && (high == null || p.val < high)
            && help(p.left, low, p.val)
            && help(p.right, p.val, high);
    }

    // standard version, use ResultType class
    /*
    private class ResultType {
        
        public int max;
        public int min;
        public boolean isBST;
        
        public ResultType(int max, int min, boolean isBST) {
            this.max = max;
            this.min = min;
            this.isBST = isBST;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, Integer.MAX_VALUE, true);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        if (!left.isBST || !right.isBST) {
            return new ResultType(0, 0, false);
        }
        if (root.left != null && root.val <= left.max || root.right != null && root.val >= right.min) {
            return new ResultType(0, 0, false);
        }
        return new ResultType(Math.max(root.val, right.max), Math.min(root.val, left.min), true);*/
//     }
        
}