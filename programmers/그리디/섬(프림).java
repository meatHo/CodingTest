import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int res = 0;
        int edge = 0;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int cost[] : costs) {
            graph.get(cost[0]).add(new int[] { cost[1], cost[2] });
            graph.get(cost[1]).add(new int[] { cost[0], cost[2] });
        }

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { 0, 0 });
        while (!pq.isEmpty() && edge < n) {// <3
            int[] temp = pq.poll();
            int node = temp[0], cost = temp[1];
            if (visited[node])
                continue;

            visited[node] = true;
            res += cost;
            edge++;

            for (int[] next : graph.get(node)) {
                if (!visited[next[0]]) {
                    pq.add(next);
                }
            }

        }
        return res;

    }
}