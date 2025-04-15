import java.util.*;
import java.io.*;

//1213
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] arr = br.readLine().trim().toCharArray();
        Map<Character, Integer> map = new TreeMap<>((a, b) -> a - b);
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int odd = 0;
        for (int i : map.values()) {
            if (i % 2 != 0) {
                odd++;
            }
        }
        int len = arr.length;
        if (odd > 0 && len % 2 == 0 || odd > 1 && len % 2 == 1) {
            bw.write("I'm Sorry Hansoo\n");
            bw.flush();
            return;
        }
        StringBuilder sb = new StringBuilder();
        char Codd = 0;
        for (char c : map.keySet()) {
            int num = map.get(c);
            if (num % 2 == 0) {
                for (int i = 0; i < num / 2; i++) {
                    bw.write(c);
                    sb.append(c);
                }
            } else {
                Codd = c;
                if (num == 1) {
                    continue;
                } else {
                    for (int i = 0; i < num / 2; i++) {
                        bw.write(c);
                        sb.append(c);
                    }
                }
            }
        }
        if (len % 2 != 0) {
            bw.write(Codd);
        }
        bw.write(sb.reverse().toString());
        bw.flush();

    }
}

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'A']++;
        }

        int odd_count = 0;
        int odd_index = 1;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                odd_index = i;
                odd_count++;
            }
        }

        if ((str.length() % 2 == 0 && odd_count > 0) ||
                (str.length() % 2 == 1 && odd_count != 1)) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++)
                System.out.printf("%c", 'A' + i);
        }

        if (odd_count == 1)
            System.out.printf("%c", 'A' + odd_index);

        for (int i = 25; i >= 0; i--) {
            for (int j = 0; j < count[i] / 2; j++)
                System.out.printf("%c", 'A' + i);
        }
        br.close();
    }
}