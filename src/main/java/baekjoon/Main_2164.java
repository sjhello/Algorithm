package baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_2164 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Queue<Integer> queue = new LinkedList<>();		// 선입선출
		for (int i = 0; i < n; i++) {
			queue.add(i+1);
		}


		/*
		* 남아있는 데이터가 없을때 poll() 호출하면 비어있는 큐를 반환
		* 남아있는 데이터가 없을때 remove() 호출하면 NoSuchElementException 발생
		* */

		while(!(queue.size() == 1)) {
			queue.poll();
			queue.add(queue.poll());
		}
		System.out.println(queue.peek());
	}
}
