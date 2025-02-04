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

import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int res = 0;
        List<List<int[]>> nodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }
        for (int i = 0; i < costs.length; i++) {
            int node1 = costs[i][0];
            int node2 = costs[i][1];
            int cost = costs[i][2];
            nodes.get(node1).add(new int[] { node2, cost });
            nodes.get(node2).add(new int[] { node1, cost });
        }

        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);// cost 낮은 순
        pq.addAll(nodes.get(0));
        visited[0] = true;
        int node = 0;
        while (node < n - 1) {// 방문된 노드 갯수 변수 선언해서 그거로 종료 선언
            int[] cur = pq.poll();
            if (visited[cur[0]]) {// 이미 방문된 노드
                continue;
            }
            visited[cur[0]] = true;
            res += cur[1];
            node++;
            for (int[] i : nodes.get(cur[0])) {
                pq.add(i);
            }

        }

        return res;

    }
}