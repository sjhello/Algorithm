package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2210 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static String[][] board;
    static ArrayList<String> list;

    public static void DFS(int x, int y, int level, String number) {
        if (level == 5) {   // 가지수가 6자리 이다 때문에 재귀를 돌며 넘어온 number를 5 level에서 확인하여 없으면 list에 집어넣는다
            if (!list.contains(number)) {
                list.add(number);
            }
        } else {
            for (int i = 0; i < dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {   // 한번 거쳤던 칸을 다시 거쳐도 되기 때문에 visited 처리 하지 않는다
                    DFS(nx, ny, level + 1, number + board[nx][ny]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new String[5][5];
        list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = st.nextToken();
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {    // 모든 정점에 대해서 인접해있는 네 방향으로 다섯번 이동한다
                Main_2210.DFS(i, j, 0, board[i][j]);
            }
        }

        System.out.println(list.size());
    }
}
