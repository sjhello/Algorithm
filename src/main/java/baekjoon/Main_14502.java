package baekjoon;

import java.io.*;
import java.util.*;

public class Main_14502 {
    static int n;
    static int m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] board;
    static int[][] visited;
    static int answer = Integer.MIN_VALUE;

    static class Pointer {
        int x;
        int y;

        public Pointer(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void getSafeZone(int[][] boardCopy) {
        int safeZone = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (boardCopy[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        answer = Math.max(safeZone, answer);
    }

    public static void dfs(int wall) {
        if (wall == 3) {
            Main_14502.bfs();
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1;
                        Main_14502.dfs(wall + 1);
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void bfs() {
        Queue<Pointer> queue = new LinkedList<>();

        // 벽 세우고 나서 바이러스 갯수 체크
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    queue.add(new Pointer(i, j));
                }
            }
        }

        /*
        * 주의
        * 2차원 배열 copy 시 원소안의 배열까지 clone 해야함
        * */
        int[][] boardCopy = board.clone();
        for (int i = 0; i < n; i++) {
            boardCopy[i] = board[i].clone();
        }

        // 벽이 세워진 상태에서 복사한 배열을 바이러스 전파
        // 원본 배열 변경하면 최대값 못구함
        while (!queue.isEmpty()) {
            Pointer current = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && boardCopy[nx][ny] == 0) {
                    queue.add(new Pointer(nx, ny));
                    boardCopy[nx][ny] = 2;
                }
            }
        }

        Main_14502.getSafeZone(boardCopy);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new int[n][m];
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Main_14502.dfs(0);
        System.out.println(answer);
    }
}
