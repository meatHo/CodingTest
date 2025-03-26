import java.util.*;
import java.io.*;

//1912
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int koh = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[koh];
        for (int i = 0; i < koh; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 음수가 나오면 거기까지의 숫자를 저장하고 음수 후 양수 쭉 나오고 다시 음수or배열 끝까지
        // 탐색 후 저장한 숫자와 비교 후 양수면 그 숫자를 또 저장. 음수면 버려

        int curSum = 0;
        int[] dp = new int[koh + 1];
        for (int i = 0; i < koh + 1; i++) {
            dp[i] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < koh; i++) {
            curSum += arr[i];
            dp[i + 1] = Math.max(dp[i], curSum);
            curSum = Math.max(curSum, 0);
        }
        System.out.println(dp[koh]);
    }
}