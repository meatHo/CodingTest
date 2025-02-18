class Solution {
    private boolean[][] water;
    private int[][] dpRes;
    private int res;

    public int solution(int m, int n, int[][] puddles) {
        res = 0;
        water = new boolean[m + 1][n + 1];
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];
            water[x][y] = true;
        }
        dpRes = new int[m + 1][n + 1];

        // 0,0 -> m-1, n-1
        // 재귀 써서 오른쪽 탐색, 밑에 탐색후 리턴 하는 방법 어떰?
        dp(m, n, 1, 1);

        return res % 1000000007;
    }

    public void dp(int m, int n, int x, int y) {
        if (dpRes[x][y] != 0) {
            res += dpRes[x][y];
            return;
        }
        if (x == m && y == n) {
            res++;
            return;
        }
        int noright = 0;
        int nodown = 0;
        // 지도 끝 체크
        if (x == m)
            nodown = 1;
        if (y == n)
            noright = 1;

        // 물웅덩이 체크
        if (noright == 0 && water[x][y + 1])
            noright = 1;
        if (nodown == 0 && water[x + 1][y])
            nodown = 1;

        if (noright != 1) {
            dp(m, n, x, y + 1);
        }
        if (nodown != 1) {
            dp(m, n, x + 1, y);
        }

        if (noright == 1 && nodown == 1) {
            return;
        }

    }
}

class Solution {
    private boolean[][] water;
    private int[][] dpRes;
    private int res;

    public int solution(int m, int n, int[][] puddles) {
        res = 0;
        water = new boolean[m + 1][n + 1];
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];
            water[x][y] = true;
        }
        dpRes = new int[m + 1][n + 1];
        return dp(m, n, 1, 1);
    }

    public int dp(int m, int n, int x, int y) {
        // 도착
        if (m == x && n == y) {
            return 1;
        }

        if (x > m || y > n || water[x][y]) {
            return 0;
        }

        if (dpRes[x][y] != 0) {
            return dpRes[x][y];
        }

        return dpRes[x][y] = (dp(m, n, x + 1, y) + dp(m, n, x, y + 1)) % 1000000007;

    }
}