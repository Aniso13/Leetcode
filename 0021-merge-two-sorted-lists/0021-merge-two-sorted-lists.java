class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to serve as the start of the merged list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Traverse both lists until one of them is exhausted
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1; // Append the smaller node to the merged list
                list1 = list1.next; // Move to the next node in list1
            } else {
                current.next = list2; // Append the smaller node to the merged list
                list2 = list2.next; // Move to the next node in list2
            }
            current = current.next; // Move to the next node in the merged list
        }

        // Attach the remaining nodes (if any) from the non-empty list
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return dummy.next; // Return the merged list, skipping the dummy node
    }
}
