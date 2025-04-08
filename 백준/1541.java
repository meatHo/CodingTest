import java.util.*;
import java.io.*;

//1541
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = br.readLine().trim().split("-");
        int res = 0;
        res += ssum(str[0].split("\\+"));
        // res += Arrays.stream(str[0].split("\\+")).mapToInt(Integer::parseInt).sum();
        for (int i = 1; i < str.length; i++) {
            // res -= Arrays.stream(str[i].split("\\+")).mapToInt(Integer::parseInt).sum();
            res -= ssum(str[i].split("\\+"));
        }
        bw.write(res + "\n");
        bw.flush();
    }

    public static int ssum(String[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int u = 0; u < len; u++) {
            sum += Integer.parseInt(arr[u]);
        }
        return sum;
    }

}
