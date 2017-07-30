// Note:
// You may assume that duplicates do not exist in the tree.
    
    // without HashMap, worst case: O(N^2) O(N) space, average: O(NlogN) time, O(logN) space
    // with HashMap, O(N) time, O(N) space
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (inorder.length != preorder.length) {
            return null;
        }
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    
    private TreeNode helper(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (pStart == pEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        // int i = iStart;
        // for (; i < iEnd; i++) {
        //     if (inorder[i] == preorder[pStart]) {
        //         break;
        //     }
        // }
        // better loop
        int i = iStart;
        while (inorder[i] != preorder[pStart]) {
            i++;
        }
        // can also use a hashmap<value, index> as a parameter, so that taks O(1) to seach for preorder[pStart]
        root.left = helper(preorder, pStart + 1, pStart + i - iStart + 1, inorder, iStart, i);
        root.right = helper(preorder, pStart + i - iStart + 1, pEnd, inorder, i + 1, iEnd);
        return root;
    }
}

// TODO: iterative method