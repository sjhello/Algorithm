package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			Stack<String> stack = inputStack(str);

			printResult(stack);
			stack.clear();
		}

	}

	private static Stack<String> inputStack(String[] str) {
		Stack<String> stack = new Stack<>();

		for (String s : str) {
			if (s.equals("(")) {
				stack.push(s);
			} else {
				if (stack.size() == 0) {
					stack.push(s);
					break;
				} else {
					stack.pop();
				}
			}
		}

		return stack;
	}

	private static void printResult(Stack<String> stack) {
		if (stack.isEmpty()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
