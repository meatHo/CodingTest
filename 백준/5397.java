import java.util.*;
import java.io.*;

//5397
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int koh = Integer.parseInt(br.readLine());
        for (int koh1 = 0; koh1 < koh; koh1++) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            char[] inputs = br.readLine().trim().toCharArray();
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();
            for (char c : inputs) {
                if (c == '<') {
                    if (!left.isEmpty()) {
                        right.add(left.pop());
                    }
                } else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.add(right.pop());
                    }
                } else if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                } else {
                    left.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (char c : left) {
                sb.append(c);
            }
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }
            bw.write(sb.toString() + "\n");
            bw.flush();

        }

    }
}

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        while (T-- > 0) {
            String input = br.readLine();
            Deque<Character> left = new LinkedList<>();
            Deque<Character> right = new LinkedList<>();

            for (char c : input.toCharArray()) {
                if (c == '<') {
                    if (!left.isEmpty()) {
                        right.push(left.pollLast());
                    }
                } else if (c == '>') {
                    if (!right.isEmpty()) {
                        left.addLast(right.pop());
                    }
                } else if (c == '-') {
                    if (!left.isEmpty()) {
                        left.pollLast();
                    }
                } else {
                    left.addLast(c);
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char ch : left)
                sb.append(ch);
            while (!right.isEmpty())
                sb.append(right.pop());
            System.out.println(sb);
        }
    }
}