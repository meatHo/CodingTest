import java.util.*;
import java.io.*;

//14501
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int koh = Integer.parseInt(br.readLine());
        int[] time = new int[koh + 1];
        int[] price = new int[koh + 1];
        for (int i = 0; i < koh; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i + 1] = Integer.parseInt(st.nextToken());
            price[i + 1] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[koh + 2];
        for (int i = 1; i <= koh; i++) {
            int tempDay = i + time[i];
            if (tempDay <= koh + 1) {
                dp[tempDay] = Math.max(dp[tempDay], dp[i] + price[i]);
            }
            dp[i + 1] = Math.max(dp[i], dp[i + 1]);
        }
        System.out.println(dp[koh + 1]);
    }
}
// dp 식
// 0일차의 것을 선택하게 되면 3일차의 dp에 계산이 반영됨
// 3일걸리니까

 	1일	2일	3일	4일	5일	6일	7일
Ti	3	1	1	1	2	4	2
Pi	10	20	10	20	15	40	200