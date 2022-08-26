package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7_08 {

	int result = 0;
	int[] distance = {-1, 1, 5};
	boolean[] visited;
	Queue<Integer> queue = new LinkedList<>();

	public int BFS(int s, int e) {
		visited = new boolean[10001];
		visited[s] = true;

		queue.offer(s);
		int level = 0;

		while(!queue.isEmpty()) {
			int length = queue.size();

			for (int i = 0; i < length; i++) {
				int num = queue.poll();

				// if (num == e) {
				// 	return level;
				// }

				for (int j = 0; j < distance.length; j++) {
					int nx = num + distance[j];
					if (nx == e) return level+1;
					if (nx >= 1 && nx <= 10000 && visited[nx] == false) {
						visited[nx] = true;
						queue.offer(nx);
					}
				}
			}
			level++;
		}

		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		Problem7_08 problem = new Problem7_08();
		problem.result = problem.BFS(s, e);

		System.out.println(problem.result);
	}
}
