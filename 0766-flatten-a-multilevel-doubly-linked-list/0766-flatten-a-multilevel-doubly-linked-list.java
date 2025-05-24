/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) return null;
		
        Node left = flatten(head.child);
        Node right = flatten(head.next);
        
        Node temp = head;
        head.next = left;
        
        if(left != null) {
            left.prev = head;
            head.child = null;
        }
        
        while(temp.next != null) {
            temp = temp.next;
        }
        
        temp.next = right;
        
        if(right != null) {
            right.prev = temp;
        }
        
        return head;
    }
}