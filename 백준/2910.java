import java.util.*;
import java.io.*;

//2910
//

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        String[] temparr = br.readLine().split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> order = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(temparr[i]);
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if (!order.containsKey(temp)) {
                order.put(temp, i);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> {
            if (Objects.equals(map.get(o1), map.get(o2))) {
                return order.get(o1) - order.get(o2);
            }
            return map.get(o2).compareTo(map.get(o1));
        });

        for (int num : list) {

            int times = map.get(num);
            for (int j = 0; j < times; j++) {
                bw.write(num + " ");
            }
        }
        bw.write("\n");
        bw.flush();

    }
}
