package baekjoon;

import java.io.*;
import java.util.*;

/*
* 안전영역
* */
public class Main_2468 {
	static int n;
	static int[][] board;
	static int[][] watered;	// 물에 잠긴 영역을 표시하기 위한 배열
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int answer = Integer.MIN_VALUE;

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

		while (!queue.isEmpty()) {
			Pointer current = queue.poll();
			for (int i = 0; i < dx.length; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n && watered[nx][ny] == 0) {
					watered[nx][ny] = 1;
					queue.offer(new Pointer(nx, ny));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];

		ArrayList<Integer> numberList = new ArrayList<>();
		numberList.add(0);
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (!numberList.contains(board[i][j])) {
					numberList.add(board[i][j]);
				}
			}
		}
		Collections.sort(numberList);

		for (int number : numberList) {
			watered = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (board[i][j] <= number) {
						watered[i][j] = 1;
					}
				}
			}

			int count = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (watered[i][j] == 0) {	// 물에 잠기지 않은 영역 bfs로 체크
						Main_2468.BFS(new Pointer(i, j));
						count++;
					}
				}
			}

			answer = Math.max(answer, count);
		}


		System.out.println(answer);
	}
}
