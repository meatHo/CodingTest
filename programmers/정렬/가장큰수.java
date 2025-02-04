import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        boolean status = true;
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> (b + a).compareTo(a + b));
        for (int i : numbers) {
            pq.add(Integer.toString(i));
        }
        while (!pq.isEmpty()) {
            String temp = pq.poll();
            answer = answer + temp;
            // if(Integer.parseInt(temp) != 0){
            // status = false;
            // }
        }
        // if(status){
        // return "0";
        // }

        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) != '0') {
                status = false;
            }
        }
        if (status) {
            return "0";
        }

        return answer;
    }
}

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] temp = new String[numbers.length];
        String answer = "";
        String tmp;
        // 배열을 int -> string으로 변경
        for (int i = 0; i < numbers.length; i++) {
            temp[i] = "" + numbers[i];
        }
        Arrays.sort(temp, (a, b) -> (b + a).compareTo(a + b));
        if (temp[0].equals("0"))
            return "0";
        for (int i = 0; i < temp.length; i++) {
            answer += temp[i];
        }
        return answer;
    }
}