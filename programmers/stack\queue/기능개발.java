import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        // i하나씩 증가시키면서 프로그래스에 스피드를 더함
        // 그러다가 앞에것이 100이 넘으면 출력 하는데 이떄 뒤에거도 100이상인지 확인 후 총 몇개가 출력되는지 확인

        // HashMap<Integer, Integer> map = new HashMap<>();
        // for(int i =0;i< progresses.length;i++){
        // map.put(progresses[i],speeds[i]);
        // }

        // 아니면 하나씩 다 계산해서 몇일 걸리는 지 배열에 다 넣어논 다음에 그 배열에서 확인
        // FIFO => Queue

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
        // 5 10 1 1 20 1

        // 7 3 9
        List<Integer> res = new ArrayList<>();
        int temp = queue.poll();
        int r = 1;

        // int len = queue.size();
        // for (int i = 0; i < len; i++) {// 012
        // if (queue.poll() <= temp) {
        // r++;
        // } else {
        // res.add(r);
        // r = 1;
        // if (queue.isEmpty()) {
        // break;
        // }
        // temp = queue.peek();
        // }
        // }
        // if (r != 0) {
        // res.add(r);
        // }
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current <= temp) {
                r++;
            } else {
                res.add(r);
                r = 1;
                temp = current;
            }
        }
        res.add(r);

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < speeds.length; i++) {
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int date = (int) Math.ceil(remain);

            if (!q.isEmpty() && q.peek() < date) {
                answerList.add(q.size());
                q.clear();
            }

            q.offer(date);
        }

        answerList.add(q.size());

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int tempProg = progresses[i];
            int tempSpeed = speeds[i];
            int days;
            if ((100 - tempProg) % tempSpeed == 0) {
                days = (100 - tempProg) / tempSpeed;
            } else {
                days = (100 - tempProg) / tempSpeed + 1;
            }

            if (!queue.isEmpty() && queue.peek() < days) {
                res.add(queue.size());
                queue.clear();
                queue.add(days);
                continue;
            }
            queue.add(days);

        }
        res.add(queue.size());
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> res = new ArrayList<>();
        // FIFO 7 3 9
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < speeds.length; i++) {
            double days = (double) (100 - progresses[i]) / speeds[i];
            int tempRes = (int) Math.ceil(days);

            if (q.isEmpty()) {
                q.add(tempRes);
            } else if (tempRes <= q.peek()) {
                q.add(tempRes);
            } else {
                res.add(q.size());
                q.clear();
                q.add(tempRes);
            }
        }
        res.add(q.size());
        return res.stream().mapToInt(Integer::intValue).toArray();

    }
}
