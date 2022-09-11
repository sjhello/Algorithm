package baekjoon;

import java.util.*;


/*
* DFS와 BFS
* */
public class Main_1260 {
	static int n;
	static int m;
	static int v;
	static int[][] arr;
	static int[] bfsVisited;
	static int[] dfsVisited;
	static ArrayList<Integer> bfsAnswer;
	static ArrayList<Integer> dfsAnswer;

	public static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(v);
		bfsVisited[v] = 1;
		bfsAnswer.add(v);

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 1; i <= n; i++) {
				if (arr[current][i] == 1 && bfsVisited[i] == 0) {
					bfsVisited[i] = 1;
					bfsAnswer.add(i);
					queue.offer(i);
				}
			}
		}
	}

	public static void DFS(int level, int v) {
		if (level == n) {
			return ;
		} else {
			for (int i = 1; i <= n; i++) {
				if (arr[v][i] == 1 && dfsVisited[i] == 0) {
					dfsVisited[i] = 1;
					dfsAnswer.add(i);
					DFS(level + 1, i);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		arr = new int[n + 1][n + 1];
		bfsVisited = new int[n + 1];
		dfsVisited = new int[n + 1];
		bfsAnswer = new ArrayList<>();
		dfsAnswer = new ArrayList<>();

		for (int j = 0; j < m; j++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}

		solved();
		print();
	}

	public static void solved() {
		dfsVisited[v] = 1;
		dfsAnswer.add(v);
		DFS(1, v);
		BFS();
	}

	public static void print() {
		for (int number : dfsAnswer) {
			System.out.print(number + " ");
		}

		System.out.println();

		for (int number : bfsAnswer) {
			System.out.print(number + " ");
		}
	}
}
