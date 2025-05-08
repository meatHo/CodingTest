import java.util.*;
import java.io.*;

//10844
//

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10];
        // dp[i][j]는 i자리 수이면서 마지막 자릿수가 j인 계단수

        // 1자리 수 초기화 (0으로 시작 불가)
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // DP 채우기
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j > 0) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
                if (j < 9) {
                    dp[i][j] += dp[i - 1][j + 1];
                }
                dp[i][j] %= MOD;
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        System.out.println(result);

    }

}
