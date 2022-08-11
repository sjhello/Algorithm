package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12891 {
	static int[] check = new int[4];		// 부분 문자열에 포함돼야 할 [A, C, G, T]의 최소 갯수
	static int[] myArr = new int[4];		// 임의로 만든 문자열을 4개씩 잘라서 체크해야하는 배열
	static int checkResult = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int s = Integer.parseInt(st.nextToken());		// 문자열의 길이 9
		int p = Integer.parseInt(st.nextToken());		// 비밀번호가 사용할 문자열의 길이(부분 문자열의 크기) 8

		char [] A = new char[s];		// 임의로 만든 문자열(문자열 데이터)	8
		A = br.readLine().toCharArray();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < check.length; i++) {
			check[i] = Integer.parseInt(st.nextToken());
			
			// 0이면 유효성 체크 안해도됨
			if (check[i] == 0) {
				checkResult++;
			}
		}

		for (int i = 0; i < p; i++) {
			add(A[i]);
		}
		int result = 0;		// 결과

		if (checkResult == 4) {
			result++;
		}

		for (int i = p; i < s; i++) {
			int j = i - p;
			add(A[i]);
			remove(A[j]);
			if (checkResult == 4) {
				result++;
			}
		}
		System.out.println(result);
		br.close();
	}

	public static void remove(char c) {
		switch (c) {
			case 'A':
				if (myArr[0] == check[0]) {
					checkResult--;
				}
				myArr[0]--;
				break;
			case 'C':
				if (myArr[1] == check[1]) {
					checkResult--;
				}
				myArr[1]--;
				break;
			case 'G':
				if (myArr[2] == check[2]) {
					checkResult--;
				}
				myArr[2]--;
				break;
			case 'T':
				if (myArr[3] == check[3]) {
					checkResult--;
				}
				myArr[3]--;
				break;
		}
	}

	public static void add(char c) {
		switch (c) {
			case 'A':
				myArr[0]++;
				if (myArr[0] == check[0]) {
					checkResult++;
				}
				break;
			case 'C':
				myArr[1]++;
				if (myArr[1] == check[1]) {
					checkResult++;
				}
				break;
			case 'G':
				myArr[2]++;
				if (myArr[2] == check[2]) {
					checkResult++;
				}
				break;
			case 'T':
				myArr[3]++;
				if (myArr[3] == check[3]) {
					checkResult++;
				}
				break;
		}
	}
}
