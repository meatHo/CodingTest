import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> minpq = new PriorityQueue<>((a, b) -> a - b);// 오름차순
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> b - a);// 내림차순

        Queue<Integer> temppq = new LinkedList<>();

        for (String s : operations) {
            if (s.charAt(0) == 'I') {
                String[] temp = s.split(" ");
                int tempInt = Integer.parseInt(temp[1]);
                minpq.add(tempInt);
                maxpq.add(tempInt);
            } else if (s.compareTo("D 1") == 0 && !maxpq.isEmpty()) {// 최댓값 삭제
                int temp = maxpq.poll();
                while (minpq.peek() != temp) {
                    temppq.add(minpq.poll());
                }
                minpq.poll();
                while (!temppq.isEmpty()) {
                    minpq.add(temppq.poll());
                }

            } else if (s.compareTo("D -1") == 0 && !minpq.isEmpty()) {// 최솟값 삭제
                int temp = minpq.poll();
                while (maxpq.peek() != temp) {
                    temppq.add(maxpq.poll());
                }
                maxpq.poll();
                while (!temppq.isEmpty()) {
                    maxpq.add(temppq.poll());
                }
            }
        }

        if (!minpq.isEmpty()) {
            answer[1] = minpq.poll();
        } else {
            answer[1] = 0;
        }

        if (!maxpq.isEmpty()) {
            answer[0] = maxpq.poll();
        } else {
            answer[0] = 0;
        }

        return answer;
    }
}

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minpq = new PriorityQueue<>();
        Queue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());

        for (String operation : operations) {
            if (operation.startsWith("I ")) {
                int n = Integer.parseInt(operation.substring(2));
                minpq.offer(n);
                maxpq.offer(n);
            } else if (!minpq.isEmpty() && operation.equals("D -1")) {
                maxpq.remove(minpq.poll());
            } else if (!maxpq.isEmpty() && operation.equals("D 1")) {
                minpq.remove(maxpq.poll());
            }
        }

        if (minpq.isEmpty() && maxpq.isEmpty()) {
            return new int[] { 0, 0 };
        }

        return new int[] { maxpq.poll(), minpq.poll() };
    }
}

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minpq = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> maxpq = new PriorityQueue<>((a, b) -> b - a);

        for (String s : operations) {
            if (s.charAt(0) == 'I') {
                String[] temp = s.split(" ");
                minpq.add(Integer.parseInt(temp[1]));
                maxpq.add(Integer.parseInt(temp[1]));
            } else if (s.compareTo("D 1") == 0) {
                if (!maxpq.isEmpty()) {
                    minpq.remove(maxpq.poll());
                }
            } else if (s.compareTo("D -1") == 0) {
                if (!minpq.isEmpty()) {
                    maxpq.remove(minpq.poll());
                }
            }
        }
        if (maxpq.isEmpty() && minpq.isEmpty()) {
            return new int[] { 0, 0 };
        } else {
            return new int[] { maxpq.poll(), minpq.poll() };
        }
    }
}