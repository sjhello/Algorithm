package inflearn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
* 미로의 최단거리 통로(BFS)
* */
public class Problem8_11 {
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] miro;
	static int[][] dis;
	static int answer;

	static class XY {
		int x;
		int y;

		public XY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void BFS(XY xy) {
		Queue<XY> queue = new LinkedList();
		queue.offer(xy);
		miro[xy.x][xy.y] = 1;

		while(!queue.isEmpty()) {
			XY current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && miro[nx][ny] == 0) {
					miro[nx][ny] = 1;
					queue.offer(new XY(nx, ny));
					dis[nx][ny] = dis[current.x][current.y] + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		miro = new int[8][8];
		for (int i = 1; i < 8; i++) {
			for (int j = 1; j < 8; j++) {
				miro[i][j] = sc.nextInt();
			}
		}
		dis = new int[8][8];

		Problem8_11.BFS(new XY(1, 1));

		if (dis[7][7] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(dis[7][7]);
		}
	}
}
