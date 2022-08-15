package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main_11286 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
			/*
			* 음수를 리턴하면 첫번째 수가 더 작음
			* 양수를 리턴하면 첫번째 수가 더 큼
			* 0을 리턴하면 같음
			* */
			int su1 = Math.abs(o1);
			int su2 = Math.abs(o2);
			if (su1 == su2) {
				return o1 > o2 ? 1 : -1;
			}
			return su1 - su2;
		});

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0) {
				if (queue.isEmpty()) {
					System.out.println("0");
				} else {
					System.out.println(queue.poll());
				}
			} else {
				queue.add(arr[i]);
			}
		}
	}
}
