import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> column = new ArrayList<>();
        ArrayList<Integer> square = new ArrayList<>();
        for (int[] i : sizes) {
            if (i[0] < i[1]) {
                row.add(i[0]);
                column.add(i[1]);// 더 긴거
            } else {
                column.add(i[0]);
                row.add(i[1]);
            }
            square.add(i[0] * i[1]);
        }
        Collections.sort(row, Collections.reverseOrder());
        Collections.sort(column, Collections.reverseOrder());
        Collections.sort(square, Collections.reverseOrder());
        if (row.get(0) * column.get(0) < square.get(0)) {
            return square.get(0);
        } else {
            return row.get(0) * column.get(0);
        }

    }
}

import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int longone = 0, shortone = 0;
        for (int[] i : sizes) {
            longone = Math.max(longone, Math.max(i[0], i[1]));
            shortone = Math.max(shortone, Math.min(i[0], i[1]));
        }
        return longone * shortone;

    }
}