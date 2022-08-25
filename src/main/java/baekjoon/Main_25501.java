package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_25501 {
	static int count;

	public static int recursion(char[] s, int l, int r) {
		count++;

		if (l >= r) return 1;
		else if(s[l] != s[r]) return 0;
		else return recursion(s, l + 1, r - 1);
	}

	public static int isPalindrom(String s) {
		char[] arr = s.toCharArray();
		count = 0;

		return recursion(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] arr = new String[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = br.readLine();
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println(isPalindrom(arr[i]) + " " + count);
		}
	}
}
