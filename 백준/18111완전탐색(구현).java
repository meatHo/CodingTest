import java.util.*;
import java.io.*;

//18111
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long item = Long.parseLong(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                min = Math.min(min, temp);
                max = Math.max(max, temp);

            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;

        for (int h = min; h <= max; h++) {
            int temp_time = 0;
            long temp_item = item;
            for (int temp : map.keySet()) {
                int num = map.get(temp);
                if (temp > h) {
                    temp_time = temp_time + (temp - h) * 2 * num;
                    temp_item = temp_item + (temp - h) * num;
                } else {
                    temp_time = temp_time + (h - temp) * num;
                    temp_item = temp_item - (h - temp) * num;

                }
            }
            if (temp_item < 0) {
                continue;
            }
            if (temp_time < time) {
                height = h;
                time = temp_time;
            } else if (temp_time == time) {
                height = Math.max(height, h);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(time + " " + height);
        System.out.println(sb);

    }
}

import java.util.*;
import java.io.*;

// 18111
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long item = Long.parseLong(st.nextToken());
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map.put(temp, map.getOrDefault(temp, 0) + 1);
                min = Math.min(min, temp);
                max = Math.max(max, temp);

            }
        }

        int time = Integer.MAX_VALUE;
        int height = 0;

        for (int h = min; h <= max; h++) {
            int temp_time = 0;
            long temp_item = item;
            for (int temp : map.keySet()) {
                int num = map.get(temp);
                if (temp > h) {
                    temp_time = temp_time + (temp - h) * 2 * num;
                    temp_item = temp_item + (temp - h) * num;
                } else {
                    temp_time = temp_time + (h - temp) * num;
                    temp_item = temp_item - (h - temp) * num;

                }
            }
            if (temp_item < 0) {
                continue;
            }
            if (temp_time < time) {
                height = h;
                time = temp_time;
            } else if (temp_time == time) {
                height = Math.max(height, h);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(time + " " + height);
        System.out.println(sb);

    }
}