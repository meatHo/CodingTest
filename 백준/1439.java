import java.util.*;
import java.io.*;

//1439
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 처음과 끝 같으면 안뒤집음
        String str = br.readLine().trim();
        char[] arrs = str.toCharArray();
        int len = arrs.length;
        int before = arrs[0];
        int count = 0;
        for (int i = 1; i < len; i++) {
            if (before == arrs[i]) {
                continue;
            } else {
                before = arrs[i];
                count++;
                continue;
            }
        }
        if (arrs[0] == arrs[len - 1]) {
            bw.write(count / 2 + "\n");
        } else {
            bw.write((count + 1) / 2 + "\n");
        }
        bw.flush();

    }

}
// 0011