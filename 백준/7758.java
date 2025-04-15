import java.util.*;
import java.io.*;

//7758
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> names = new HashSet<>();

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] strs = br.readLine().trim().split(" ");
            String name = strs[0];
            String action = strs[1];
            if (action.startsWith("e")) {
                names.add(name);
            } else {  
                names.remove(name);
            }
        }
        List<String> sorted = new ArrayList<>(names);
        sorted.sort(Comparator.reverseOrder());
        for (int i = 0; i < sorted.size(); i++) {
            bw.write(sorted.get(i) + "\n");
        }
        bw.flush();
    }

}

import java.util.*;
import java.io.*;

// 7758
//

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<String> names = new TreeSet<>(Comparator.reverseOrder());

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] strs = br.readLine().trim().split(" ");
            String name = strs[0];
            String action = strs[1];
            if (action.startsWith("e")) {
                names.add(name);
            } else {
                names.remove(name);
            }
        }

        for (String s : names) {
            bw.write(s + "\n");
        }
        bw.flush();
    }

}