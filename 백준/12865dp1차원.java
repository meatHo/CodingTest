import java.util.*;
import java.io.*;

public class 12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int weightSum = Integer.parseInt(st.nextToken());

        int[][] items = new int[num][2];

        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[weightSum + 1];

        for (int i = 0; i < num; i++) {
            int tempWeight = items[i][0];
            int tempValue = items[i][1];

            for (int j = weightSum; j >= tempWeight; j--) {
                dp[j] = Math.max(dp[j], dp[j - tempWeight] + tempValue);
            }
        }
        System.out.println(dp[weightSum]);
    }
}
