import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class test2 {
    public static void main(String[] args) {
        int answer = 0;
        int[][] jobs = {
                { 0, 3 }, { 1, 9 }, { 3, 5 }
        };
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.get(1) == b.get(1)) {
                if (a.get(0) == b.get(0)) {
                    return a.get(2) - b.get(2);
                } else {
                    return a.get(0) - b.get(0);
                }
            } else {
                return a.get(1) - b.get(1);
            }
        });
        // 여기다가 작업 번호 추가해서 pq에 추가해 그리고 나열 조건 부분 완성

        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<ArrayList<Integer>> tempPq = new PriorityQueue<>((a, b) -> a.get(0) - b.get(0));
        int num = 0;
        for (int[] i : jobs) {
            ArrayList<Integer> al = new ArrayList<>();
            al.add(i[0]);
            al.add(i[1]);
            al.add(num);

            tempPq.add(al);
            num++;
        }

        int now = 0;

        while (!pq.isEmpty() || !tempPq.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (!tempPq.isEmpty() && tempPq.peek().get(0) <= now) {
                pq.add(tempPq.poll());

            }
            if (!pq.isEmpty()) {
                temp = pq.poll();
                now += temp.get(1);
                res.add(now - temp.get(0));
                System.out.println(now - temp.get(0));

                continue;
            }

            now++;
        }

        System.out.println(0 % 5);

        // helloworld
        // 0123456789
        String str = "helloworld";
        System.out.println(str.substring(0, 3) + str.substring(4, 6));
        System.out.println(str.substring(2));

        String numbers = "121";
        Set<Integer> allkind = new HashSet<>();
        permute("", numbers, allkind);
        System.out.println("경우의 수");
        for (int i : allkind) {
            System.out.println(i);
        }

        Set<Integer> res1 = new HashSet<>();
        int status = 1;
        for (int num1 : allkind) {
            for (int i = 2; i <= Math.sqrt(num1); i++) {
                if (num1 % i == 0) {
                    status = 1;
                    break;
                }
            }
            if (status == 1) {
                status = 0;
            } else {
                res1.add(num1);
            }

        }
        System.out.println("결과");
        for (int i : res1) {
            System.out.println(i);
        }

        int[][] arr3 = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        boolean[] booooooo = new boolean[3];
        System.out.println(booooooo[1]);

        // return res.stream().mapToInt(Integer::intValue).sum() / (num);
    }

    public static void permute(String prefix, String remain, Set<Integer> allkind) {
        if (!prefix.isEmpty()) {
            allkind.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < remain.length(); i++) {
            String newprefix = prefix + remain.charAt(i);
            String newremain = remain.substring(0, i) + remain.substring(i + 1);
            permute(newprefix, newremain, allkind);
        }
    }
}
