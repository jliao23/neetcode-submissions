class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = head;
        ListNode left = head;
        ListNode right = head;

        while (n > 0) {
            right = right.next;
            n--;
        }

        // The node to remove is the head
        if (right == null) {
            return head.next;
        }

        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return res;
    }
}