package baekjoon.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
* 효율적인 해킹(인접 리스트)
* */
public class Main_1325 {
	static int n;
	static int m;
	static ArrayList<ArrayList<Integer>> map;
	static int[] visited;
	static int[] answer;
	static int count;

	public static void bfs(int number) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(number);
		visited[number] = 1;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int next : map.get(current)) {
				if (visited[next] == 0) {
					visited[next] = 1;
					queue.add(next);
					count++;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new ArrayList<>();
		answer = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			map.add(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			map.get(b).add(a);
		}

		printAnswer();
	}

	private static void printAnswer() {
		int result = 0;

		for (int i = 1; i <= n; i++) {
			visited = new int[n + 1];
			count = 0;
			bfs(i);
			answer[i] = count;
			result = Math.max(result, answer[i]);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (result == answer[i]) sb.append(i + " ");
		}

		System.out.println(sb);
	}
}
