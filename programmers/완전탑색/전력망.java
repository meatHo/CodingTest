import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int res = Integer.MAX_VALUE;
        for(int a=0;a<n-1;a++){
            boolean[] visited = new boolean[n - 1];
            visited[a]=true;
            HashSet<Integer> set = new HashSet<>();
            if(a==0){
                set.add(wires[1][0]);
                set.add(wires[1][1]);
            }else{
                set.add(wires[0][0]);
                set.add(wires[0][1]);
            }
            for(int i=0;i<n-1;i++){
                if(visited[i]==false && (set.contains(wires[i][0]) || set.contains(wires[i][1]))){
                    set.add(wires[i][0]);
                    set.add(wires[i][1]);
                    visited[i]=true;
                }
            }
            
            int count = set.size();
            
            if (res > Math.abs(count - (n - count))) {
                res = Math.abs(count - (n - count));
            }
            set.clear();
        }
        return res;
    }
}

import java.util.*;

class Solution {
    private List<List<Integer>> graph;
    private int[] subtreeSize;
    private int minDiff = Integer.MAX_VALUE;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int[] wire : wires) {
            int a = wire[0], b = wire[1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        subtreeSize = new int[n + 1];
        computeSubtreeSizes(wires[0][0], -1, n); // 첫 번째 wire의 한 노드에서 DFS 시작

        return minDiff;
    }

    private int computeSubtreeSizes(int node, int parent, int n) {
        subtreeSize[node] = 1; // 현재 노드 포함
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                subtreeSize[node] += computeSubtreeSizes(neighbor, node, n);
                int diff = Math.abs(n - 2 * subtreeSize[neighbor]);
                minDiff = Math.min(minDiff, diff);
            }
        }
        return subtreeSize[node];
    }
}

import java.util.*;

class Solution {
    private static int res = Integer.MAX_VALUE;
    private static List<List<Integer>> graph;
    private static int num;
    private static int[] subtree;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList<>();
        num = n;

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] i : wires) {
            int node1 = i[0];
            int node2 = i[1];
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        subtree = new int[n + 1];
        dfs(wires[0][0], -1);

        return res;
    }

    public int dfs(int node, int parent) {
        subtree[node] = 1;
        for (int neighbor : graph.get(node)) {
            if (neighbor != parent) {
                subtree[node] += dfs(neighbor, node);
                int diff = Math.abs(num - 2 * subtree[neighbor]);
                res = Math.min(res, diff);
            }
        }
        return subtree[node];
    }
}

import java.util.*;

class Solution {
    private List<List<Integer>> wires_list;
    private int number, res;
    private int[] subtree;

    public int solution(int n, int[][] wires) {
        wires_list = new ArrayList<>();
        number = n;
        res = Integer.MAX_VALUE;
        subtree = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            wires_list.add(new ArrayList<>());
        }
        for (int[] wire : wires) {
            int tmpNode1 = wire[0], tmpNode2 = wire[1];
            wires_list.get(tmpNode1).add(tmpNode2);
            wires_list.get(tmpNode2).add(tmpNode1);
        }

        dfs(-1, wires[0][0]);
        return res;
    }

    public int dfs(int parent, int node) {
        int count = 1;

        for (int neighbor : wires_list.get(node)) {
            if (parent != neighbor) {
                count += dfs(node, neighbor);
            }
        }
        subtree[node] = count;
        res = Math.min(res, Math.abs(number - 2 * count));
        return count;
    }

}
// dfs(1,-1) -> dfs(3,1) -> dfs(2,3) -> dfs()
/*
 * 1 3
 * 2 3
 * 3 1,2,4
 * 4 4,5,6,7
 * 6 4
 * 7 4,8,9
 * 8 7
 * 9 7
 */
