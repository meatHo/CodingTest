class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                res++;
            } else {
                res--;
            }
            if (res < 0) {
                return false;
            }
        }
        if (res != 0) {
            return false;
        }

        return true;
    }
}