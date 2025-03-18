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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head; 
        }

        ListNode sortedListHead = new ListNode(0); 
        ListNode unsortedListHead = head;

        while (unsortedListHead != null) {
            ListNode current = unsortedListHead;
            unsortedListHead = unsortedListHead.next;
            ListNode searchPointer = sortedListHead;
            while (searchPointer.next != null && searchPointer.next.val < current.val) {
                searchPointer = searchPointer.next;
            }
            current.next = searchPointer.next;
            searchPointer.next = current;
        }

        return sortedListHead.next; 
    }
}
