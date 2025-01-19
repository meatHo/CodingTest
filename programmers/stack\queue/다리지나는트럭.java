import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        // 큐에 대기 트럭을 넣음
        // 그리고 변수 하나 설정해서 이게 weight보다 작은지 점검 작으면 추가
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < truck_weights.length; i++) {
            q.add(truck_weights[i]);
        }

        int nowWeight = 0;
        Queue<int[]> nowQ = new LinkedList<>();
        while (!nowQ.isEmpty() || !q.isEmpty()) {

            if (!nowQ.isEmpty() && nowQ.peek()[1] == bridge_length) {
                nowWeight -= nowQ.poll()[0];
                // if (nowQ.isEmpty() && q.isEmpty()) {
                // answer++;
                // break;
                // }
            }
            if (!q.isEmpty() && nowWeight + q.peek() <= weight) {
                int temp = q.poll();
                nowWeight += temp;
                nowQ.add(new int[] { temp, 0 });
            }

            if (!nowQ.isEmpty()) {
                for (int[] i : nowQ) {
                    i[1]++;
                }
            }

            answer++;
        }
        // 반복문을 true로 쓰고 생략된 부분 지우면
        // return ++answer
        return answer;
    }
}