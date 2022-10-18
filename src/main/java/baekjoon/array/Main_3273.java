package baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3273 {

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[100_001];
		boolean[] exist = new boolean[2_000_000];

		String[] str = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(str[i]);
		}
		int x = Integer.parseInt(br.readLine());
		
		// 로직
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (x - arr[i] > 0 && exist[x - arr[i]]) {
				answer++;
			}
			exist[arr[i]] = true;
		}

		System.out.println(answer);
	}
}
