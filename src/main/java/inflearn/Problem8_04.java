package inflearn;

import java.util.Scanner;

/*
* 중복 순열
* */
public class Problem8_04 {
	static int n; 	// 3 <= N <= 10
	static int m;	// M번 구슬을 뽑는다
	static int[] pm;

	public static void DFS(int level) {
		if (level == m) {
			for (int num : pm) {
				System.out.print(num + " ");
			}
			System.out.println();
		} else {
			for (int i = 1; i <= n; i++) {
				pm[level] = i;
				DFS(level + 1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		pm = new int[m];

		Problem8_04.DFS(0);
	}
}
