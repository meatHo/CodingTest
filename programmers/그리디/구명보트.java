import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> boats = new ArrayList<>();

        for (int i : people) {
            if (i == limit) {
                answer++;
                continue;
            }
            if (boats.isEmpty()) {
                boats.add(limit - i);
                answer++;
                continue;
            } else {// 여분 보트 중에 무게 남는거 확인
                int max = Collections.max(boats);
                if (boats.contains(i)) {
                    boats.remove(Integer.valueOf(i));
                    continue;
                } else if (max >= i) {
                    boats.remove(Integer.valueOf(max));
                    boats.add(max - i);
                    continue;
                } else {
                    boats.add(limit - i);
                    answer++;
                    continue;
                }
            }

        }

        return answer;
    }
}

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int res = 0;
        int right = people.length - 1;
        while (left < right) {
            if (people[left] + people[right] <= limit) {
                res++;
                left++;
                right--;
            } else {
                right--;
            }
        }
        return people.length - res;
        // 50 50 70 80

    }
}