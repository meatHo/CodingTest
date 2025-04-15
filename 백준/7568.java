import java.util.*;
import java.io.*;

//7568
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] nums = new int[num][2];
        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken());
            nums[i][1] = Integer.parseInt(st.nextToken());
        }
        // 하나씩 비교하면서 write해버리고 출력
        for (int i = 0; i < num; i++) {
            int weighti = nums[i][0];
            int heighti = nums[i][1];
            int count = 1;
            for (int j = 0; j < num; j++) {
                if (i == j) {
                    continue;
                }
                int weightj = nums[j][0];
                int heightj = nums[j][1];
                if (weighti < weightj && heighti < heightj) {
                    count++;
                }
            } // count저장한다음 num+1에서 count 뺴서 저장
            bw.write(count + " ");
        }
        bw.flush();
    }

}
