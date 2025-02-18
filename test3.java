import java.util.*;

public class test3 {
    public static void main(String[] args) {
        String name = "hello";
        String name1 = name;
        name = name + "hello";
        System.out.println(name);
        System.out.println(name1);
        System.out.println((-1) % 3);
        System.out.println(name.length());

        StringBuilder sb = new StringBuilder();
        sb.append("hello");
        sb.insert(0, "good");
        System.out.println(sb);

        int[] people = new int[9];
        int n = 1;
        List<int[]> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new int[2]);
        }

        List<int[]> testlist = new ArrayList<>();
        testlist.add(new int[] { 1, 3 });
        System.out.println(testlist.contains(int[] { 1, 3 }));

    }
}
