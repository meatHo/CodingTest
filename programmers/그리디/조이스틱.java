class Solution {
    public int solution(String name) {
        int answer = 0; // 조이스틱 조작 횟수
        int len = name.length();
        int move = name.length() - 1; // 기본 최소 좌우이동 횟수 (좌, 우 커서)

        // 해당 커서 알파벳 변경 최솟값 (위, 아래 커서)
        for (int i = 0; i < len; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            // 연속된 'A'가 끝나는 지점 찾기
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }

            // 좌우이동 최소 횟수 구하기 (순서대로 가기 vs 뒤로 돌아가기)
            move = Math.min(move, (i * 2) + len - next);
            move = Math.min(move, (len - next) * 2 + i);
        }
        answer += move;

        return answer;
    }
}
// AAAAAA
// JAANAA
// BBAABA

class Solution {
    public int solution(String name) {
        int res = 0;

        int len = name.length();
        int move = len - 1;
        for (int i = 0; i < len; i++) {
            res = res + Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int next = i + 1;
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            int back = len - next;
            move = Math.min(move, Math.min(2 * i + back, 2 * back + i));
            // min = Math.min(min, i + length - next + Math.min(i, length - next));
        }

        return move + res;
    }
}

class Solution {
    public int solution(String name) {
        int res = 0;
        int len = name.length();
        char[] na = new char[len];
        for (int i = 0; i < len; i++) {
            na[i] = name.charAt(i);
        }

        int i = 0;
        int left = 0, right = 0;
        int before = -100;
        while (true) {
            before = i;
            res = res + Math.min(na[i] - 'A', 'Z' - na[i]);
            na[i] = 'A';

            // 반복문 써서 left right 작은거 찾은 다음 그거를 다음 i와 left, right로 설정
            for (int k = 0; k < len; k++) {
                if (left - 1 == -1)
                    left = len - 1;
                else
                    left = left - 1;

                right = (right + 1) % len;

                if (na[left] != 'A' || na[right] != 'A') {
                    break;
                }
            }
            if (left == right) {
                break;
            }
            i = Math.min(left, right);
            res += i;
            left = i;
            right = i;
        }
        return res;
    }
}