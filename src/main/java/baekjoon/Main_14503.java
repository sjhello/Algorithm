package baekjoon;

import java.util.*;
import java.io.*;

public class Main_14503 {
    static int n;
    static int m;
    static int r;
    static int c;
    static int direction;       // 0: 북, 1: 동, 2: 남, 3: 서
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};    // 북서남동
    static int[] dy = {0, -1, 0, 1};
    static Queue<Pointer> queue;
    static int answer;

    static class Pointer {
        int x;
        int y;
        int c;

        public Pointer(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }

    public static void bfs(Pointer pointer) {
        boolean flag = true;
        queue.offer(pointer);

        while (flag) {
            Pointer current = queue.poll();

            if (board[current.x][current.y] == 0) {
                board[current.x][current.y] = 2;
                answer++;
            }

            if (Main_14503.isMoveable(current)) {
                flag = true;
            } else {
                flag = false;
            }
        }
    }

    public static boolean isMoveable(Pointer pointer) {
        int nx = 0;
        int ny = 0;
        int ndir = 0;

        // 네 방향 체크
        for (int i = 1; i <= 4; i++) {
            ndir = (pointer.c + i) % 4;
            nx = pointer.x + dx[ndir];
            ny = pointer.y + dy[ndir];

            // 현재 방향 기준 왼쪽방향이 벽이거나 청소한 곳이라면 왼쪽방향으로 방향을 튼다
            if (board[nx][ny] > 0) {
                continue;
            }

            // 현재 방향 기준 왼쪽방향이 청소되지않았다면 이동
            if (board[nx][ny] == 0) {
                queue.offer(new Pointer(nx, ny, ndir));
                return true;
            }
        }

        // 네 방향 확인 했는데 다 청소된 경우 혹은 벽인 경우 후진한다
        nx = pointer.x - dx[pointer.c];
        ny = pointer.y - dy[pointer.c];

        // 후진 하려는 방향이 벽인 경우 종료
        if (board[nx][ny] == 1) {
            return false;
        } else if (Main_14503.isMoveable(new Pointer(nx, ny, pointer.c))) { // 후진한 방향이 벽이 아닌 경우
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        queue = new LinkedList<>();

        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (direction == 1) direction = 3;
        else if(direction == 3) direction = 1;

        Main_14503.bfs(new Pointer(r, c, direction));
        System.out.println(answer);
    }
}
