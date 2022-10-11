package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
* 미로 만들기
* */
public class Main_2665 {
	static int n;
	static int[][] map;
	static int[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static class Pointer {
		int x;
		int y;

		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/*
	* 최단 거리로 지나올때 검은방의 갯수를 구해야한다
	* */
	public static void bfs(Pointer pointer) {
		Queue<Pointer> queue = new LinkedList<>();
		queue.add(pointer);
		visited[0][0] = 0;

		while (!queue.isEmpty()) {
			Pointer current = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
					// 다음 좌표를 이미 방문한 경우
					if (visited[nx][ny] <= visited[current.x][current.y]) {
						continue;
					}

					// 흰방
					if (map[nx][ny] == 1) {
						queue.add(new Pointer(nx, ny));
						visited[nx][ny] = visited[current.x][current.y];
					}

					// 검은방
					else {
						queue.add(new Pointer(nx, ny));
						visited[nx][ny] = visited[current.x][current.y] + 1;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		visited = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");

			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				visited[i][j] = Integer.MAX_VALUE;
			}
		}

		bfs(new Pointer(0, 0));

		System.out.println(visited[n - 1][n - 1]);
	}
}
