package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		// 듣도 못한 사람
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}

		// 보도 못한 사람
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				result.add(str);
			}
		}

		printResult(result);
	}

	private static void printResult(ArrayList<String> result) {
		Collections.sort(result);

		System.out.println(result.size());
		for (String str : result) {
			System.out.println(str);
		}
	}
}
