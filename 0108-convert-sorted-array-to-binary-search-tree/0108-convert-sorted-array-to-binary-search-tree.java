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


    private TreeNode tree(int[] nums, int l, int r ){

        if(l>r)
            return null;
        
        int mid = (l+r)/2;
        TreeNode newNode = new TreeNode(nums[mid]);

        newNode.left = tree(nums , l , mid-1);
        newNode.right = tree(nums , mid+1, r);

        return newNode;

    }
    public TreeNode sortedArrayToBST(int[] nums) {

        return tree(nums, 0 , nums.length-1);
    }
}