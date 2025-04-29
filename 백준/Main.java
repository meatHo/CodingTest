import java.util.*;
import java.io.*;

//1697
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int house = Integer.parseInt(st.nextToken());
        int wifi = Integer.parseInt(st.nextToken());
        int[] wifis = new int[wifi];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < wifi; i++) {
            int temp = Integer.parseInt(br.readLine());
            wifis[i] = temp;
            min = Math.min(min, temp);
            max = Math.max(max, temp);
        }
        Arrays.sort(wifis);// 1 2 4 8 9

    }

}