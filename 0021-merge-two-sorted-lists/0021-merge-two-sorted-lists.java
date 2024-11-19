class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Base case: If one of the lists is empty, return the other list
        if (l1 == null) return l2; // l1 is empty, return l2
        if (l2 == null) return l1; // l2 is empty, return l1
        
        // Recursive case: Compare the values of the two lists
        if (l1.val < l2.val) {
            // If l1's value is smaller, merge the rest of l1 and l2
            l1.next = mergeTwoLists(l1.next, l2);
            return l1; // Return l1 as the head of the merged list
        } else {
            // If l2's value is smaller or equal, merge l1 and the rest of l2
            l2.next = mergeTwoLists(l1, l2.next);
            return l2; // Return l2 as the head of the merged list
        }
    }
}
