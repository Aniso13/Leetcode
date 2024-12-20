public class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<TreeNode> nodes = new ArrayList<>();

            // جمع العقد في المستوى الحالي
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                nodes.add(node);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // عكس القيم في المستويات الفردية
            if (level % 2 == 1) {
                int left = 0, right = nodes.size() - 1;
                while (left < right) {
                    int temp = nodes.get(left).val;
                    nodes.get(left).val = nodes.get(right).val;
                    nodes.get(right).val = temp;
                    left++;
                    right--;
                }
            }

            level++;
        }

        return root;
    }
}
