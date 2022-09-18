package baekjoon;

import java.util.Scanner;

/*
 * N과 M(2)
 * */
public class Main_15650 {
	static int n;
	static int m;
	static int[] numbers;
	static int[] visited;
	static int[] answer;
	static StringBuilder sb = new StringBuilder();

	public static void dfs(int level, int depth) {
		if (level == m) {
			for (int number : answer) {
				sb.append(number).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = depth; i < numbers.length; i++) {
				if (visited[i] == 0) {
					visited[i] = 1;
					answer[level] = numbers[i];
					dfs(level + 1, i + 1);
					visited[i] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		numbers = new int[n];
		visited = new int[n];
		answer = new int[m];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		Main_15650.dfs(0, 0);
		System.out.println(sb);
	}
}
