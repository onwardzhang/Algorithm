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
    // public List<String> binaryTreePaths(TreeNode root) {
    //     // iterative
    //     List<String> paths = new ArrayList<>();
    //     if (root == null) {
    //         return paths;
    //     }
    //     List<Integer> path = new LinkedList<>();
    //     Set<TreeNode> visited = new HashSet<>();
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);
    //     visited.add(root);
    //     path.add(root.val);
    //     while (!stack.isEmpty()) {
    //         TreeNode tmp = stack.peek();
    //         if (tmp.left == null && tmp.right == null) { // leaf node
    //             paths.add(buildString(path));
    //             stack.pop();
    //             path.remove(path.size() - 1);
    //         } else if (tmp.left != null && !visited.contains(tmp.left)) { // non-leaf node, left son has not been visited
    //             visited.add(tmp.left);
    //             path.add(tmp.left.val);
    //             stack.push(tmp.left);
    //         } else if (tmp.right != null && !visited.contains(tmp.right)) { // non-leaf node, right son has not been visited
    //             visited.add(tmp.right);
    //             path.add( tmp.right.val);
    //             stack.push(tmp.right);
    //         } else { // // non-leaf node, both left & right son have been visited, traverse up, can be removed
    //             stack.pop();
    //             path.remove(path.size() - 1);
    //         }
    //     }
    //     return paths;
    // }
    
    // public List<String> binaryTreePaths(TreeNode root) {
    //     // iterative 2
    //     List<String> paths = new ArrayList<>();
    //     if (root == null) {
    //         return paths;
    //     }
    //     List<Integer> path = new LinkedList<>();
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode curt = root;
    //     TreeNode prev = null;
    //     while (!stack.isEmpty() || curt != null) {
    //         while (curt != null) {
    //             stack.push(curt);
    //             path.add(curt.val);
    //             curt = curt.left;
    //         }
    //         curt = stack.peek();
    //         if (curt.left == null && curt.right == null) { // leaf node
    //             paths.add(buildString(path));
    //             path.remove(path.size() - 1);
    //             prev = curt;
    //             curt = null;
    //             stack.pop();
    //         } else if (curt.right != null && prev != curt.right) {
    //             curt = curt.right;
    //         } else {
    //             path.remove(path.size() - 1);
    //             prev = curt;
    //             curt = null;
    //             stack.pop();
    //         }
    //     }
    //     return paths;
    // }
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        List<Integer> path = new LinkedList<>();
        helper(root, path, paths);
        return paths;
    }
    
    private void helper(TreeNode root, List<Integer> path, List<String> paths) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            paths.add(buildString(path));
            path.remove(path.size() - 1);
            return;
        }
        helper(root.left, path, paths);
        helper(root.right, path, paths);
        path.remove(path.size() - 1);
    }
    
    private String buildString(List<Integer> path) {
        StringBuilder sb = new StringBuilder();
        for (int n : path) {
            sb.append(n + "->");
        }
        return sb.substring(0, sb.length() - 2);
    }
}