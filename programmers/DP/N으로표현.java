import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) return 1;

        Map<Integer, HashSet<Integer>> dp = new HashMap<>();
        for (int i = 1; i <= 8; i++) {
            dp.put(i, new HashSet<>());
        }

        // 5, 55, 555, 5555, ... 미리 추가
        int num = 0;
        for (int i = 1; i <= 8; i++) {
            num = num * 10 + N;
            dp.get(i).add(num);
            if (num == number) return i;
        }

        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(i - j)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) dp.get(i).add(num1 / num2);
                    }
                }
            }
            if (dp.get(i).contains(number)) return i;
        }

        return -1;
    }
}

import java.util.*;

class Solution {
    private int num;
    private int maxCount;
    private int oneDigit;

    public int solution(int N, int number) {
        num = number;
        maxCount = 8;
        oneDigit = N;
        List<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < maxCount + 1; i++) {
            list.add(new HashSet<>());
        }
        list.get(1).add(N);

        return dp(list, 1);

    }

    public int dp(List<HashSet<Integer>> list, int count) {

        StringBuilder sb = new StringBuilder();
        if (count < 11) {
            for (int a = 0; a < count; a++) {
                sb.append("1");
            }

            list.get(count).add(oneDigit * Integer.parseInt(sb.toString()));
            sb.setLength(0);
        }

        for (int a = 1; a < count; a++) {// a, count-a
            if (a > count - a)
                break;

            HashSet<Integer> num1set = list.get(a);
            HashSet<Integer> num2set = list.get(count - a);
            for (int num1 : num1set) {
                for (int num2 : num2set) {
                    list.get(count).add(num1 + num2);
                    list.get(count).add(num1 - num2);
                    list.get(count).add(num2 - num1);
                    if (num2 != 0)
                        list.get(count).add(num1 / num2);
                    if (num1 != 0)
                        list.get(count).add(num2 / num1);
                    list.get(count).add(num1 * num2);

                }
            }
        }
        if (list.get(count).contains(num)) {
            return count;
        } else if (count == maxCount)
            return -1;

        return dp(list, count + 1);

    }
}
