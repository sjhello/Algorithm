package baekjoon;

import java.util.Scanner;

public class Main_2018 {
	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		// 투 포인터
		int S = 0;
		int E = 0;
		int count = 0;

		int [] array = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = i + 1;
		}

		int sum = 0;
		while(S < N && E < N) {
			if (sum == N) {
				count++;
				sum += array[E];
				E++;
			} else if (sum > N) {
				sum -= array[S];
				S++;
			} else {
				sum += array[E];
				E++;
			}
		}
		System.out.println(count+1);
	}
}
