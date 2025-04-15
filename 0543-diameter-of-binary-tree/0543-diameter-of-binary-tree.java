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
    private int d=0;

    private int solve (TreeNode root)
    {
        if (root == null ) return 0;
        int maxl = solve(root.left);
        int maxr =  solve(root.right);

        d = Math.max(d, maxl+maxr);

        return Math.max(maxl,maxr)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
       solve (root);
       return d;
    }
}