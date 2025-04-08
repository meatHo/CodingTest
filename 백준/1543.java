import java.util.*;
import java.io.*;

//1543
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] input = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();
        int len = target.length;
        int count = 0;
        for (int i = 0; i < input.length - len + 1; i++) {
            int j = 0;
            int tempi = i;
            while (j < len && input[tempi] == target[j]) {
                j++;
                tempi++;
            }
            if (j == len) {
                count++;
                i = tempi - 1;
            }
        }
        System.out.println(count);
    }

}

import java.util.*;
import java.io.*;

// 1543
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String target = br.readLine();

        int i = 0;
        int count = 0;
        int len = target.length();

        while (i + len - 1 < input.length()) {
            if (input.substring(i, i + len).equals(target)) {
                count++;
                i += len;
            } else {
                i++;
            }
        }
        bw.write(count + "\n");
        bw.flush();
    }

}
