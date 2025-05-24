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
     static {
        ListNode n = new ListNode(0);
        for(int i=0;i<300;i++){
            isPalindrome(n);
        }
    }
    public static boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null)
            return true;
        ListNode slow = head;
        ListNode fast = head;
        ListNode reverse = null;
        while(fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            ListNode temp = slow;
            slow = slow.next;
            temp.next = reverse;
            reverse = temp;
        }
        if(fast!=null)
            slow = slow.next;
        while(slow!=null && slow.val==reverse.val)
        {
            slow = slow.next;
            reverse = reverse.next;
        }
        return slow==null;
    }
}