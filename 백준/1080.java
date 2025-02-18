import java.util.*;
import java.io.*;

public class 1080 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] input = new int[n][m];
        int[][] res = new int[n][m];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            String[] digits = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                input[i][j] = Integer.parseInt(digits[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            String[] digits = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                res[i][j] = Integer.parseInt(digits[j]);
            }
        }

        if (n < 3 || m < 3) {
            if (issame(n, m, input, res)) {
                System.out.println(0);
                return;
            }
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (input[i][j] != res[i][j]) {
                    if (change(i, j, input)) {
                        answer++;
                    }
                }
            }

        }
        if (issame(n, m, input, res)) {
            System.out.println(answer);
            return;
        }
        System.out.println(-1);
        return;

    }

    public static boolean issame(int n, int m, int[][] input, int[][] res) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (input[i][j] != res[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean change(int n, int m, int[][] input) {
        if (n + 2 > input.length || m + 2 > input[0].length) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (input[n + i][m + j] == 1) {
                    input[n + i][m + j] = 0;
                } else {
                    input[n + i][m + j] = 1;
                }
            }
        }
        return true;
    }
}