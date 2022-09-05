package inflearn;

import java.util.*;

/*
* 섬나라 아일랜드
* */
public class Problem8_13_BFS {
    static int n;
    static int[][] board;
    static int[] dx = {1, 1, 1, 0, 0, -1, -1, -1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int answer;

    static class Pointer {
        int x;
        int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int x, int y, int[][] board) {
        Queue<Pointer> queue = new LinkedList<>();
        queue.offer(new Pointer(x, y));

        while(!queue.isEmpty()) {
            Pointer current = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if (nx >= 1 && ny >= 1 && nx <= n && ny <= n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.offer(new Pointer(nx, ny));
                }
            }
        }
    }

    public static void landToSea(int[][] board) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    BFS(i, j, board);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        landToSea(board);
        System.out.println(answer);
    }
}
