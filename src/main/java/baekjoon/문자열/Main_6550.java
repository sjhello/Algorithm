package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 부분 문자열
* */
public class Main_6550 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		String str;

		while ((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			String str1 = st.nextToken();
			String str2 = st.nextToken();

			int str1_index = 0;

			for (int i = 0; i < str2.length(); i++) {
				if (str1.charAt(str1_index) == str2.charAt(i)) {
					str1_index++;
				}

				if (str1_index == str1.length()) {
					break;
				}
			}

			if (str1_index == str1.length()) {
				sb.append("YES").append("\n");
			} else {
				sb.append("NO").append("\n");
			}
		}

		System.out.println(sb);
	}
}
