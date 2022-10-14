package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
* 맥주 마시면서 걸어가기
* */
public class Main_9205 {
	static int t;		// 테스트 케이스 수
	static int n;		// 편의점 수
	static boolean[] visited;		// 방문 배열
	static StringBuilder sb = new StringBuilder();

	static class Pointer {
		int x;
		int y;

		public Pointer(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void bfs(Pointer[] pointers) {
		Queue<Pointer> queue = new LinkedList<>();

		Pointer start = pointers[0];		// 출발
		Pointer end = pointers[n + 1];		// 도착

		// 출발 지점 방문 처리
		visited[0] = true;
		queue.add(start);

		boolean isArrive = false;	// 도착했는지?

		while (!queue.isEmpty()) {
			Pointer current = queue.poll();

			// 락 페스티벌 도착
			if (current.equals(end)) {
				isArrive = true;
				break;
			}

			for (int i = 1; i < n + 2; i++) {
				if ((visited[i] == false) && (Math.abs(current.x - pointers[i].x) + Math.abs(current.y - pointers[i].y)) <= 1000) {
					visited[i] = true;
					queue.add(pointers[i]);
				}
			}
		}

		printResult(isArrive);
	}

	private static void printResult(boolean isArrive) {
		if (isArrive) {
			sb.append("happy\n");
		} else {
			sb.append("sad\n");
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());	// 편의점 갯수
			Pointer[] pointers = new Pointer[n + 2];	// 좌표 배열
			visited = new boolean[n + 2];

			// 0: 상근이 집
			// 1 ~ n : 편의점
			// n + 1: 락 페스티벌
			for (int j = 0; j < n + 2; j++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				pointers[j] = new Pointer(x, y);
			}

			bfs(pointers);
		}

		System.out.println(sb.toString());
	}
}
