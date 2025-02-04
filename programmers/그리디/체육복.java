import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        List<Integer> lostList = new ArrayList<>();
        for (int i : lost) {
            lostList.add(i);
        }
        for (int i : reserve) {
            if (lostList.contains(i)) {
                lostList.remove(Integer.valueOf(i));
                continue;
            }
            q.add(i);
        }
        Collections.sort(lostList);

        for (int i : lostList) {
            if (q.contains(i)) {
                continue;
            } else if (q.contains(i - 1)) {
                q.remove(Integer.valueOf(i - 1));
            } else if (q.contains(i + 1)) {
                q.remove(Integer.valueOf(i + 1));
            } else {
                answer++;
            }
        }

        return n - answer;
    }
}