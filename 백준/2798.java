import java.util.*;
import java.io.*;

//2798
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input2 = br.readLine().trim().split(" ");
        int num = Integer.parseInt(input2[0]);
        int res = Integer.parseInt(input2[1]);

        int[] nums = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(nums);
        // <21인지 확인하고 max로 최대 구함
        int maxsum = Integer.MIN_VALUE;
        for (int i = 0; i < num - 2; i++) {
            // for문 하나 더 돌려서 왼쪽 끝, 오른쪽 끝 이렇게 포인터 두개 돌려서 진행
            for (int j = i + 1; j < num - 1; j++) {
                for (int a = j + 1; a < num; a++) {
                    int tempsum = nums[i] + nums[j] + nums[a];
                    if (tempsum <= res) {
                        maxsum = Math.max(tempsum, maxsum);
                    }

                }
            }
        }
        bw.write(maxsum + "\n");
        bw.flush();
    }

}
