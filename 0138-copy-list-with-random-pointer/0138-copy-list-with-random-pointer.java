/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null; // Return null if the list is empty

        // Step 1: Create a HashMap to map original nodes to their copies
        HashMap<Node, Node> map = new HashMap<>();

        // Step 2: First pass - Create all new nodes and store them in the map
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val)); // Create a new node and map it to the original node
            current = current.next;                 // Move to the next node
        }

        // Step 3: Second pass - Assign next and random pointers using the map
        current = head;
        while (current != null) {
            Node copy = map.get(current);           // Get the copy of the current node
            copy.next = map.get(current.next);      // Set the next pointer of the copy
            copy.random = map.get(current.random);  // Set the random pointer of the copy
            current = current.next;                 // Move to the next node
        }

        // Step 4: Return the head of the new list
        return map.get(head);
    }
}