package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_17298 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 수열의 갯수

		int[] a = new int[n];		// 수열		 3 5 2 7
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int[] result = new int[n];		// 오큰 수의 수열(결과)

		Stack<Integer> stack = new Stack<>();
		stack.push(0);		// 비교할 인덱스를 0으로 초기화

		for (int i = 0; i < n; i++) {
			while(!stack.isEmpty() && a[i] > a[stack.peek()]) {		// 인덱스에 해당하는 수열의 수, 스택에 저장되어있는 인덱스에 해당하는 수열의 수
				result[stack.pop()] = a[i];		// 원본 수열의 수가 더 크다면 스택을 pop하고 결과 배열에 저장 
			}
			stack.push(i);		// 루프를 돌때마다 stack에 인덱스를 저장
		}

		while(!stack.isEmpty()) {
			result[stack.pop()] = -1;		// for 루프가 끝났음에도 스택에 남아있는 인덱스에 해당하는 수열의 수는 오큰수가 없는 경우임 따라서 -1을 결과 배열에 저장
		}

		StringBuffer bf = new StringBuffer();
		for(int i = 0; i < result.length; i++) {
			bf.append(result[i] + " ");
		}

		System.out.println(bf.toString());

	}
}
