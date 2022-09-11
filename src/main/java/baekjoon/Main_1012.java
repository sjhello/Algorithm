package baekjoon;

import java.io.*;
import java.util.*;


/*
* 유기농 배추
* */
public class Main_1012 {
	static int t;	// 테스트케이스 갯수
	static int m;	// 가로
	static int n;	// 세로
	static int k;	// 배추가 심어져 있는 위치의 개수
	static int[][] board;
	static int[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

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
		queue.offer(pointer);
		visited[pointer.x][pointer.y] = 1;

		while (!queue.isEmpty()) {
			Pointer current = queue.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = dx[i] + current.x;
				int ny = dy[i] + current.y;

				if (nx >= 0 && ny >= 0 && nx < m && ny < n && board[nx][ny] == 1 && visited[nx][ny] == 0) {
					visited[nx][ny] = 1;
					queue.offer(new Pointer(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			board = new int[m][n];
			visited = new int[m][n];

			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				board[a][b] = 1;
			}

			int answer = 0;

			for (int j = 0; j < m; j++) {
				for (int l = 0; l < n; l++) {
					if (board[j][l] == 1 && visited[j][l] == 0) {
						Main_1012.BFS(new Pointer(j, l));
						answer++;
					}
				}
			}

			System.out.println(answer);
		}
	}
}
