class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;
        ListNode current = head;

        while (true) {
            ListNode groupStart = current;
            int count = 0;
            while (current != null && count < k) {
                current = current.next;
                count++;
            }

            if (count < k) {
                break;
            }

            ListNode prev = null, next = null;
            ListNode node = groupStart;

            for (int i = 0; i < k; i++) {
                next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            prevGroupEnd.next = prev; 
            groupStart.next = current;  
            prevGroupEnd = groupStart; 
        }

        return dummy.next;
    }
}
