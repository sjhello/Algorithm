package baekjoon.array;

import java.util.Scanner;

public class Main_1475 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		
		// 입력
		int[] numberArray = new int[10];
		int temp = 0;
		for (int i = 0; i < str.length(); i++) {
			temp = str.charAt(i) - '0';		// 입력을 문자열로 받은 다음 위치에 맞게 꺼내서 정수형으로 바꿔준다
			numberArray[temp]++;		// 등장할때마다 + 1
		}

		// 로직
		int answer = 1;
		for (int i = 0; i < 10; i++) {
			if (i == 6 || i == 9) {
				continue;
			}
			answer = Math.max(answer, numberArray[i]);
		}

		// 6과 9를 더한값이 짝수이면 2로 나눈 몫이 정답 이지만 3과같이 홀수인 경우에 몫이 2가 나올수있기 때문에 + 1을 해줌
		answer = Math.max(answer, (numberArray[6] + numberArray[9] + 1) / 2);
		System.out.println(answer);
	}
}
