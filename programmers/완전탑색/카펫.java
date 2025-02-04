class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int a = 1; a <= yellow; a++) {
            for (int b = a; b <= yellow; b++) {
                if (a * b == yellow && (b + 2) * (a + 2) == brown + yellow) {
                    return new int[] { b + 2, a + 2 };
                }
            }
        }
        return answer;
    }
}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int a = 1; a <= yellow; a++) {
            if (yellow % a == 0 && (a + 2) * (yellow / a + 2) == brown + yellow) {
                return new int[] { yellow / a + 2, a + 2 };
            }
        }
        return answer;
    }
}