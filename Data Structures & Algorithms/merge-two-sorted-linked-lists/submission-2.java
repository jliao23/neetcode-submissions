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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }

        List<Integer> temp = new ArrayList<>();
        while (list1 != null) {
            temp.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            temp.add(list2.val);
            list2 = list2.next;
        }

        Collections.sort(temp);

        ListNode head = new ListNode();
        head.val = temp.get(0);
        ListNode res = head;
        for (int i = 1; i < temp.size(); i++) {
            ListNode curr = new ListNode();
            curr.val = temp.get(i);
            head.next = curr;
            head = head.next;
        }

        return res;
    }
}