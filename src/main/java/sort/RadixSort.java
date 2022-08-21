package sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* 자릿수별 값 구하는 법을 알아야한다
* 참고: counting sort
* */

public class RadixSort {
	static final int queueSize = 10;
	static final int degree = 3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		radixSort(n, arr);
		System.out.println("main method");
		System.out.println(Arrays.toString(arr));
	}

	public static void radixSort(int n, int[] arr) {
		Queue<Integer>[] bucket = new LinkedList[queueSize];
		for (int i = 0; i < queueSize; ++i) {
			bucket[i] = new LinkedList<>();		// 0 ~ 9개의 방을 가지고 있다
		}

		int factor = 1;

		for (int i = 0; i < degree; i++) {
			for (int j = 0; j < n; j++) {		// 배열에 있는 데이터를 큐로 옮겨서 자릿수에 맞는 큐의 방에 집어넣는다
				int modNumber = (arr[j] / factor) % 10;
				bucket[modNumber].add(arr[j]);
			}

			for (int j = 0, k = 0; j < queueSize; j++) {		// 큐에 있는걸 하나씩 빼서 배열로 복사
				while(!bucket[j].isEmpty()) {
					arr[k++] = bucket[j].poll();
				}
			}

			factor = factor * 10;

			System.out.println("============");
			System.out.println(Arrays.toString(arr));
		}
	}
}
