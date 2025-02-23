import java.util.*;
import java.io.*;

//5430
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int p = 0; p < num; p++) {
            String str = br.readLine();
            int count = Integer.parseInt(br.readLine());
            List<Integer> arr = new ArrayList<>();
            String str_input = br.readLine();
            String[] input = new StringBuilder(str_input).deleteCharAt(0).deleteCharAt(str_input.length() - 2)
                    .toString().trim().split(",");

            if (input.length == 1 && input[0].isEmpty()) {
                System.out.println("error");
                continue;
            }

            for (String c : input) {
                arr.add(Integer.parseInt(c));
            }

            StringBuilder res = new StringBuilder();
            for (char c : str.toCharArray()) {
                if (c == 'R') {
                    Collections.reverse(arr);
                } else if (c == 'D') {
                    if (arr.size() == 0) {
                        res.append("error");
                        break;
                    } else {
                        arr.remove(0);
                    }
                }
            }

            if (!res.isEmpty()) {
                System.out.println(res.toString());
                continue;
            }
            res.append("[");
            for (int i = 0; i < arr.size(); i++) {
                res.append(arr.get(i));
                if (i != arr.size() - 1) {
                    res.append(",");
                }
            }
            res.append("]");
            System.out.println(res.toString());
        }

    }

}

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        for (int p = 0; p < num; p++) {
            String str = br.readLine();
            int count = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new LinkedList<>();
            String str_input = br.readLine();

            String[] input = str_input.substring(1, str_input.length() - 1).split(",");
            if (input.length == 1 && input[0].isEmpty()) {
                if (count > 0) {
                    sb.append("error\n");
                    continue;
                }
            } else {
                for (String s : input) {
                    deque.add(Integer.parseInt(s));
                }
            }

            boolean reverse = false;
            boolean error = false;

            for (char c : str.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (deque.isEmpty()) {
                        sb.append("error\n");
                        error = true;
                        break;
                    }
                    if (reverse) {
                        deque.pollLast();
                    } else {
                        deque.pollFirst();
                    }
                }
            }

            if (!error) {
                sb.append("[");
                while (!deque.isEmpty()) {
                    sb.append(reverse ? deque.pollLast() : deque.pollFirst());
                    if (!deque.isEmpty())
                        sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb.toString());
    }
}
// 배열로 front back만들어서 해보기