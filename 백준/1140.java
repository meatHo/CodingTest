import java.util.*;
import java.io.*;

public class 1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[][] arr = new int[num][3];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(dp(num, arr));
        return;
    }

    public static int dp(int num, int[][] arr) {

        for (int i = 1; i < num; i++) {
            arr[i][0] += Math.min(arr[i - 1][1], arr[i - 1][2]);
            arr[i][1] += Math.min(arr[i - 1][0], arr[i - 1][2]);
            arr[i][2] += Math.min(arr[i - 1][1], arr[i - 1][0]);
        }

        return Math.min(arr[num - 1][0], Math.min(arr[num - 1][1], arr[num - 1][2]));
    }
}
