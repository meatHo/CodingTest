import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int res = 0;
        int edge = 0;

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int[] cost : costs) {
            if (edge == n - 1) {
                break;
            }
            int root1 = find(cost[0], parent);
            int root2 = find(cost[1], parent);
            if (root1 != root2) {
                res += cost[2];
                edge++;
                parent[root1] = root2;
            }

        }
        return res;
    }

    private int find(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node], parent);
    }
}