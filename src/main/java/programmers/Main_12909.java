package programmers;

import java.util.Stack;

/*
* LV 2
* 올바른 괄호
* */
public class Main_12909 {

	public static void main(String[] args) {
		boolean solution = solution("(()(");
		System.out.println(solution);
	}

	public static boolean solution(String s) {
		boolean answer = true;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					stack.push(s.charAt(i));
				}
			}
		}

		if (!stack.isEmpty()) {
			answer = false;
		}

		return answer;
	}
}
