import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
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
            while (!tempPq.isEmpty() && tempPq.peek().get(0) <= now) {
                pq.add(tempPq.poll());

            }
            if (!pq.isEmpty()) {
                temp = pq.poll();
                now += temp.get(1);
                res.add(now - temp.get(0));

                continue;
            }

            now++;
        }

        return res.stream().mapToInt(Integer::intValue).sum() / (num);
    }
}

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> tempPq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int num = 0;
        for (int[] i : jobs) {
            tempPq.add(i);
            num++;
        }

        int res = 0;
        int now = 0;
        while (!tempPq.isEmpty() || !pq.isEmpty()) {
            while (!tempPq.isEmpty() && tempPq.peek()[0] <= now) {
                pq.add(tempPq.poll());
            }

            if (!pq.isEmpty()) {
                int[] temp = pq.poll();
                now += temp[1];
                res = res + now - temp[0];
                continue;
            }
            now++;
        }
        return res / num;

    }
}