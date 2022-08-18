package baekjoon;

import java.util.Scanner;

public class Main_11399 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < n; i++) {		// 선택정렬
			for (int j = 0; j < i; j++) {
				if (arr[i] < arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}

		int[] s = new int[n]; 	// 구간합 배열
		int hap = 0;
		int result = 0;			// 총 합

		for (int i = 0; i < n; i++) {
			hap += arr[i];
			s[i] = hap;
			result += s[i];
		}

		System.out.println(result);
	}
}
