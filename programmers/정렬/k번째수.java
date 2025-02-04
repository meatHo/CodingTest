import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int[] i : commands) {
            ArrayList<Integer> cut = new ArrayList<>();
            int start = i[0];
            int end = i[1];
            int num = i[2];

            for (int a = start - 1; a < end; a++) {
                cut.add(array[a]);
            }
            Collections.sort(cut);
            res.add(cut.get(num - 1));
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int[] command : commands) {
            int start = command[0] - 1; // 시작 인덱스 (0-based)
            int end = command[1]; // 끝 인덱스 (copyOfRange는 끝 미포함)
            int num = command[2] - 1; // k번째 숫자 (0-based)

            // 배열 자르기 & 정렬
            int[] cut = Arrays.copyOfRange(array, start, end);
            Arrays.sort(cut);

            // k번째 숫자 가져오기
            res.add(cut[num]);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}