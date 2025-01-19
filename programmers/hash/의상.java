import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> cloth = new HashMap<>();

        for (String[] s : clothes) {
            cloth.put(s[1], cloth.getOrDefault(s[1], 0) + 1);// put 덮어쓰기 가능
        }

        for (String s : cloth.keySet()) {
            answer = answer * (cloth.get(s) + 1);
        }

        return answer - 1;
    }
}