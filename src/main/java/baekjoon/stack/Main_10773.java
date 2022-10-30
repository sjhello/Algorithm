package baekjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class Main_10773 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int result = 0;

		for (int i = 0; i < n; i++) {
			int m = sc.nextInt();

			if (m == 0 && !stack.isEmpty()) {
				stack.pop();
			} else {
				stack.push(m);
			}
		}

		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		System.out.println(result);
	}
}
