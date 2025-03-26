import java.util.*;
import java.io.*;

//20920
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < num; i++) {
            String temp = br.readLine();
            if (temp.length() < length) {
                continue;
            }
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        // a,b b-a=-1
        // 3 1
        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int temp1 = map.get(o1);
                int temp2 = map.get(o2);
                if (temp1 != temp2) {
                    return temp2 - temp1;
                }
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                // o1,o2
                return o1.compareTo(o2);// o1-o2가 음수 o2가 큼
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}
