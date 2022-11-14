package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
* 그룹 단어
* */
public class Main_1316 {

	static int result;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			if (isGroupSt()) {
				result++;
			}
		}

		System.out.println(result);
	}

	public static boolean isGroupSt() throws IOException {
		boolean flag = true;
		boolean[] strCheckArray = new boolean[26];		// 소문자 알파벳 갯수만큼 배열 생성
		String str = br.readLine();

		int ch = 0;		// 비교대상 문자 0으로 초기화 해도 되는 이유는 입력이 알파벳 소문자이기 때문이다
		for (int i = 0; i < str.length(); i++) {
			int current = str.charAt(i);		// 현재 문자

			if (ch != current) {
				if (!strCheckArray[current - 97]) {		// 아스키 코드 참고
					strCheckArray[current - 97] = true;
					ch = current;
				} else {
					return false;
				}
			}
		}

		return true;
	}

}
