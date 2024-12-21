import java.util.*;

public class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // بناء الشجرة كقائمة ارتباطية
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // عداد الأقسام
        int[] count = new int[1];
        
        // DFS
        dfs(0, -1, graph, values, k, count);
        
        return count[0];
    }

    private int dfs(int node, int parent, List<List<Integer>> graph, int[] values, int k, int[] count) {
        int sum = values[node]; // مجموع القيم في هذا المسار
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                sum += dfs(neighbor, node, graph, values, k, count);
            }
        }
        
        // تحقق من إمكانية القسمة
        if (sum % k == 0) {
            count[0]++;
            return 0; // إعادة المجموع كـ 0 لأن هذا القسم تم احتسابه
        }
        return sum % k; // أعد الباقي للأب
    }
}
