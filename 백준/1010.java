import java.util.*;
import java.io.*;
//1010

public class 1010 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        for (int j = 0; j < num; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            if (left > right - left) {
                left = right - left;
            }

            // right C left
            combination(right, left);
        }
        return;
    }

    public static void combination(long right, long left) {
        long res = 1;
        for (int i = 0; i < left; i++) {
            res = res * (right - i);
            res = res / (i + 1);
        }

        System.out.println(res);
    }
}
