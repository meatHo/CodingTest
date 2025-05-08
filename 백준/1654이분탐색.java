import java.util.*;
import java.io.*;

//1654
//

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] lines = new int[k];
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(lines[i], max);
        }
        long left = 1;
        long right = max;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int line : lines) {
                count += (line / mid);
            }
            if (count >= n) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        bw.write(result + "\n");
        bw.flush();

    }

}
