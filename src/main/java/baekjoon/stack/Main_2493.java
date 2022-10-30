package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
* 입력과 동시에 값을 비교하는 아이디어
* */
public class Main_2493 {

	static class Top {
		int num;		// 번호
		int height;		// 높이

		public Top(int num, int height) {
			this.num = num;
			this.height = height;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		Stack<Top> stack = new Stack<>();
		for (int i = 1; i <= n; i++) {
			Top top = new Top(i, Integer.parseInt(st.nextToken()));
			while (!stack.isEmpty()) {
				// 입력으로 받은 탑이 높이가 같거나 크다면
				// 탑의 번호를 출력
				if (stack.peek().height >= top.height) {
					System.out.print(stack.peek().num + " ");
					break;
				}

				stack.pop();
			}

			// 입력의 높이보다 더 높은 높이가 없는 경우 0을 출력
			if (stack.isEmpty()) {
				System.out.print(0 + " ");
			}

			stack.push(top);
		}
	}
}
