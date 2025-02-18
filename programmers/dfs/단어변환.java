import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        return bfs(begin, target, words);
    }

    public boolean diff(String begin, String str) {
        int differ = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) != str.charAt(i)) {
                differ++;
            }
        }
        return differ == 1;
    }

    public int bfs(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<String> q = new LinkedList<>();
        Queue<Integer> qC = new LinkedList<>();

        q.add(begin);
        qC.add(0);

        while (!q.isEmpty()) {
            String cur = q.poll();
            int count = qC.poll();

            if (cur.equals(target)) {
                return count;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && diff(cur, words[i])) {
                    visited[i] = true;
                    q.add(words[i]);
                    qC.add(count + 1);
                }
            }
        }

        return 0;
    }
}
