class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int removed = 0;

        for (int i = 1; i < sb.length(); i++) {
            char temp = sb.charAt(i);
            if (i > 0 && sb.charAt(i - 1) < temp) {
                sb.deleteCharAt(i - 1);
                removed++;
                i -= 2;
                if (i < 0)
                    i = -1;
            }
            if (removed == k) {
                return sb.toString();
            }
        }

        while (removed < k) {
            sb.deleteCharAt(sb.length() - 1);
            removed++;
        }

        return sb.toString();
    }
}

import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}

import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        // stringbuilder랑 stack 써서 해봐
        int len = number.length() - k;
        Stack<Character> stack = new Stack<>();
        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && stack.peek() < c && k > 0) {
                k--;
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            // 스택 맨 마지막 것이 k남은 것보다 크거나 같다라는 뜻이므로 없앰
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
// 9876543213 3