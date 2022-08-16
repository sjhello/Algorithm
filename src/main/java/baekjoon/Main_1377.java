package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_1377 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		MyData[] arr = new MyData[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new MyData(Integer.parseInt(br.readLine()), i);		// 10 1 5 2 3
		}

		Arrays.sort(arr);		// 1 2 3 5 10

		int result = 0;
		for(int i = 0; i < n; i++) {
			if (result < arr[i].index - i) {
				result = arr[i].index - i;
			}
		}

		System.out.println(result + 1);
	}
}

class MyData implements Comparable<MyData> {
	int value;
	int index;

	public MyData(int value, int index) {
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(MyData o) {
		return this.value - o.value;
	}
}
