package baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main_1874 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();		// 8
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();		// 4, 3, 6, 8, 7, 5, 2, 1
		}

		int num = 1;	// 1부터 비교해서 스택에 pop(-), push(+) 하였는지 확인하는 용도
		Stack<Integer> stack = new Stack<>();
		StringBuffer bf = new StringBuffer();		// 출력 저장 용도
		boolean result = true;		// 입력값으로 들어온 수열의집합이 오름차순으로 만들수 있는지 없는지 판단하기 위한 용도

		for (int i = 0; i < arr.length; i++) {
			if(arr[i] >= num) {		// 수열값이 스택에 어떤 연산으로 들어가는지 체크하기 위함
				while(arr[i] >= num) {
					stack.push(num++);
					bf.append("+\n");
				}
				stack.pop();
				bf.append("-\n");
			}
			else {
				int su = stack.pop();

				if (su > arr[i]) {
					System.out.println("NO");
					result = false;
					break;
				} else {
					bf.append("-\n");
				}
			}
		}

		if (result) {
			System.out.println(bf);
		}

	}
}
