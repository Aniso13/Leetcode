class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head; 

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode previousNode = dummyNode;

        for (int i = 1; i < left; i++) {
            previousNode = previousNode.next;
        }

        ListNode currentNode = previousNode.next;

        for (int i = 0; i < right - left; i++) {
            ListNode nodeToMove = currentNode.next;    
            currentNode.next = nodeToMove.next;     
            nodeToMove.next = previousNode.next;       
            previousNode.next = nodeToMove;   
        }

        return dummyNode.next; 
    }
}
