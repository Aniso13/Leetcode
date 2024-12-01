class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Edge case: If the list has only one node, return null
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null; // To keep track of the node before 'slow'
        
        // Traverse the list to find the middle node
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        
        // Delete the middle node by skipping it
        if (prev != null) {
            prev.next = slow.next;
        }
        
        return head;
    }
}
