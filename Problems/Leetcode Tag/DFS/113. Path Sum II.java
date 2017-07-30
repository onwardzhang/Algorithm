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
    // dfs
//     // recursion
//     public List<List<Integer>> pathSum(TreeNode root, int sum) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> path = new ArrayList<>();
//         helper(root, result, path, sum);
//         return result;
//     }
    
//     private void helper(TreeNode root, List<List<Integer>> result, List<Integer> path, int sum) {
//         if (root == null) {
//             return;
//         }
//         path.add(root.val);
//         sum -= root.val;
//         if (root.left == null && root.right == null && sum == 0) {
//             result.add(new ArrayList<>(path));
//         }
//         helper(root.left, result, path, sum);
//         helper(root.right, result, path, sum);
//         path.remove(path.size() - 1);
//     }
    
    // iterative
    // // dfs
    // public List<List<Integer>> pathSum(TreeNode root, int sum) {
    //     List<List<Integer>> res = new ArrayList<>();
    //     List<Integer> path = new ArrayList<>();
    //     if (root == null) {
    //         return res;
    //     }
    //     Stack<TreeNode> stack = new Stack<>();
    //     Set<TreeNode> visited = new HashSet<>();
    //     int pathSum = root.val;
    //     stack.push(root);
    //     visited.add(root);
    //     path.add(root.val);
    //     while (!stack.isEmpty()) {
    //         TreeNode tmp = stack.peek();
    //         if (tmp.left == null && tmp.right == null) {
    //             if (pathSum == sum) {
    //                 res.add(new ArrayList<>(path));
    //             }
    //             pathSum -= tmp.val;
    //             path.remove(path.size() - 1);
    //             stack.pop();
    //         } else if (tmp.left != null && !visited.contains(tmp.left)) {
    //             path.add(tmp.left.val);
    //             pathSum += tmp.left.val;
    //             stack.push(tmp.left);
    //             visited.add(tmp.left);
    //         } else if (tmp.right != null && !visited.contains(tmp.right)) {
    //             path.add(tmp.right.val);
    //             pathSum += tmp.right.val;
    //             stack.push(tmp.right);
    //             visited.add(tmp.right);
    //         } else {
    //             pathSum -= tmp.val;
    //             path.remove(path.size() - 1);
    //             stack.pop();
    //         }
    //     }
    //     return res;
    // }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        TreeNode prev = null;
        int pathSum = 0;
        while (!stack.isEmpty() || curt != null) {
            while (curt != null) {
                stack.push(curt);
                pathSum += curt.val;
                path.add(curt.val);
                curt = curt.left;
            }
            curt = stack.peek();
            if (curt.left == null && curt.right == null) {
                if (pathSum == sum) {
                    res.add(new ArrayList<>(path));
                }
                pathSum -= curt.val;
                path.remove(path.size() - 1);
                stack.pop();
                prev = curt;
                curt = null;
            } else if (curt.right != null && prev != curt.right) {
                curt = curt.right;
            } else {
                pathSum -= curt.val;
                path.remove(path.size() - 1);
                stack.pop();
                prev = curt;
                curt = null; 
            }
        }
        return res;
    }
}