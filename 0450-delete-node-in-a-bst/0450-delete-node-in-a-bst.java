class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null; // Base case: the tree is empty
        }

        // Traverse the tree to find the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key); // Key is in the left subtree
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // Key is in the right subtree
        } else {
            // Node to delete is found
            if (root.left == null) {
                return root.right; // Node has no left child, replace with right child
            } else if (root.right == null) {
                return root.left; // Node has no right child, replace with left child
            }

            // Node has two children, find the inorder successor
            TreeNode successor = getMin(root.right);
            root.val = successor.val; // Replace value of the node with the successor's value
            root.right = deleteNode(root.right, successor.val); // Delete the successor node
        }

        return root; // Return the root of the modified tree
    }

    // Helper function to find the smallest value in a subtree (inorder successor)
    private TreeNode getMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
