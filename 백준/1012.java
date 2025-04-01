import java.util.*;
import java.io.*;

//1012
//

public class Main {
    static boolean[][] visited;
    static boolean[][] arr;
    static int ally;
    static int allx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int koh = Integer.parseInt(br.readLine());
        for (int koh1 = 0; koh1 < koh; koh1++) {
            String[] str = br.readLine().trim().split(" ");
            allx = Integer.parseInt(str[0]);
            ally = Integer.parseInt(str[1]);
            int num = Integer.parseInt(str[2]);
            arr = new boolean[ally][allx];
            visited = new boolean[ally][allx];
            for (int i = 0; i < num; i++) {
                String[] temp = br.readLine().trim().split(" ");
                int tx = Integer.parseInt(temp[0]);
                int ty = Integer.parseInt(temp[1]);
                arr[ty][tx] = true;
            }
            int count = 0;

            for (int i = 0; i < ally; i++) {
                for (int j = 0; j < allx; j++) {
                    if (arr[i][j] && !visited[i][j]) {
                        count++;
                        visited[i][j] = true;
                        dfs(i, j);
                    }
                }
            }
            bw.write(count + "\n");

        }
        bw.flush();
    }

    public static void dfs(int y, int x) {
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        for (int d = 0; d < 4; d++) {
            int tempx = x + dx[d];
            int tempy = y + dy[d];
            if (tempx < allx && tempy < ally && tempx > -1 && tempy > -1 && arr[tempy][tempx]
                    && !visited[tempy][tempx]) {
                visited[tempy][tempx] = true;
                dfs(tempy, tempx);
            }
        }
    }

}
