import java.util.*;

class Solution {
    int[][] nodes;

    public int solution(int[][] maps) {
        nodes = maps;

        // bfs함수 만들어서 now(x,y)
        return bfs();
    }

    public int bfs() {
        // now에 있는거 찾은다음 상하좌우 다 큐에 넣고 before인거 빼버린다음 반복문 bfs
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, 0, 1 });

        int Y = nodes.length;
        int X = nodes[0].length;
        boolean[][] visited = new boolean[Y][X];

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            int curY = cur[0];
            int curX = cur[1];
            int distance = cur[2];

            if (curY == Y - 1 && curX == X - 1) {
                return distance;
            }
            // 상하좌우 확인 후 큐에 집어넣어
            // if(curY!=0&&nodes[curY-1][curX]==1&&!visited[curY-1][curX]){
            // q.add(new int[] {curY-1,curX,distance+1});
            // visited[curY-1][curX]=true;
            // System.out.println(curX+""+curY+""+distance);
            // }
            // if(curY!=Y&&nodes[curY+1][curX]==1&&!visited[curY+1][curX]){
            // q.add(new int[] {curY+1,curX,distance+1});
            // visited[curY+1][curX]=true;
            // System.out.println(curX+""+curY+""+distance);
            // }
            // if(curX!=0&&nodes[curY][curX-1]==1&&!visited[curY][curX-1]){
            // q.add(new int[] {curY,curX-1,distance+1});
            // visited[curY][curX-1]=true;
            // System.out.println(curX+""+curY+""+distance);
            // }
            // if(curX!=X&&nodes[curY][curX+1]==1&&!visited[curY][curX+1]){
            // q.add(new int[] {curY,curX+1,distance+1});
            // visited[curY][curX+1]=true;
            // System.out.println(curX+""+curY+""+distance);
            // }
            int[] plusX = { 0, 0, 1, -1 };
            int[] plusY = { 1, -1, 0, 0 };

            for (int i = 0; i < 4; i++) {
                int newX = curX + plusX[i];
                int newY = curY + plusY[i];
                if (newX < X && -1 < newX && newY < Y && -1 < newY && nodes[newY][newX] == 1 && !visited[newY][newX]) {
                    visited[newY][newX] = true;
                    q.add(new int[] { newY, newX, distance + 1 });
                }
            }

        }
        return -1;

    }
}