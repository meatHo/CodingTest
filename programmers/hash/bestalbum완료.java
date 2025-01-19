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
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
            pq.addAll(map.get(totalSum.get(i)).entrySet());
            if (!pq.isEmpty()) {
                res.add(pq.poll().getKey());
            }
            if (!pq.isEmpty()) {
                res.add(pq.poll().getKey());
            }

        }

        int[] arr = res.stream().mapToInt(Integer::intValue).toArray();

        return arr;
    }
}

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수를 저장
        HashMap<String, Integer> totalPlays = new HashMap<>();
        // 장르별 곡 리스트 (재생 횟수와 인덱스 저장)
        HashMap<String, ArrayList<int[]>> genreMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            totalPlays.put(genres[i], totalPlays.getOrDefault(genres[i], 0) + plays[i]);
            genreMap.putIfAbsent(genres[i], new ArrayList<>());
            genreMap.get(genres[i]).add(new int[] { plays[i], i });
        }

        // 장르별 총 재생 횟수로 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(totalPlays.keySet());
        sortedGenres.sort((a, b) -> totalPlays.get(b) - totalPlays.get(a));

        // 결과 저장
        ArrayList<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            // 해당 장르의 곡들을 재생 횟수 -> 인덱스 순으로 정렬
            ArrayList<int[]> songs = genreMap.get(genre);
            songs.sort((a, b) -> b[0] - a[0]); // 재생 횟수 내림차순
            // 최대 2곡 추가
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                result.add(songs.get(i)[1]); // 인덱스 추가
            }
        }

        // 결과를 int[]로 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 곡 정보를 저장하는 해시맵
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();

        // 1. map 초기화: 장르별로 곡의 정보(재생 횟수, 인덱스) 저장
        for (int i = 0; i < plays.length; i++) {
            map.putIfAbsent(genres[i], new HashMap<>());
            map.get(genres[i]).put(i, plays[i]); // (곡 인덱스, 재생 횟수) 저장
        }

        // 2. 장르별 총 재생 횟수를 계산
        HashMap<String, Integer> totalPlays = new HashMap<>();
        for (String genre : map.keySet()) {
            int sum = map.get(genre).values().stream().mapToInt(Integer::intValue).sum();
            totalPlays.put(genre, sum);
        }

        // 3. 장르를 총 재생 횟수 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(totalPlays.keySet());
        sortedGenres.sort((a, b) -> totalPlays.get(b) - totalPlays.get(a)); // 내림차순 정렬

        // 4. 각 장르에서 최대 2곡씩 뽑기
        ArrayList<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            // 현재 장르의 곡들을 재생 횟수 기준으로 정렬
            List<Map.Entry<Integer, Integer>> songs = new ArrayList<>(map.get(genre).entrySet());
            songs.sort((a, b) -> b.getValue() - a.getValue()); // 재생 횟수 내림차순

            // 최대 2곡 선택
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                result.add(songs.get(i).getKey()); // 곡의 인덱스 추가
            }
        }

        // 결과를 배열로 변환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}

// 마지막
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            map.putIfAbsent(genres[i], new HashMap<>());
            map.get(genres[i]).put(i, plays[i]);
        }

        HashMap<String, Integer> totalSum = new HashMap<>();// 총합
        for (String s : map.keySet()) {
            HashMap<Integer, Integer> temp = new HashMap<>(map.get(s));
            totalSum.put(s, temp.values().stream().mapToInt(Integer::intValue).sum());
        }

        List<String> sortedGenres = new ArrayList<>(totalSum.keySet());
        sortedGenres.sort((a, b) -> totalSum.get(b) - totalSum.get(a));

        ArrayList<Integer> res = new ArrayList<>();
        for (String s : sortedGenres) {
            HashMap<Integer, Integer> temp = new HashMap<>(map.get(s));
            List<Integer> sortedSongs = new ArrayList<>(temp.keySet());
            sortedSongs.sort((a, b) -> temp.get(b) - temp.get(a));

            for (int i = 0; i < Math.min(2, sortedSongs.size()); i++) {
                res.add(sortedSongs.get(i));
            }
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}