import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {

        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i : arr) {
            if (stack.peek() != i) {
                stack.push(i);
            }
        }
        List<Integer> res = new ArrayList<>();

        for (int i = stack.size() - 1; i >= 0; i--) {
            res.add(stack.pop());
        }
        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        int preNum = 10;
        for (int num : arr) {
            if (preNum != num)
                tempList.add(num);
            preNum = num;
        }
        // int[] answer = new int[tempList.size()];
        // for (int i = 0; i < answer.length; i++) {
        // answer[i] = tempList.get(i).intValue();
        // }
        return tempList.stream().mapToInt(Integer::intValue).toArray();
    }
}