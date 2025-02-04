import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> allkind = new HashSet<>();
        permute("", numbers, allkind);
        numbers.length();
        Set<Integer> res = new HashSet<>();
        int status = 0;
        for (int num : allkind) {
            if (num < 2) {
                continue;
            }
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    status = 1;
                    break;
                }
            }
            if (status == 0) {
                res.add(num);
            }
            status = 0;
        }

        return res.size();
    }

    public static void permute(String prefix, String remain, Set<Integer> allkind) {
        if (!prefix.isEmpty()) {
            allkind.add(Integer.parseInt(prefix));
        }
        for (int i = 0; i < remain.length(); i++) {
            String newprefix = prefix + remain.charAt(i);
            String newremain = remain.substring(0, i) + remain.substring(i + 1);
            permute(newprefix, newremain, allkind);
        }
    }
}