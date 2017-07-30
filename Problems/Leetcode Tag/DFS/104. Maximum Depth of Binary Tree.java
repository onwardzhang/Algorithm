public class Solution {
    // time O(n), space O(n)
    
    // // divide & conquer, recursion, also is a DFS method
    // public int maxDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    // }
    
    // // iterative, bfs, level order traversal
    // public int maxDepth(TreeNode root) {
    //     if (root == null) {
    //         return 0;
    //     }
    //     Queue<TreeNode> queue = new LinkedList<>();
    //     int level = 0;
    //     queue.offer(root);
    //     while (!queue.isEmpty()) {
    //         level++;
    //         int size = queue.size();
    //         while (size-- > 0) {
    //             TreeNode tmp = queue.poll();
    //             if (tmp.right != null) {
    //                 queue.offer(tmp.right);
    //             }
    //             if (tmp.left != null) {
    //                 queue.offer(tmp.left);
    //             }
    //         }
    //     }
    //     return level;
    // }
    
    // iterative, dfs, using two stacks, one for store TreeNodes, one for store their levels 
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int max = 0;
        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> levels = new Stack<>();
        
        nodes.push(root);
        levels.push(1);
        
        while (!nodes.isEmpty()) {
            TreeNode tmp = nodes.pop();
            int val = levels.pop();
            max = Math.max(max, val);
            if (tmp.right != null) {
                nodes.push(tmp.right);
                levels.push(val + 1);
            }
            if (tmp.left != null) {
                nodes.push(tmp.left);
                levels.push(val + 1);
            }
        }
        return max;
    }
    
}