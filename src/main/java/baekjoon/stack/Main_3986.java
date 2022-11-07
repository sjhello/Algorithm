package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
* 좋은 단어
* 스텍
* */
public class Main_3986 {
	static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split("");
			solution(str);
		}
		System.out.println(answer);
	}

	private static void solution(String[] str) {
		Stack<String> stack = new Stack<>();

		for (String s : str) {
			if (stack.size() == 0) {
				stack.push(s);
			} else {
				if (stack.peek().equals(s)) {
					stack.pop();
				} else {
					stack.push(s);
				}
			}
		}

		if (stack.isEmpty()) {
			answer++;
		}
	}

}
