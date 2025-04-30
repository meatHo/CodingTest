import java.util.*;
import java.io.*;

//10026
//

public class Main {
    static boolean[][] visitednormal;
    static boolean[][] visitedother;
    static char[][] arr;
    static char[][] arrother;
    static int y;
    static int x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        y = Integer.parseInt(br.readLine());

        String str = br.readLine().trim();
        x = str.length();

        arr = new char[y][x];
        arrother = new char[y][x];
        visitednormal = new boolean[y][x];
        visitedother = new boolean[y][x];
        for (int i = 0; i < x; i++) {
            char[] temp = str.toCharArray();
            arr[0][i] = temp[i];
            if (temp[i] == 'G') {
                arrother[0][i] = 'R';
            } else {
                arrother[0][i] = temp[i];
            }
        }
        for (int koh1 = 1; koh1 < y; koh1++) {
            String strtemp = br.readLine().trim();
            for (int i = 0; i < x; i++) {
                char[] temp = strtemp.toCharArray();
                arr[koh1][i] = temp[i];
                if (temp[i] == 'G') {
                    arrother[koh1][i] = 'R';
                } else {
                    arrother[koh1][i] = temp[i];
                }
            }
        }
        int numnormal = 0;
        while (true) {

            int[] checkarr = checknormal();
            if (checkarr[0] == -1) {
                break;
            }
            int cury = checkarr[0];
            int curx = checkarr[1];
            char tempcolor = arr[cury][curx];
            visitednormal[cury][curx] = true;
            dfsnormal(cury, curx, tempcolor);
            numnormal++;
        }

        int numother = 0;
        while (true) {

            int[] checkarr = checkother();
            if (checkarr[0] == -1) {
                break;
            }
            int cury = checkarr[0];
            int curx = checkarr[1];
            char tempcolor = arrother[cury][curx];
            visitedother[cury][curx] = true;
            dfsother(cury, curx, tempcolor);
            numother++;
        }
        bw.write(numnormal + " " + numother + "\n");
        bw.flush();

    }

    public static void dfsnormal(int cury, int curx, char c) {
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        for (int i = 0; i < 4; i++) {
            int ty = cury + dy[i];
            int tx = curx + dx[i];
            if (ty >= 0 && tx >= 0 && ty < y && tx < x && !visitednormal[ty][tx] && arr[ty][tx] == c) {
                visitednormal[ty][tx] = true;
                dfsnormal(ty, tx, c);
            }
        }
    }

    public static int[] checknormal() {
        for (int ty = 0; ty < y; ty++) {
            for (int tx = 0; tx < x; tx++) {
                if (!visitednormal[ty][tx]) {
                    return new int[] { ty, tx };
                }
            }
        }
        return new int[] { -1, -1 };
    }

    public static void dfsother(int cury, int curx, char c) {
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };
        for (int i = 0; i < 4; i++) {
            int ty = cury + dy[i];
            int tx = curx + dx[i];

            if (ty >= 0 && tx >= 0 && ty < y && tx < x && !visitedother[ty][tx] && arrother[ty][tx] == c) {
                visitedother[ty][tx] = true;
                dfsother(ty, tx, c);
            }
        }
    }

    public static int[] checkother() {
        for (int ty = 0; ty < y; ty++) {
            for (int tx = 0; tx < x; tx++) {
                if (!visitedother[ty][tx]) {
                    return new int[] { ty, tx };
                }
            }
        }
        return new int[] { -1, -1 };
    }

}
