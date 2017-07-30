/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // constant space, O(1), cannot use recursion or queue. Therefore, should use the next pointer.
        // difference from previos problem: not sure where is next node, where is the level start node
        // linkedlist -> dummy head
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode dummy = new TreeLinkNode(0); // inside the loop, will be destroyed at the end of each loop, so this is also O(1)
            TreeLinkNode curt = dummy;
            while (levelStart != null) {
                if (levelStart.left != null) {
                    curt.next = levelStart.left;
                    curt = curt.next;
                }
                if (levelStart.right != null) {
                    curt.next = levelStart.right;
                    curt = curt.next;
                }
                levelStart = levelStart.next;
            }
            levelStart = dummy.next;
        }
    }
}