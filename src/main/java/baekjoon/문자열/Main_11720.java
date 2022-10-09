package baekjoon.문자열;

import java.util.Scanner;

public class Main_11720 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int answer = 0;

		String number = sc.next();
		String[] split = number.split("");

		for (int i = 0; i < n; i++) {
			answer += Integer.parseInt(split[i]);
		}

		System.out.println(answer);
	}
}
