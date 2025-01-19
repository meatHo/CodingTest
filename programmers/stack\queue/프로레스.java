import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // priorities에서 가장 큰 수를 찾고 그 다음 큰수와 다음 큰수 비교해서 같으면 그냥 다음걸로 진행
        // 다르면 다른 것으로 점프

        // 리스트에서 맥스를 고른다음 indexat으로 위치 찾아 출력 하고 이전 맥스 다음것과 현재 맥스 찾아서 함
        // 출력한 것은 0으로 바꿈

        List<Integer> arr = new ArrayList<>();
        for (int priority : priorities) {
            arr.add(priority); // int를 Integer로 변환 후 추가
        }
        // 1 1 9 1 1 1 //0
        // 0 1 2 3 4 5
        // 1 1 0 0 1 1

        int res = 1;
        int lastloc = 0;
        int len = priorities.length;
        while (true) {
            int max = Collections.max(arr);
            int maxLoc = 0;

            for (int i = 0; i < len; i++) {
                if (max == arr.get((i + lastloc) % len)) {
                    maxLoc = (i + lastloc) % len;
                    break;
                }
            }

            if (maxLoc == location) {
                return res;
            }

            res++;
            arr.set(maxLoc, 0);
            lastloc = (maxLoc + 1) % len;

        }
    }
}

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        // 그냥 큐 하나씩 박은 다음에 꺼내서 그게 맥스를 찾아 맥스랑 비교 하고
        // 맥스 찾을 때 까지 뺴서 뒤에다 삽입
        // 맥스 찾으면 그게 같은지 확인하고 이 맥스는 다시 넣지 않음
        // 걍 큐 두개를 동시에 관리 해버려

        Queue<Integer> prioritiesQueue = new LinkedList<>();
        Queue<Integer> locQueue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            prioritiesQueue.add(priorities[i]);
            locQueue.add(i);
        }

        while (true) {
            int tempMax = Collections.max(prioritiesQueue);

            for (int i = 0; i < priorities.length; i++) {
                int temp = prioritiesQueue.poll();
                if (tempMax == temp) {
                    break;
                } else {
                    prioritiesQueue.add(temp);
                    locQueue.add(locQueue.poll());
                }
            }
            if (locQueue.peek() == location) {
                return answer;
            } else {
                locQueue.poll();
                answer++;
            }
        }

        return answer;
    }
}

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        // 그냥 큐 하나씩 박은 다음에 꺼내서 그게 맥스를 찾아 맥스랑 비교 하고
        // 맥스 찾을 때 까지 뺴서 뒤에다 삽입
        // 맥스 찾으면 그게 같은지 확인하고 이 맥스는 다시 넣지 않음
        // 걍 큐 두개를 동시에 관리 해버려

        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new int[] { i, priorities[i] });
            maxHeap.add(priorities[i]);
        }

        while (!maxHeap.isEmpty()) {
            int[] temp = queue.poll();
            if (maxHeap.peek() == temp[1]) {
                if (temp[0] == location) {
                    return answer;
                } else {
                    maxHeap.poll();
                    answer++;
                }
            } else {
                queue.add(temp);
            }
        }

        return answer;
    }
}