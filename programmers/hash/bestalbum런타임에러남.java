
//런타임 에러남
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // int[] answer = {};
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            // map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            map.putIfAbsent(genres[i], new HashMap<>());
            // map.get(genres[i]).put(i, plays[i]);
            map.get(genres[i]).put(i, plays[i]);
        }
        // get으로 하나 math max로 가장 큰거 가져오고 배열에 저장하고 map에서 가장 큰거 삭제 후 다시 진행

        HashMap<Integer, String> totalSum = new HashMap<>();
        for (String s : map.keySet()) {
            totalSum.put(map.get(s).values().stream().mapToInt(Integer::intValue).sum(), s);
        }

        ArrayList<Integer> sumList = new ArrayList<>(totalSum.keySet());
        Collections.sort(sumList);
        Collections.reverse(sumList);

        ArrayList<Integer> res = new ArrayList<>();

        for (Integer i : sumList) {
            // ArrayList<Integer> last = new
            // ArrayList<>(map.get(totalSum.get(i)).values());// map의 중첩 해시맵 나옴
            List<Integer> good = new ArrayList<>(map.get(totalSum.get(i)).keySet());
            good.sort((o1, o2) -> map.get(totalSum.get(i)).get(o2).compareTo(map.get(totalSum.get(i)).get(o1)));
            for (int a = 0; a < 2; a++) {
                res.add(good.get(a));
            }

        }

        int[] arr = res.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }
}