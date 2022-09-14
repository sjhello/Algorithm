package baekjoon;

import java.io.*;
import java.util.*;


/*
* 단지번호붙이기(BFS)
* */
public class Main_2667_BFS {
    static int n;
    static int[][] board;
    static int[][] visited;
    static int[][] dis;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count = 0;
    static ArrayList<Integer> homeCount;

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
        queue.offer(new Pointer(pointer.x, pointer.y));
        visited[pointer.x][pointer.y] = 1;

        int home = 1;   // 단지 번호에 해당하는 집의 갯수
        count++;   // 단지 번호
        dis[pointer.x][pointer.y] = count;

        while (!queue.isEmpty()) {
            Pointer current = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;

                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if (board[nx][ny] == 1 && visited[nx][ny] == 0) {
                        queue.offer(new Pointer(nx, ny));
                        visited[nx][ny] = 1;
                        dis[nx][ny] = count;
                        home++;
                    }
                }
            }
        }

        homeCount.add(home);
    }

    public static void printAnswer() {
        Collections.sort(homeCount);

        System.out.println(homeCount.size());

        for (Integer number : homeCount) {
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new int[n][n];
        dis = new int[n][n];
        homeCount = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] number = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                board[i][j] = number[j] - 48;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1 && visited[i][j] == 0) {
                    Main_2667_BFS.BFS(new Pointer(i, j));
                }
            }
        }

        Main_2667_BFS.printAnswer();

    }
}
