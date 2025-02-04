import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        List<int[]> cams = new ArrayList<>();
        Arrays.sort(routes, (a, b) -> a[0] - b[0]);
        cams.add(routes[0]);

        for (int[] route : routes) {
            int start = route[0], end = route[1];
            for (int i = 0; i < cams.size(); i++) {
                int[] cam = cams.get(i);
                if (cam[1] < start || end < cam[0]) {
                    if (i == cams.size() - 1) {
                        cams.add(route);
                        break;
                    }
                    continue;
                } else if (cam[0] <= start && end <= cam[1]) {
                    cam[0] = start;
                    cam[1] = end;
                    break;
                } else if (start <= cam[0] && cam[1] <= end) {
                    break;
                } else if (start <= cam[0] && cam[0] <= end && end <= cam[1]) {
                    cam[1] = end;
                    break;
                } else if (cam[0] <= start && start <= cam[1] && cam[1] <= end) {
                    cam[0] = start;
                    break;
                }
            }
        }
        return cams.size();
    }
}

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int res = 0;
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        int cur = Integer.MIN_VALUE;

        for (int[] car : routes) {
            if (cur < car[0]) {
                cur = car[1];
                res++;
            }
        }

        return res;
    }
}