package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1253 {
	public static void  main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] arr = new long[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		int count = 0;

		for (int i = 0; i < N; i++) {
			long numberOfFind = arr[i];
			int s = 0;
			int e = N - 1;

			while (s < e) {
				if (arr[s] + arr[e] == numberOfFind) {
					if (s != i && e != i) {
						count++;
						break;
					} else if (s == i) {
						s++;
					} else if (e == i) {
						e--;
					}
				} else if (arr[s] + arr[e] > numberOfFind) {
					e--;
				} else {
					s++;
				}
			}
		}

		System.out.println(count);
		br.close();
	}
}
