import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        String[][] clothes = {
                { "yellow_hat", "headgear" },
                { "blue_sunglasses", "eyewear" },
                { "green_turban", "headgear" }
        };
        for (String[] s : clothes) {
            System.out.println(s[1]);

        }

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int[] filtered = list.stream().mapToInt(Integer::intValue)
                .filter(x -> x > 2).toArray(); // 2보다 큰 값만 남김
        System.out.println(filtered); // 출력: [3, 4, 5]

        Map<String, Integer> map = new HashMap<>();

        map.put("A", 10);
        map.put("D", 30);
        map.put("C", 20);
        map.put("B", 40);

        List<String> keySet = new ArrayList<>(map.keySet());

        // Value 값으로 오름차순 정렬
        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o1).compareTo(map.get(o2));
            }
        });

        for (String key : keySet) {
            System.out.print("Key : " + key);
            System.out.println(", Val : " + map.get(key));
        }

        /*
         * 결과
         * Key : A, Val : 10
         * Key : C, Val : 20
         * Key : D, Val : 30
         * Key : B, Val : 40
         */

        // Value 값으로 내림차순 정렬
        // 위 comparator 람다 표현식으로
        int[] progresses = { 93, 30, 55 };
        int[] speeds = { 1, 30, 5 };

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            int tempProg = progresses[i];
            int tempSpeed = speeds[i];
            if ((100 - tempProg) % tempSpeed == 0) {
                queue.add((100 - tempProg) / tempSpeed);
            } else {
                queue.add((100 - tempProg) / tempSpeed + 1);
            }
        }
        // 7 3 9
        List<Integer> res = new ArrayList<>();
        int temp = queue.peek();
        int r = 0;
        System.out.println(queue.size());
        for (int i = 0; i < queue.size(); i++) {// 012
            System.out.println("peek" + queue.peek());
            System.out.println("i:" + i);
            if (queue.poll() <= temp) {
                r++;
            } else {
                res.add(r);
                r = 0;

                if (queue.isEmpty()) {
                    r++;
                    System.out.println("break");
                    break;
                }
                temp = queue.peek();
            }
        }
        System.out.println(r);
        if (r != 0) {
            res.add(r);
        }

    }
}
