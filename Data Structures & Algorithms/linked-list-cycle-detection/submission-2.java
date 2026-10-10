/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> visited = new HashSet<>();
        visited.add(head);
        while (head.next != null) {
            head = head.next;
            if (visited.contains(head)) {
                return true;
            }
            visited.add(head);
        }

        return false;
    }
}
