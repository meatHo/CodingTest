import java.util.*;

class Solution {
    public int solution(int[] citations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i : citations) {
            pq.add(i);
        }
        int res = 0;
        while (!pq.isEmpty() && pq.peek() > res) {
            pq.poll();
            res++;
        }
        return res;

    }
}
// 0 0 2 9 9 9
// 0 1 1 1 3 3 5 6
// 1 100 100 100
// 5 100 100 100

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations); // 배열을 오름차순으로 정렬
        int n = citations.length;

        for (int i = 0; i < n; i++) {
            int h = n - i; // 현재 논문의 개수
            if (citations[i] >= n - i) {// 남은 논문의 최소값 >= 남은 논문 갯수
                return h;
            }
        }
        return 0; // H-Index가 없을 경우
    }
}