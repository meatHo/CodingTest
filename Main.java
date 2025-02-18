import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] input = new int[n][m];
        int[][] res = new int[n][m];
        if (n < 3 || m < 3) {
            System.out.println(-1);
            return;
        }

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

    }
}