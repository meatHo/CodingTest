import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int len = answers.length;
        int[] one = { 1, 2, 3, 4, 5 };
        int[] two = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] thr = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

        int[] answer = { 0, 0, 0 };

        for (int i = 0; i < len; i++) {
            if (answers[i] == one[i % 5]) {
                answer[0]++;
            }
            if (answers[i] == two[i % 8]) {
                answer[1]++;
            }
            if (answers[i] == thr[i % 10]) {
                answer[2]++;
            }
        }

        int maxscore = Math.max(answer[0], Math.max(answer[1], answer[2]));
        ArrayList<Integer> res = new ArrayList<>();
        if (maxscore == answer[0]) {
            res.add(1);
        }
        if (maxscore == answer[1]) {
            res.add(2);
        }
        if (maxscore == answer[2]) {
            res.add(3);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}