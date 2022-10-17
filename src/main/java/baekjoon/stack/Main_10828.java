package baekjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main_10828 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");

			switch (str[0]) {
				case "push" :
					stack.add(Integer.parseInt(str[1]));
					break;
				case "pop" :
					try {
						System.out.println(stack.pop());
					} catch (EmptyStackException ex) {
						System.out.println(-1);
					}
					break;
				case "size" :
					System.out.println(stack.size());
					break;
				case "empty" :
					int isEmpty = stack.empty() ? 1 : 0;
					System.out.println(isEmpty);
					break;
				case "top":
					try {
						System.out.println(stack.peek());
					} catch (EmptyStackException ex) {
						System.out.println(-1);
					}
					break;
			}
		}
	}
}
