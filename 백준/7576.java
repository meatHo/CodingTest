import java.util.*;
import java.io.*;

//7576
public class 7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr[i][j] = temp;
                if (temp == 1) {
                    q.add(new int[] { i, j, 0 });
                }
            }
        }

        int[] dy = { 1, -1, 0, 0 };
        int[] dx = { 0, 0, 1, -1 };

        int before_cost = 0;
        while (!q.isEmpty()) {

            int[] temp = q.poll();
            int cost = temp[2];
            // System.out.println("y:" + temp[0] + " x:" + temp[1] + " cost:" + cost);
            for (int i = 0; i < 4; i++) {
                int y = temp[0] + dy[i];
                int x = temp[1] + dx[i];
                if (y >= 0 && y < n && x >= 0 && x < m && arr[y][x] == 0) {
                    arr[y][x] = 1;
                    q.add(new int[] { y, x, cost + 1 });
                }
            }
            before_cost = cost;
        }
        if (!check(arr, n, m)) {
            System.out.println(-1);
            return;
        }
        System.out.println(before_cost);
        return;

    }

    public static boolean check(int[][] arr, int n, int m) {
        for (int a = 0; a < n; a++) {
            for (int b = 0; b < m; b++) {
                if (arr[a][b] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
