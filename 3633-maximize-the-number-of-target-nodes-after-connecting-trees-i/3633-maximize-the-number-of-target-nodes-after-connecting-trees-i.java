import java.util.*;

public class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        List<Integer>[] graph1 = buildGraph(edges1);
        List<Integer>[] graph2 = buildGraph(edges2);
        int n = graph1.length;
        int m = graph2.length;
        int[] answer = new int[n];

        int maxReachableInGraph2 = 0;
        if (k > 0) {
            for (int i = 0; i < m; i++) {
                maxReachableInGraph2 = Math.max(maxReachableInGraph2, dfs(graph2, i, -1, k - 1));
            }
        }

        for (int i = 0; i < n; i++) {
            answer[i] = dfs(graph1, i, -1, k) + maxReachableInGraph2;
        }

        return answer;
    }

    private List<Integer>[] buildGraph(int[][] edges) {
        int size = edges.length + 1;
        List<Integer>[] graph = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }

    private int dfs(List<Integer>[] graph, int node, int parent, int depth) {
        if (depth < 0) return 0;
        int count = 1;
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                count += dfs(graph, neighbor, node, depth - 1);
            }
        }
        return count;
    }
}
