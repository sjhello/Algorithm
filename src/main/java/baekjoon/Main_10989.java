package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;


/*
* 이 문제를 Radix Sort로 풀수는 없을까?
* 메모리 제한 8MB(java 11 기준 512MB)
* 시간 제한 5초
* */
public class Main_10989 {
	static final int degree = 5;
	static final int bucketSize = 10;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		quickSort(arr.length, arr);

		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			stringBuilder.append(arr[i]).append("\n");
		}

		System.out.println(stringBuilder.toString());
	}

	public static void quickSort(int n, int[] arr) {
		Queue<Integer>[] bucket = new LinkedList[bucketSize];
		for (int i = 0; i < bucketSize; i++) {
			bucket[i] = new LinkedList<>();
		}

		int factor = 1;

		for (int i = 0; i < degree; i++) {
			for (int j = 0; j < arr.length; j++) {
				int modNumber = (arr[j] / factor) % 10;
				bucket[modNumber].add(arr[j]);
			}

			for (int j = 0, k = 0; j < bucketSize; j++) {
				while(!bucket[j].isEmpty()) {
					arr[k++] = bucket[j].poll();
				}
			}

			factor *= 10;
		}
	}

}
