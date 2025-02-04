import java.util.*;

class Solution {
    public static int num, power;
    public static int[][] dungeon;

    public int solution(int k, int[][] dungeons) {
        num = dungeons.length;
        power = k;
        boolean[] whetherput = new boolean[dungeons.length];
        List<Integer> arr = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        dungeon = dungeons;
        permute(arr, res, whetherput);
        Collections.sort(res, Collections.reverseOrder());

        return res.get(0);
    }

    public static void permute(List<Integer> arr, List<Integer> res, boolean[] whetherput) {
        if (arr.size() == num) {

            int temppower = power;
            int num = 0;
            for (int i : arr) {
                if (temppower >= dungeon[i][0]) {
                    temppower -= dungeon[i][1];
                    num++;
                } else {

                    break;
                }
            }
            res.add(num);
            return;
        }

        for (int i = 0; i < num; i++) {
            if (whetherput[i] == false) {
                whetherput[i] = true;
                arr.add(i);
                permute(arr, res, whetherput);
                arr.remove(Integer.valueOf(i));
                whetherput[i] = false;
            }

        }
    }
}

import java.util.*;

class Solution {
    public static int[][] dungeon;
    public static int maxnum;

    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[] whetherput = new boolean[dungeons.length];
        dungeon = dungeons;
        permute(k, 0, whetherput);

        return maxnum;
    }

    public static void permute(int power, int count, boolean[] whetherput) {
        if (count > maxnum) {
            maxnum = count;
        }

        for (int i = 0; i < dungeon.length; i++) {
            if (whetherput[i] == false && power >= dungeon[i][0]) {
                whetherput[i] = true;
                permute(power - dungeon[i][1], count + 1, whetherput);
                whetherput[i] = false;
            }
        }
        return;
    }
}

import java.util.*;

class Solution {
    public int solution(int k, int[][] dungeons) {
        int maxnum = 0; // 최대 던전 탐험 수 초기화
        boolean[] whetherput = new boolean[dungeons.length];

        // DFS 탐색 시작
        maxnum = permute(k, 0, dungeons, whetherput);
        return maxnum;
    }

    public int permute(int power, int count, int[][] dungeon, boolean[] whetherput) {
        int maxnum = count;

        for (int i = 0; i < dungeon.length; i++) {
            if (!whetherput[i] && power >= dungeon[i][0]) {
                whetherput[i] = true; // 던전 방문
                maxnum = Math.max(maxnum, permute(power - dungeon[i][1], count + 1, dungeon, whetherput));
                whetherput[i] = false; // 방문 해제
            }
        }

        return maxnum;
    }
}