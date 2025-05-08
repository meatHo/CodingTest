import java.util.*;
import java.io.*;

//11286
//

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int koh = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (Math.abs(a) == Math.abs(b)) {
                    return a - b;
                } else {
                    return Math.abs(a) - Math.abs(b);
                }
            }
        });
        for (int i = 0; i < koh; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num != 0) {
                pq.add(num);
            } else {
                if (pq.isEmpty()) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(pq.poll() + "\n");
                }
            }
        }
        bw.flush();
    }
}