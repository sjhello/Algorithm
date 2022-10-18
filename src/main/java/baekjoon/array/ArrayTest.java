package baekjoon.array;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40};
		ArrayTest at = new ArrayTest();

		int[] newArr = at.insert(2, 5, arr, arr.length);
		System.out.println(Arrays.toString(newArr));
		int[] deleteArr = at.delete(2, newArr, newArr.length);
		System.out.println(Arrays.toString(deleteArr));
	}

	public int[] insert(int index, int number, int[] arr, int length) {
		int[] newArr = Arrays.copyOf(arr, length + 1);

		for (int i = length; i > index; i--) {
			newArr[i] = newArr[i - 1];
		}
		newArr[index] = number;

		return newArr;
	}

	public int[] delete(int index, int[] arr, int length) {
		for (int i = index; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}

		return Arrays.copyOf(arr, arr.length - 1);
	}
}
