package baekjoon;

import java.util.Scanner;

public class Main_2750 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int whileIndex = 0;
		while(whileIndex < n) {
			for (int i = 0; i < n; i++) {
				int temp = 0;
				for (int j = i+1; j < n; j++) {
					if (arr[i] > arr[j]) {
						temp = arr[j];
						arr[j] = arr[i];
						arr[i] = temp;
						break;
					}
				}
			}
			whileIndex++;
		}

		/*
		* while문을 쓰지않는 방법
		* */
		// for (int i = 0; i < n-1; i++) {
		// 	for (int j = 0; j < n-1-i; j++) {
		// 		if (arr[j] > arr[j+1]) {
		// 			int temp = arr[j];
		// 			arr[j] = arr[j+1];
		// 			arr[j+1] = temp;
		// 		}
		// 	}
		// }

		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
	}
}
