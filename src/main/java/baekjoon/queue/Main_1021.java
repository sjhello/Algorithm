package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
* 회전하는 큐
* 중간지점 생각
* Deque
* */
public class Main_1021 {
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] firstLine = br.readLine().split(" ");

		int n = Integer.parseInt(firstLine[0]);
		LinkedList<Integer> deque = createDeque(n);

		int m = Integer.parseInt(firstLine[1]);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int middleIndex = getMiddleIndex(deque);
			int numIndex = deque.indexOf(Integer.parseInt(st.nextToken()));

			solution(deque, middleIndex, numIndex);
		}

		System.out.println(answer);
	}

	private static void solution(LinkedList<Integer> deque, int middleIndex, int numIndex) {
		if (numIndex <= middleIndex) {
			// 왼쪽으로 이동
			for (int j = 0; j < numIndex; j++) {
				Integer first = deque.pollFirst();
				deque.offerLast(first);
				answer++;
			}
		} else {
			// 오른쪽으로 이동
			for (int j = 0; j < deque.size() - numIndex; j++) {
				Integer last = deque.pollLast();
				deque.offerFirst(last);
				answer++;
			}
		}
		deque.pollFirst();		// 첫번째 원소 뽑아내기
	}

	private static int getMiddleIndex(LinkedList<Integer> deque) {
		int middleIndex = 0;
		if (deque.size() % 2 == 0) {
			middleIndex = deque.size() / 2 - 1;
		} else {
			middleIndex = deque.size() / 2;
		}
		return middleIndex;
	}

	private static LinkedList<Integer> createDeque(int n) {
		LinkedList<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			deque.add(i);
		}
		return deque;
	}
}
