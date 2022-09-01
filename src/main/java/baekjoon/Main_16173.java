package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16173 {
	static int n;
	static int[][] board;
	static int[][] visited;


	static class Pointer {
		int x;	// 행
		int y;	// 열

		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void BFS(Pointer pointer) {
		Queue<Pointer> queue = new LinkedList<>();
		queue.offer(pointer);
		visited[0][0] =1;

		while(!queue.isEmpty()) {
			Pointer current = queue.poll();

			int nx = current.x + board[current.x][current.y];
			int ny = current.y + board[current.x][current.y];


			if (nx < n && visited[nx][current.y] == 0) {
				visited[nx][current.y] = 1;
				queue.offer(new Pointer(nx, current.y));
			}

			if (ny < n && visited[current.x][ny] == 0) {
				visited[current.x][ny] = 1;
				queue.offer(new Pointer(current.x, ny));
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new int[n][n];
		visited = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = sc.nextInt();
			}
		}

		Pointer start = new Pointer(0, 0);
		Main_16173.BFS(start);

		if (visited[n -1][n - 1] == 0) {
			System.out.println("Hing");
		} else {
			System.out.println("HaruHaru");
		}
	}
}
