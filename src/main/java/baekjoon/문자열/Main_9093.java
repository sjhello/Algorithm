package baekjoon.문자열;

import java.io.*;
import java.util.*;

/*
* 단어 뒤집기
* */
public class Main_9093 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();

			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == ' ') {
					while (!stack.isEmpty()) {
						sb.append(stack.pop());
					}
					sb.append(str.charAt(j));
				} else {
					stack.push(str.charAt(j));
				}
			}

			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
