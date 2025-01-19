package programmers.hash;

import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        int len = nums.length / 2;
        HashSet<Integer> unique = new HashSet<>();

        for (int num : nums) {
            unique.add(num);
        }

        // 최대로 고를 수 있는 수(len)와 중복 제거된 포켓몬 수 중 작은 값을 리턴
        return Math.min(len, unique.size());
    }
}

import java.util.ArrayList;

class Solution {
    public int solution(int[] nums) {
        int len = nums.length / 2;
        int res = 0;
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (!arr.contains(nums[i])) {
                res++;
                arr.add(nums[i]);
            }
        }

        // 최대로 고를 수 있는 개수는 len과 res 중 작은 값
        return Math.min(len, res);
    }
}