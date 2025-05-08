import java.util.*;
import java.io.*;

//14426
//

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Character, ArrayList<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String temp = br.readLine().trim();
            Character c = temp.charAt(0);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(temp);
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            String temp = br.readLine().trim();
            Character c = temp.charAt(0);
            if (map.containsKey(c)) {
                ArrayList<String> list = map.get(c);
                for (String s : list) {
                    if (s.startsWith(temp)) {
                        count++;
                        break;// 한번만 체크한다네요
                    }
                }
            }

        }
        bw.write(count + "\n");
        bw.flush();

    }

}
// ==위에가 시간초과 난 버전

import java.util.*;
import java.io.*;

// 14426
//

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] set = new String[n];

        for (int i = 0; i < n; i++) {
            set[i] = br.readLine().trim();
        }
        Arrays.sort(set);

        int count = 0;
        for (int i = 0; i < m; i++) {
            String temp = br.readLine().trim();
            int num = Arrays.binarySearch(set, temp);
            if (num < 0) {
                num = -(num + 1);
            }
            if (num < n && set[num].startsWith(temp)) {
                count++;
            }

        }
        bw.write(count + "\n");
        bw.flush();

    }

}