package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 시작점이 여러개인 경우
* 토마토(3차원)
* */
public class Main_7569 {
	static int n;
	static int m;
	static int h;
	static int[][][] board;
	static int[][][] dis;
	//
	static int[] dx = {1, 0, -1, 0, 0, 0};
	static int[] dy = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	//
	static Queue<Pointer> queue = new LinkedList<>();
	static int result;

	static class Pointer {
		int z;
		int x;
		int y;

		public Pointer(int z, int x, int y) {
			this.z = z;
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Pointer current = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nz = current.z + dz[i];
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				//
				if (nz >= 0 && nx >= 0 && ny >= 0 && nz < h && nx < m && ny < n) {
					if (board[nz][nx][ny] == 0) {
						queue.offer(new Pointer(nz, nx, ny));
						board[nz][nx][ny] = 1;
						dis[nz][nx][ny] = dis[current.z][current.x][current.y] + 1;
					}
				}
			}
		}
	}

	public static void printResult() {
		boolean flag = true;		// 다 익었는지?

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k < n; k++) {
					if (board[i][j][k] == 0) {
						flag = false;
						break;
					}
				}
			}
		}

		if (flag) {
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < m; j++) {
					for (int k = 0; k < n; k++) {
						result = Math.max(result, dis[i][j][k]);
					}
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
		n = Integer.parseInt(st.nextToken());		// 가로
		m = Integer.parseInt(st.nextToken());		// 세로
		h = Integer.parseInt(st.nextToken());
		board = new int[h][m][n];
		dis = new int[h][m][n];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < n; k++) {
					board[i][j][k] = Integer.parseInt(st.nextToken());

					if (board[i][j][k] == 1) {
						queue.offer(new Pointer(i, j, k));
					}
				}
			}
		}

		bfs();
		printResult();
	}
}
