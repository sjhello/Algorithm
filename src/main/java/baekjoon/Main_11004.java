package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11004 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		quickSort(arr, 0, arr.length - 1, k - 1);
		System.out.println(arr[k-1]);

	}

	public static void quickSort(int[] arr, int s, int e, int k) {
		if (s < e) {
			int pivot = getPivot(arr, s, e);
			if (pivot == k) {
				return ;
			} else if (k < pivot) {
				quickSort(arr, s, pivot - 1, k);	// 왼쪽 정렬
			} else {
				quickSort(arr, pivot + 1, e, k);	// 오른쪽 정렬
			}
		}
	}

	public static int getPivot(int[] arr, int s, int e) {
		if (s + 1 == e) {		// s와 e가 만나서 s가 e보다 컸다면 swap하고 pivot을 리턴
			if (arr[s] > arr[e]) {
				swap(arr, s, e);
			}
			return e;
		}

		int middle = (s+e) / 2;		// 중간값 pivot
		swap(arr, s, middle);
		int pivot = arr[s];
		int i = s + 1;
		int j = e;

		while (i <= j) {
			while(j > 0 && pivot < arr[j]) {
				j--;
			}
			while(i < arr.length - 1 && pivot > arr[i]) {
				i++;
			}
			if (i <= j) {
				swap(arr, i++, j--);
			}
		}
		arr[s] = arr[j];
		arr[j] = pivot;

		return j;
	}

	public static void swap(int[] arr, int s, int e) {
		int temp = arr[e];
		arr[e] = arr[s];
		arr[s] = temp;
	}
}
