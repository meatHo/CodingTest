import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();// minheap
        for (int i : scoville) {
            pq.add(i);
        }

        while (true) {
            int temp = pq.poll();
            if (temp < K) {
                pq.add(temp + pq.poll() * 2);
                answer++;
            } else {
                break;
            }
            if (pq.size() == 1 && pq.peek() < K) {
                return -1;
            }
        }

        return answer;
    }
}