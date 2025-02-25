import java.util.*;
import java.io.*;

//5430
//

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