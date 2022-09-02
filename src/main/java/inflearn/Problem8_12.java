package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 토마토(BFS 활용)
* */
public class Problem8_12 {
	static int[][] box;
	static int[][] dis;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
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

	public static void BFS() {
		Queue<Pointer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 1) {
					queue.offer(new Pointer(i, j));
				}
			}
		}

		while(!queue.isEmpty()) {
			Pointer current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && nx < n && ny >=0 && ny < m && box[nx][ny] == 0) {
					box[nx][ny] = 1;
					queue.offer(new Pointer(nx, ny));
					dis[nx][ny] = dis[current.x][current.y] + 1;
				}
			}
		}
	}

	public static void printResult() {
		boolean flag = true;
		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (box[i][j] == 0) {
					flag = false;	// 모두 익지 않은 경우
					break;
				}
			}
		}

		if (flag) {		// 처음부터 다 익은경우 혹은 최소 날짜 출력
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					answer = Math.max(answer, dis[i][j]);
				}
			}
			System.out.println(answer);
		} else {
			System.out.println("-1");
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();	// 가로 칸
		n = sc.nextInt();	// 세로 칸
		box = new int[n][m];
		dis = new int[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				box[i][j] = sc.nextInt();
			}
		}

		Problem8_12.BFS();
		Problem8_12.printResult();
	}
}
