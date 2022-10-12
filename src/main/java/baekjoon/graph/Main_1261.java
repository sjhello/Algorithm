package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
* 알고스팟
* */
public class Main_1261 {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int answer;

	static class Pointer {
		int x;
		int y;
		int dist;		// 부순 벽 수

		public Pointer(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void bfs(Pointer pointer) {
		PriorityQueue<Pointer> queue = new PriorityQueue<>(new Comparator<Pointer>() {
			@Override
			public int compare(Pointer o1, Pointer o2) {
				return o1.dist - o2.dist;
			}
		});
		queue.add(pointer);
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Pointer current = queue.poll();

			// 방의 끝지점에 도달하면 종료
			if (current.x == m - 1 && current.y == n - 1) {
				answer = current.dist;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < m && ny < n && visited[nx][ny] == false) {

					// 벽인 경우
					if (map[nx][ny] == 1) {
						queue.add(new Pointer(nx, ny, current.dist + 1));
						visited[nx][ny] = true;
					} else {
						// 빈방인 경우
						queue.add(new Pointer(nx, ny, current.dist));
						visited[nx][ny] = true;
					}

				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		bfs(new Pointer(0, 0, 0));

		System.out.println(answer);
	}
}
