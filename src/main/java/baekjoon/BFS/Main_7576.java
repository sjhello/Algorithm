package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 시작점이 여러개
* 거리 측정 활용
* 토마토
* */
public class Main_7576 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int result;	// 토마토가 모두 익을 때까지의 최소 날짜
	static int[][] board;
	static int[][] dis;
	static int n;
	static int m;

	static class Pointer {
		int x;
		int y;

		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs() {
		Queue<Pointer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 1) {
					queue.offer(new Pointer(i, j));
				}
			}
		}

		while (!queue.isEmpty()) {
			Pointer current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 0) {
					queue.offer(new Pointer(nx, ny));
					board[nx][ny] = 1;
					dis[nx][ny] = dis[current.x][current.y] + 1;
				}
			}
		}
	}

	public static void printResult() {
		/*
		* 저장될 때 부터 다 익어있는 상태이면 0
		* 모두 익지 못하는 상황이면 -1
		* */

		boolean flag = true;		// 다 익었는지?

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 0) {
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					result = Math.max(result, dis[i][j]);
				}
			}
			System.out.println(result);
		} else {
			System.out.println(-1);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		dis = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				/*
				* 0 : 안익은 토마토
				* 1 : 익은 토마토
				* -1: 토마토가 없는 칸 
				* */
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs();
		printResult();
	}
}
