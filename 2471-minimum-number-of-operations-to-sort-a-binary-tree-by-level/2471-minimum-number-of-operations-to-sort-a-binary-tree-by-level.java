import java.util.*;

public class Solution {
    public int minimumOperations(TreeNode root) {
        // BFS to traverse the tree level by level
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int totalSwaps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelValues = new ArrayList<>();

            // Collect all node values at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelValues.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Add the minimum swaps required to sort this level
            totalSwaps += minSwaps(levelValues);
        }

        return totalSwaps;
    }

    private int minSwaps(List<Integer> values) {
        int n = values.size();
        Integer[] indexedArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexedArr[i] = i; // Store indices
        }

        // Sort indices based on values
        Arrays.sort(indexedArr, (a, b) -> Integer.compare(values.get(a), values.get(b)));

        // Find cycles in the mapping
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || indexedArr[i] == i) continue;

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = indexedArr[j];
                cycleSize++;
            }

            if (cycleSize > 1) swaps += (cycleSize - 1);
        }

        return swaps;
    }
}
