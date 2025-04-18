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
