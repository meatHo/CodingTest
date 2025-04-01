import java.util.*;
import java.io.*;

//9237
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] trees = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(trees);
        int curday = 1;
        int maxday = Integer.MIN_VALUE;
        for (int i = num - 1; i >= 0; i--) {
            maxday = Math.max(maxday, curday + trees[i]);
            curday++;
        }
        System.out.println(maxday + 1);
    }
}
