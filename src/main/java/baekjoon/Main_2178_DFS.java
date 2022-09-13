package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2178_DFS {
	static int n;
	static int m;
	static int[][] board;
	static int[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {1, -1, 0, 0};
	static int answer = Integer.MAX_VALUE;
	static int area = 0;

	public static void DFS(int x, int y) {
		area++;

		if (x == n -1 && y == m - 1) {
			answer = Integer.min(answer, area);
			return ;
		} else {
			for (int i = 0; i < dx.length; i++) {
				int nx = dx[i] + x;
				int ny = dy[i] + y;

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 1 && visited[nx][ny] == 0) {
					visited[nx][ny] = 1;
					DFS(nx, ny);
					visited[nx][ny] = 0;
					area--;
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
		visited = new int[n][m];

		for (int i = 0; i < n; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(split[j]);
			}
		}

		visited[0][0] = 1;
		Main_2178_DFS.DFS(0, 0);
		System.out.println(answer);
	}
}
