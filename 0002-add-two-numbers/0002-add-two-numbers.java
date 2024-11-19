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

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = l1; // Use l1 as the result list
        ListNode prev = null; // Track the previous node
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;

            if (l1 != null) {
                l1.val = sum % 10; // Update the value of l1 node
                prev = l1; // Update the previous node
                l1 = l1.next; // Move to the next node
            } else {
                // Extend l1 if it's shorter than l2 or there's a carry
                prev.next = new ListNode(sum % 10);
                prev = prev.next;
            }

            if (l2 != null) {
                l2 = l2.next; // Move to the next node
            }
        }

        return head; // Return the modified l1 as the result
    }
}
