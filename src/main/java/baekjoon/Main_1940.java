package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1940 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// Arrays.sort(arr);

		int s = 0;
		int e = arr.length - 1;
		int count = 0;

		while (s < e) {
			if (arr[s] + arr[e] == m) {
				count++;
				e--;
				s++;
			} else if (arr[s] + arr[e] > m) {
				e--;
			} else {
				s++;
			}
		}

		System.out.println(count);
	}
}
