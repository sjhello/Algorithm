package baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
* 출발점이 2개 있는 경우
* 불!
* 조건이 많이 있는 경우 조건을 나누어 작성할 것
* */
public class Main_4179 {
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int r;
	static int c;
	static char[][] board;
	static int[][] fireDis;		// 불
	static int[][] humanDis;	// 지훈이

	static class Pointer {
		int x;
		int y;

		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs() {
		Queue<Pointer> humanQueue = new LinkedList<>();
		Queue<Pointer> fireQueue = new LinkedList<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (board[i][j] == 'J') {
					humanDis[i][j] = 1;		// 최초 지훈이 위치
					humanQueue.offer(new Pointer(i, j));
				}

				if (board[i][j] == 'F') {
					fireDis[i][j] = 1;		// 최초 불의 위치
					fireQueue.offer(new Pointer(i, j));
				}
			}
		}

		/*
		* 불 먼저 이동 후
		* 지훈이가 이동하려는 방향의 시간이 불의 이동 시간보다 적으면 이동가능, 불의 이동 시간이 빠르다면 지훈이는 이동 불가능 
		* */
		while (!fireQueue.isEmpty()) {
			Pointer current = fireQueue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx < r && ny < c && nx >= 0 && ny >= 0 && board[nx][ny] != '#' && fireDis[nx][ny] == 0) {
					fireQueue.offer(new Pointer(nx, ny));
					fireDis[nx][ny] = fireDis[current.x][current.y] + 1;
				}
			}
		}

		// 지훈이 BFS
		while (!humanQueue.isEmpty()) {
			Pointer current = humanQueue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= r || ny >= c) {
					System.out.println(humanDis[current.x][current.y]);
					return;
				}

				// if (nx < r && ny < c && nx >= 0 && ny >= 0 && board[nx][ny] != '#' && humanDis[nx][ny] == 0 && fireDis[nx][ny] >= humanDis[current.x][current.y] + 1) {
				// 	humanQueue.offer(new Pointer(nx, ny));
				// 	humanDis[nx][ny] = humanDis[current.x][current.y] + 1;
				// }

				if (board[nx][ny] == '#' || humanDis[nx][ny] >= 1) continue;
				if (fireDis[nx][ny] != 0 && fireDis[nx][ny] <= humanDis[current.x][current.y] + 1) continue;

				humanDis[nx][ny] = humanDis[current.x][current.y] + 1;
				humanQueue.offer(new Pointer(nx, ny));
			}
		}
		System.out.println("IMPOSSIBLE");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());		// 행
		c = Integer.parseInt(st.nextToken());		// 열
		board = new char[r][c];
		humanDis = new int[r][c];
		fireDis = new int[r][c];

		for (int i = 0; i < r; i++) {
			String str = br.readLine();
			for (int j = 0; j < c; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		bfs();
	}
}
