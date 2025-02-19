import java.util.*;
import java.io.*;

//2178
public class 2178 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        bfs(arr, n, m);
        return;
    }

    public static void bfs(int[][] arr, int n, int m) {

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 1 });

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == n - 1 && cur[1] == m - 1) {
                System.out.println(cur[2]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int newy = cur[0] + dy[i];
                int newx = cur[1] + dx[i];
                int count = cur[2];
                if (newy >= 0 && newy < n && newx >= 0 && newx < m && arr[newy][newx] == 1 && !visited[newy][newx]) {
                    visited[newy][newx] = true;
                    q.add(new int[] { newy, newx, count + 1 });
                }
            }
        }
        return;
    }
}
