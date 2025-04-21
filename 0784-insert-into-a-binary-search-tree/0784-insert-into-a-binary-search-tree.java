/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int value) {
        TreeNode newNode = new TreeNode(value);
        if (root == null) {
            root = newNode;
            return root;
        }
        TreeNode temp = root;
        while (true) {
            if (newNode.val < temp.val) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return root;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return root;
                }
                temp = temp.right;
            }
        }
    }
}