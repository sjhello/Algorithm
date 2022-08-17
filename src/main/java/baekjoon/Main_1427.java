package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1427 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();

		int[] num = new int[a.length()];
		for (int i = 0; i < a.length(); i++) {
			num[i] = Integer.parseInt(a.substring(i, i+1));
		}

		for (int i = 0; i < num.length; i++) {
			int max = i;
			for (int j = i + 1; j < num.length; j++) {
				if (num[j] > num[max]) {
					max = j;
				}
			}
			if (num[i] < num[max]) {
				int temp = num[i];
				num[i] = num[max];
				num[max] = temp;
			}
		}

		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
	}
}
