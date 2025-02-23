import java.util.*;
import java.io.*;

//7569
public class 7569 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] arr = new int[h][n][m];
        Queue<int[]> q = new LinkedList<>();
        int complete = m * n * h;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    arr[i][j][k] = temp;
                    if (temp == 1) {
                        q.add(new int[] { i, j, k, 0 });
                        complete--;
                    } else if (temp == -1) {
                        complete--;
                    }
                }
            }
        }

        // if (check(h, n, m, arr)) {
        // System.out.println(0);
        // return;
        // }

        int[] dz = new int[] { 1, -1, 0, 0, 0, 0 };
        int[] dy = new int[] { 0, 0, 1, -1, 0, 0 };
        int[] dx = new int[] { 0, 0, 0, 0, 1, -1 };
        int res = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int count = cur[3];
            for (int i = 0; i < 6; i++) {
                int z = cur[0] + dz[i];
                int y = cur[1] + dy[i];
                int x = cur[2] + dx[i];

                if (z >= 0 && y >= 0 && x >= 0 && z < h && y < n && x < m && arr[z][y][x] == 0) {
                    arr[z][y][x] = 1;
                    complete--;
                    q.add(new int[] { z, y, x, count + 1 });
                }
            }
            res = count;
        }
        // if (check(h, n, m, arr)) {
        // System.out.println(res);
        // } else {
        // System.out.println(-1);
        // }
        System.out.println(complete == 0 ? res : -1);
        return;

    }

    // public static boolean check(int h, int n, int m, int[][][] arr) {
    // for (int i = 0; i < h; i++) {
    // for (int j = 0; j < n; j++) {
    // for (int k = 0; k < m; k++) {
    // if (arr[i][j][k] == 0) {
    // return false;
    // }
    // }
    // }
    // }
    // return true;
    // }
}