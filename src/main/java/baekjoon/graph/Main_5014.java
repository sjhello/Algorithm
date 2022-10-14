package baekjoon.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 스타트링크
* */
public class Main_5014 {
	static int F;	// 몇 층으로 이루어져있는지?
	static int S;	// 현재 있는 곳
	static int G;	// 스타트 링크가 있는 곳
	static int U;	// 위로 몇 층 갈 수 있는지?
	static int D;	// 아래로 몇 층 갈 수 있는지?
	static int[] visited;	// 방문 체크 및 U,D를 몇번 눌렀는지 확인하는 배열

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == G) {
				break;
			}

			// 현재 층 + U를 했을때
			if (current + U <= F && visited[current + U] == Integer.MAX_VALUE) {
				visited[current + U] = visited[current] + 1;
				queue.add(current + U);
			}

			// 현재 층 - D를 했을때
			if (current - D > 0 && visited[current - D] == Integer.MAX_VALUE) {
				visited[current - D] = visited[current] + 1;
				queue.add(current - D);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		visited = new int[F + 1];	// 0층은 없기 때문에 + 1을 해줌

		for (int i = 0; i <= F; i++) {
			visited[i] = Integer.MAX_VALUE;
		}

		bfs(S);

		printResult();
	}

	private static void printResult() {
		if (visited[G] == Integer.MAX_VALUE) {
			System.out.println("use the stairs");
		} else {
			System.out.println(visited[G]);
		}
	}
}
