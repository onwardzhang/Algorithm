public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return helper(head, null);
    }
    
    private TreeNode helper(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode mid = findMid(head, tail);
        TreeNode root = new TreeNode(mid.val);
        root.left = helper(head, mid);
        root.right = helper(mid.next, tail);
        return root;
    }
    
    private ListNode findMid(ListNode head, ListNode tail) {
        // if (head == null) {
        //     return null;
        // }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}