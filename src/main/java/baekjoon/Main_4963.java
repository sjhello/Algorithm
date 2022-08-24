package baekjoon;

import java.util.Scanner;

public class Main_4963 {
    static int[][] map;
    static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
    static boolean[][] visited;
    static int h;
    static int w;


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();   // 가로
            h = sc.nextInt();   // 세로

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            // 지도 입력
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            int result = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && visited[i][j] == false) {
                        result++;
                        search(i, j);
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void search(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if ((nx >= 0 && ny >= 0) && (nx < h && ny < w)) {
                if (map[nx][ny] == 1 && visited[nx][ny] == false) {
//                    visited[nx][ny] = true;
                    search(nx, ny);
                }
            }
        }
    }
}
