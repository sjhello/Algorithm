package baekjoon;

import java.util.Scanner;

/*
 * N과 M(3)
 * */
public class Main_15651 {
	static int n;
	static int m;
	static int[] answer;
	static int[] visited;
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();

	public static void dfs(int level) {
		if (level == m) {
			for (int number : answer) {
				sb.append(number).append(" ");
			}
			sb.append("\n");
		} else {
			for (int i = 0; i < numbers.length; i++) {
				answer[level] = numbers[i];
				dfs(level + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		answer = new int[m];
		visited = new int[n];
		numbers = new int[n];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
		}

		Main_15651.dfs(0);
		System.out.println(sb);
	}
}
