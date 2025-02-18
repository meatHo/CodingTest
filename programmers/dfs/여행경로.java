import java.util.*;

class Solution {
    boolean[] visited;
    List<String> res;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        res = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs("ICN", tickets, 0);
        res.add("ICN");
        Collections.reverse(res);
        return res.stream().toArray(String[]::new);
    }

    boolean dfs(String begin, String[][] tickets, int count) {
        if (count == tickets.length) {
            return true;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(begin) && !visited[i]) {
                visited[i] = true;
                if (dfs(tickets[i][1], tickets, count + 1)) {
                    System.out.println(tickets[i][1]);
                    res.add(tickets[i][1]);
                    return true;
                }
                visited[i] = false;

            }
        }
        return false;
    }
}