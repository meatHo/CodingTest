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
// 배열로 front back만들어서 해보기

import java.util.*;
import java.io.*;

// 5430

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < time; j++) {
            char[] order = br.readLine().toCharArray();
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[num];
            int front = 0;
            int back = num - 1;

            StringBuilder input_temp = new StringBuilder();
            input_temp.append(br.readLine());
            String[] input = input_temp.deleteCharAt(input_temp.length() - 1).deleteCharAt(0).toString().trim()
                    .split(",");
            if (num != 0) {
                for (int i = 0; i < num; i++) {
                    arr[i] = Integer.parseInt(input[i]);
                }
            }

            boolean reverse = false;
            boolean error = false;

            for (char c : order) {
                if (c == 'R') {
                    reverse = !reverse;
                } else if (c == 'D') {
                    if (front > back) {
                        error = true;
                        break;
                    }
                    if (reverse) {
                        back--;
                    } else {
                        front++;
                    }
                }
            }

            if (error) {
                sb.append("error\n");
            } else {
                sb.append("[");
                if (front <= back) {
                    if (reverse) {
                        for (; front < back; back--) {
                            sb.append(arr[back] + ",");

                        }
                        sb.append(arr[front]);

                    } else {
                        for (; front < back; front++) {
                            sb.append(arr[front] + ",");

                        }
                        sb.append(arr[back]);
                    }
                }
                sb.append("]\n");
            }
        }
        System.out.println(sb.toString());
    }
}