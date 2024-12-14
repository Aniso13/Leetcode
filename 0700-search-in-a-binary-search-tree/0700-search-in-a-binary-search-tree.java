class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode current = root;
        while (current != null) {
            if (current.val == val) {
                return current;   
            }
            if (val < current.val) {
                current = current.left; 
            } else {
                current = current.right; 
            }
        }
        return null;  
    }
}
