class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else { // val > root.val
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }
}
