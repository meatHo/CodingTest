import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int res = 0;

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int edge = 0;

        for (int[] cost : costs) {
            if (edge == n - 1)
                break;

            int node1 = cost[0];
            int node2 = cost[1];
            int root1 = findRoot(node1, parent);
            int root2 = findRoot(node2, parent);
            if (root1 == root2) {
                continue;
            }
            // 연결
            res += cost[2];
            edge++;
            parent[root1] = root2;

        }
        return res;

    }

    public int findRoot(int node, int[] parent) {
        if (node == parent[node])
            return node;
        return parent[node] = findRoot(parent[node], parent);
    }
}