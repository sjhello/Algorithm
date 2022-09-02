package inflearn;

import java.util.Scanner;

/*
* 순열 구하기
* 3 2 -> 3개 중에 2개 뽑아서 나열
* */
public class Problem8_06 {
	static int n;	// 10 이하의 N개의 자연수 (자연수 입력 범위 : 3 <= N <= 10)
	static int m;	// n개 중 M개를 뽑는다 (2 <= M <= N)
	static int[] arr;
	static int[] pm;
	static int[] visited;

	public static void DFS(int level) {
		if (level == m) {
			for (int num : pm) {
				System.out.print(num + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < n; i++) {
				if (visited[i] == 0) {
					visited[i] = 1;
					pm[level] = arr[i];
					DFS(level + 1);
					visited[i] = 0;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		pm = new int[m];
		visited = new int[n];
		Problem8_06.DFS(0);
	}
}
