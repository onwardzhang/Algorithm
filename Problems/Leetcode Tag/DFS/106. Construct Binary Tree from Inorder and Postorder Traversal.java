public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length, map);
    }
    private TreeNode helper(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd, Map<Integer, Integer> map) {
        if (iStart == iEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[pEnd - 1]);
        int rootIndex = map.get(root.val);
        int leftLen =  rootIndex - iStart;
        root.left = helper(inorder, iStart, rootIndex, postorder, pStart, pStart + leftLen, map);
        root.right = helper(inorder, rootIndex + 1, iEnd, postorder, pStart + leftLen, pEnd - 1, map);
        return root;
    }
}