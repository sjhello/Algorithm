package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1189 {
    static int r;
    static int c;
    static int k;
    static int[] dy = { 1, 0, 0, -1 };           // 행
    static int[] dx = { 0, -1, 1, 0 };           // 열
    static int[][] visited;
    static char[][] board;
    static int answer;

    public static void DFS(int x, int y, int isSameK) {
        if (x == 0 && y == c - 1) {
            if (isSameK == k) {
                answer++;
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < r && ny < c && visited[nx][ny] == 0 && board[nx][ny] != 'T') {
                    visited[nx][ny] = 1;
                    DFS(nx, ny, isSameK + 1);
                    visited[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());       // 행
        c = Integer.parseInt(st.nextToken());       // 열
        k = Integer.parseInt(st.nextToken());       // 거리
        board = new char[r][c];
        visited = new int[r][c];

        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        visited[r - 1][0] = 1;
        Main_1189.DFS(r - 1, 0, 1);
        System.out.println(answer);
    }
}
