import java.util.*;
import java.io.*;

//1697
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int old = Integer.parseInt(st.nextToken());
        int tar = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q_time = new LinkedList<>();
        q.add(old);
        q_time.add(0);
        int cur_time = 0;
        boolean[] visited = new boolean[100001];
        while (!q.isEmpty()) {
            int cur = q.poll();
            cur_time = q_time.poll();

            if (cur == tar) {
                bw.write(cur_time + "\n");
                bw.flush();
                return;
            }

            if (cur < 0 || cur > 100000 || visited[cur])
                continue;

            visited[cur] = true;

            if (cur + 1 <= 100000) {
                q.add(cur + 1);
                q_time.add(cur_time + 1);
            }

            if (cur - 1 >= 0) {
                q.add(cur - 1);
                q_time.add(cur_time + 1);
            }

            if (cur * 2 <= 100000) {
                q.add(cur * 2);
                q_time.add(cur_time + 1);
            }
        }
        bw.write(cur_time + "\n");
        bw.flush();

    }

}
// 4 5 10 20 40 80