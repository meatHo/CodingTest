import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // int[] answer = {};
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < plays.length; i++) {
            // map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            map.putIfAbsent(genres[i], new HashMap<>());
            // map.get(genres[i]).put(i, plays[i]);
            map.get(genres[i]).put(plays[i], i);
        }
        // get으로 하나 math max로 가장 큰거 가져오고 배열에 저장하고 map에서 가장 큰거 삭제 후 다시 진행

        HashMap<Integer, String> totalSum = new HashMap<>();
        for (String s : map.keySet()) {
            // total_sum[++i] =
            // map.get(s).values().stream().mapToInt(Integer::intValue).sum();
            // maxString[i]=s;

            totalSum.put(map.get(s).keySet().stream().mapToInt(Integer::intValue).sum(), s);
        }

        ArrayList<Integer> sumList = new ArrayList<>(totalSum.keySet());
        Collections.sort(sumList);
        Collections.reverse(sumList);

        ArrayList<Integer> res = new ArrayList<>();
        for (Integer i : sumList) {
            ArrayList<Integer> last = new ArrayList<>(map.get(totalSum.get(i)).keySet());// map의 중첩 해시맵 나옴
            // // 키의 값 높은 거 두개 출력하면 됨
            // Collections.sort(last);// 플레이수로 정렬
            // Collections.reverse(last);

            // Iterator<Integer> iter = last.iterator();
            // if (iter.hasNext()) {
            // res.add(map.get(totalSum.get(i)).get(iter.next()));
            // }
            // if (iter.hasNext()) {
            // res.add(map.get(totalSum.get(i)).get(iter.next()));
            // }

            int play = Collections.max(last);

            res.add(map.get(totalSum.get(i)).get(play));
            // last에서 현재 맥스인거 지우고 비어있는지 확인 후 다시 맥스 출력
            last.remove(Integer.valueOf(play));
            if (!last.isEmpty()) {
                res.add(map.get(totalSum.get(i)).get(Collections.max(last)));
            }

        }
        int[] arr = res.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }
}
