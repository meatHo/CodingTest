class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] result = new int[len];

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                result[i]++;
                if (prices[i] > prices[j]) { // 가격이 떨어지는 시점 발견
                    break;
                }
            }
        }

        return result;
    }
}