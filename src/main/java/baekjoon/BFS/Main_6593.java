package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 상범 빌딩
* 3차원
* 입력 구현
* BFS
* */
public class Main_6593 {
	static int[] dx = {1, 0, -1, 0, 0, 0};		// 행
	static int[] dy = {0, 1, 0, -1, 0, 0};		// 열
	static int[] dz = {0, 0, 0, 0, 1, -1};		// 면
	static int l;		// 층
	static int r;		// 행
	static int c;		// 열
	static char[][][] board;
	static int[][][] dis;
	static Queue<Pointer> queue;
	static StringBuilder sb = new StringBuilder();

	static class Pointer {
		int l;
		int r;
		int c;

		public Pointer(int l, int r, int c) {
			this.l = l;
			this.r = r;
			this.c = c;
		}
	}

	public static void bfs() {
		while (!queue.isEmpty()) {
			Pointer current = queue.poll();

			for (int i = 0; i < 6; i++) {
				int nz = current.l + dz[i];
				int nx = current.r + dx[i];
				int ny = current.c + dy[i];

				if (board[current.l][current.r][current.c] == 'E') {
					sb.append("Escaped in ").append(dis[current.l][current.r][current.c]).append(" minute(s).\n");
					return;
				}

				if (nx >= 0 && ny >= 0 && nz >= 0 && nx < r && ny < c && nz < l && board[nz][nx][ny] != '#' && dis[nz][nx][ny] == 0) {
					queue.offer(new Pointer(nz, nx, ny));
					dis[nz][nx][ny] = dis[current.l][current.r][current.c] + 1;
				}
			}
		}

		sb.append("Trapped!\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if (l == 0 && r == 0 && c == 0) {
				System.out.println(sb.toString());
				return ;	// 종료
			}

			board = new char[l][r][c];
			dis = new int[l][r][c];
			queue = new LinkedList<>();

			for (int i = 0; i < l; i++) {
				for (int j = 0; j < r; j++) {
					String str = br.readLine();
					for (int k = 0; k < c; k++) {
						board[i][j][k] = str.charAt(k);
						if (board[i][j][k] == 'S') {
							queue.offer(new Pointer(i, j, k));
						}
					}
				}
				br.readLine();	// 개행문자 구분
			}

			bfs();
		}
	}
}
