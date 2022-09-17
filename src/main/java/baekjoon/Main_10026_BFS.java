package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 적록색약
* */
public class Main_10026_BFS {
	static int n;
	static int blind;	// 적록색약
	static int eye;		// 적록색약 아닌 사람
	static char[][] eyeBoard;
	static char[][] blindeyeBoard;
	static boolean[][] blindVisited;
	static boolean[][] eyeVisited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

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
		queue.offer(pointer);
		eyeVisited[pointer.x][pointer.y] = true;

		while (!queue.isEmpty()) {
			Pointer current = queue.poll();

			for (int i = 0; i < dx.length; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && eyeVisited[nx][ny] == false && eyeBoard[nx][ny] == eyeBoard[current.x][current.y]) {
					queue.offer(new Pointer(nx, ny));
					eyeVisited[nx][ny] = true;
				}
			}
		}
	}

	public static void bfs2(Pointer pointer) {
		Queue<Pointer> queue = new LinkedList<>();
		queue.offer(pointer);
		blindVisited[pointer.x][pointer.y] = true;

		while (!queue.isEmpty()) {
			Pointer current = queue.poll();

			for (int i = 0; i < dx.length; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && blindVisited[nx][ny] == false && blindeyeBoard[nx][ny] == blindeyeBoard[current.x][current.y]) {
					queue.offer(new Pointer(nx, ny));
					blindVisited[nx][ny] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		blindVisited = new boolean[n][n];
		eyeVisited = new boolean[n][n];
		eyeBoard = new char[n][n];
		blindeyeBoard = new char[n][n];
		for (int i = 0; i < n; i++) {
			char[] arr = br.readLine().toCharArray();

			for (int j = 0; j < n; j++) {
				eyeBoard[i][j] = arr[j];
				blindeyeBoard[i][j] = arr[j];
				if (arr[j] == 'G') {
					blindeyeBoard[i][j] = 'R';
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (eyeVisited[i][j] == false) {
					Main_10026_BFS.bfs(new Pointer(i, j));
					eye++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (blindVisited[i][j] == false) {
					Main_10026_BFS.bfs2(new Pointer(i, j));
					blind++;
				}
			}
		}

		System.out.println(eye + " " + blind);
	}
}
