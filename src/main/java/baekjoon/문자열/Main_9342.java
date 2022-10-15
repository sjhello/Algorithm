package baekjoon.문자열;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main_9342 {

	static final String trueString = "Infected!";

	static final String falseString = "Good";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];

		Pattern pattern = Pattern.compile("^[A-F]{0,1}[A]{1,}[F]{1,}[C]{1,}$[A-F]{0,1}");

		for (int i = 0; i < n; i++) {
			String str = sc.next();
			Matcher matcher = pattern.matcher(str);

			arr[i] = matcher.matches() ? trueString : falseString;
		}

		for (String result : arr) {
			System.out.println(result);
		}
	}
}
