import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        // visited 써서 찾아
        // 루트에서 다 찾은다음 visited에서 다 false인지 확인하고 다음 루트 설정해 반복
        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }
        return answer;
    }

    public void dfs(int cur, int[][] computers, boolean[] visited) {
        visited[cur] = true;
        for (int i = 0; i < computers[cur].length; i++) {
            if (computers[cur][i] == 1) {
                if (i == cur)
                    continue;
                if (!visited[i]) {
                    dfs(i, computers, visited);
                }
            }
        }
    }
}


[[1,0,1,1,1],
 [1,0,1,0,1],
 [1,0,1,1,1],
 [1,1,1,0,1],
 [0,0,0,0,1]]