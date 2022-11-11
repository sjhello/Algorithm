package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
* 단어 정렬
* Comparator, Comparable
* */
public class Main_1181 {
	static String[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		array = new String[n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			array[i] = str;
		}

		sortArray();
		printResult();
	}

	private static void sortArray() {
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
			}
		});
	}

	private static void printResult() {
		StringBuilder sb = new StringBuilder();
		sb.append(array[0]).append("\n");
		for (int i = 1; i < array.length; i++) {
			if (array[i - 1].equals(array[i])) {		// 같은 단어는 2번 출력하지 않는다
				continue;
			}
			sb.append(array[i]).append("\n");
		}

		System.out.println();
		System.out.println(sb);
	}
}
