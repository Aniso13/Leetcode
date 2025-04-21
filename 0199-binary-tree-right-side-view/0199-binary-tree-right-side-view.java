class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;

        if (level == result.size()) {
            result.add(node.val);
        }

        dfs(node.right, level + 1, result);
        dfs(node.left, level + 1, result);
    }
}
