package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2178 {
    static int n;
    static int m;
    static int[][] board;
    static int[][] dis;
    static int[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Pointer {
        int x;
        int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(Pointer pointer) {
        Queue<Pointer> queue = new LinkedList<>();
        queue.offer(pointer);
        visited[pointer.x][pointer.y] = 1;

        while(!queue.isEmpty()) {
            Pointer current = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == 0 && board[nx][ny] == 1) {
                    visited[nx][ny] = 1;
                    queue.offer(new Pointer(nx, ny));
                    dis[nx][ny] = dis[current.x][current.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        dis = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(split[j]);
            }
        }

        dis[0][0] = 1;
        Main_2178.BFS(new Pointer(0, 0));
        System.out.println(dis[n - 1][m - 1]);
    }
}
