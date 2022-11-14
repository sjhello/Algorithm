package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
* 단어 뒤집기2
* */
public class Main_17413 {

	/*
	 * 알파벳 소문자('a'-'z'), 숫자('0'-'9'), 공백(' '), 특수 문자('<', '>')로만 이루어져 있다.
	 * 문자열의 시작과 끝은 공백이 아니다.
	 * '<'와 '>'가 문자열에 있는 경우 번갈아가면서 등장하며, '<'이 먼저 등장한다. 또, 두 문자의 개수는 같다
	 *
	 * 태그는 '<'로 시작해서 '>'로 끝나는 길이가 3 이상인 부분 문자열이고, '<'와 '>' 사이에는 알파벳 소문자와 공백만 있다
	 * 단어는 알파벳 소문자와 숫자로 이루어진 부분 문자열이고, 연속하는 두 단어는 공백 하나로 구분한다. 태그는 단어가 아니며, 태그와 단어 사이에는 공백이 없다.
	 * */

	public static void main(String[] args) throws IOException {
		// builderVersion();
		// stackVersion();
	}

	public static void builderVersion() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		// result
		StringBuilder ss = new StringBuilder();		// 단어를 판단하는 변수

		char[] input = br.readLine().toCharArray();
		boolean isTagClosed = false;

		for (char ch : input) {
			if (ch == '<' || ch == ' ') {
				sb.append(ss.reverse());
				ss.setLength(0);
				sb.append(ch);
				if (ch == '<') {
					isTagClosed = true;
				}
			} else if (ch == '>') {
				isTagClosed = false;
				sb.append(ch);
			} else {
				if (isTagClosed) {
					sb.append(ch);
				} else {
					ss.append(ch);
				}
			}
		}

		if (ss.length() != 0) {
			sb.append(ss.reverse());
		}

		System.out.println(sb);
	}

	public static void stackVersion() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		Stack<Character> stack = new Stack<>();		// 출력을 위한 자료구조
		boolean isTag = false;		// 태그 안에있는지 확인

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '<') {		// 태그의 시작점
				isTag = true;
				while (!stack.isEmpty()) {	// 입력에서 태그(<>)와 태그(<>) 사이의 있는 단어를 출력하기 위함
					System.out.print(stack.pop());
				}
				System.out.print(str.charAt(i));
			} else if (str.charAt(i) == '>') {		// 태그의 마지막 지점
				isTag = false;
				System.out.print(str.charAt(i));
			} else if (isTag) {		 // 태그 안에 있는 경우
				System.out.print(str.charAt(i));
			} else if (!isTag) {		// 태그안에 있지 않은 경우
				if (str.charAt(i) == ' ') {		// 태그가 없고 공백을 만났다면
					while (!stack.isEmpty()) {
						System.out.print(stack.pop());
					}
					System.out.print(str.charAt(i));
				} else {
					stack.push(str.charAt(i));
				}
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
