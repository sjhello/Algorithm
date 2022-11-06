package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 그림
* */
public class Main_1926 {
	static int count;		// 그림의 갯수
	static int resultArea;	// 가장 넓은 그림의 넓이
	static int n;
	static int m;
	static boolean[][] visited;
	static int[][] board;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	static class Pointer {
		int x;
		int y;

		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs(Pointer pointer) {
		Queue<Pointer> queue = new LinkedList<>();
		visited[pointer.x][pointer.y] = true;
		queue.offer(pointer);

		int area = 1;
		while (!queue.isEmpty()) {
			Pointer current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx < n && ny < m && nx >= 0 && ny >= 0 && !visited[nx][ny] && board[nx][ny] == 1) {
					area++;
					visited[nx][ny] = true;
					queue.offer(new Pointer(nx, ny));
				}
			}
		}

		resultArea = Math.max(resultArea, area);
		count++;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1 && !visited[i][j]) {
					bfs(new Pointer(i, j));
				}
			}
		}

		System.out.println(count);
		System.out.println(resultArea);
	}
}
