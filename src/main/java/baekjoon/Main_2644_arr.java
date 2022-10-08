package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*
* 2차원 배열 인접행렬
* */
public class Main_2644_arr {
	static int a;
	static int b;
	static int n;
	static int m;
	static int[][] arr;
	static int[] chonsu;

	public static void BFS(int start, int end) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			if (current == end) {
				break;
			}

			for (int i = 1; i <= n; i++) {
				if (arr[current][i] == 1 && chonsu[i] == 0) {
					chonsu[i] = chonsu[current] + 1;
					queue.add(i);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();	// 번호
		a = sc.nextInt();	// 촌수를 계산해야하는 서로 다른 두 사람의 번호
		b = sc.nextInt();	// 촌수를 계산해야하는 서로 다른 두 사람의 번호
		m = sc.nextInt();	// 관계의 갯수
		arr = new int[n + 1][n + 1];
		chonsu = new int[n + 1];

		for (int i = 0; i < m; i++) {
			int p = sc.nextInt();
			int c = sc.nextInt();
			arr[p][c] = 1;
			arr[c][p] = 1;
		}

		BFS(a, b);

		if (chonsu[b] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(chonsu[b]);
		}

	}
}
