package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2644_ArrayList {
	static int[] chonsu;

	public static void bfs(int start, int end, ArrayList<ArrayList<Integer>> list) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			if (current == end) {
				break;
			}

			for (int number : list.get(current)) {
				if (!list.get(number).isEmpty() && chonsu[number] == 0) {
					chonsu[number] = chonsu[current] + 1;
					queue.add(number);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// 번호
		int a = sc.nextInt();	// 촌수를 계산해야하는 서로 다른 두 사람의 번호
		int b = sc.nextInt();
		int m = sc.nextInt();	// 관계의 갯수
		chonsu = new int[n + 1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			list.add(i, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.get(x).add(y);
			list.get(y).add(x);
		}

		bfs(a, b, list);

		if (chonsu[b] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(chonsu[b]);
		}

	}
}
