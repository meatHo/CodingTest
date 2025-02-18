import java.util.*;

class Solution {
    int[][] plane = new int[102][102];

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        for (int i = 0; i < rectangle.length; i++) {// plane에 표현 전체 1로 채우기 사각형
            int x1 = rectangle[i][0] * 2, x2 = rectangle[i][2] * 2;
            int y1 = rectangle[i][1] * 2, y2 = rectangle[i][3] * 2;
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    plane[y][x] = 1;
                }
            }
        }

        for (int i = 0; i < rectangle.length; i++) {// plane에 표현 안에 0으로 비오기
            int x1 = rectangle[i][0] * 2, x2 = rectangle[i][2] * 2;
            int y1 = rectangle[i][1] * 2, y2 = rectangle[i][3] * 2;
            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    plane[y][x] = 0;
                }
            }
        }

        characterX *= 2;
        characterY *= 2;
        itemX *= 2;
        itemY *= 2;

        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { characterY, characterX, 0 });
        boolean[][] visited = new boolean[102][102];
        visited[characterY][characterX] = true;

        while (!q.isEmpty()) {

            int[] curXY = q.poll();
            int Y = curXY[0];
            int X = curXY[1];
            int dist = curXY[2];

            if (Y == itemY && X == itemX) {
                return dist / 2;
            }
            for (int i = 0; i < 4; i++) {
                int tempY = Y + dy[i];
                int tempX = X + dx[i];
                if (plane[tempY][tempX] == 1 && !visited[tempY][tempX] && tempX >= 0 && tempX < 102 && tempY >= 0
                        && tempY < 102) {
                    visited[tempY][tempX] = true;
                    q.add(new int[] { tempY, tempX, dist + 1 });
                }
            }
        }

        return 0;
    }
}