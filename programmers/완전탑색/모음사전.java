import java.util.*;

class Solution {
    public int solution(String word) {

        int res = 0;

        List<String> dic = new ArrayList<>();
        permute("A", dic);
        permute("E", dic);
        permute("I", dic);
        permute("O", dic);
        permute("U", dic);

        return dic.indexOf(word) + 1;
    }

    public void permute(String word, List<String> dic) {
        if (word.length() > 5)
            return;
        dic.add(word);
        for (char c : new char[] { 'A', 'E', 'I', 'O', 'U' }) {
            permute(word + c, dic);
        }
        return;
    }
}

import java.util.*;

class Solution {
    public int solution(String word) {

        List<String> dic = new ArrayList<>();
        permute("", dic);

        return dic.indexOf(word);
    }

    public void permute(String word, List<String> dic) {
        if (word.length() > 5)
            return;
        dic.add(word);
        for (char c : new char[] { 'A', 'E', 'I', 'O', 'U' }) {
            permute(word + c, dic);
        }
        return;
    }
}