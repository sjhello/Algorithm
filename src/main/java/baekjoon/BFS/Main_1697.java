package baekjoon.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 1차원 배열에서의 BFS
* 숨바꼭질
* */
public class Main_1697 {
	static int n;
	static int m;
	static int[] dis;

	public static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		dis[start] = 1;

		while (!queue.isEmpty()) {
			Integer current = queue.poll();

			for (int i = 0; i < 3; i++) {
				int next;

				if (i == 0) {
					next = current - 1;
				} else if (i == 1) {
					next = current + 1;
				} else {
					next = current * 2;
				}

				if (next == m) {
					System.out.println(dis[current]);
					return ;
				}

				if (next >= 0 && next < 100_001 && dis[next] == 0) {
					queue.add(next);
					dis[next] = dis[current] + 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		dis = new int[100_001];

		if (n == m) {
			System.out.println(0);
		} else {
			bfs(n);
		}
	}
}
