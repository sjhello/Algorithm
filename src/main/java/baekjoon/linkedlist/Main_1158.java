package baekjoon.linkedlist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
* 큐, 링크드 리스트로 풀이 가능
* 요세푸스 문제
* */
public class Main_1158 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();		// 인원 수
		int k = sc.nextInt();		// k 번째 사람 부터 제거

		// List<Integer> result = linkedList(n, k);
		List<Integer> result = queue(n, k);


		if (n == 1 && k == 1) {
			bw.write("<" + result.get(0) + ">");
		} else {
			bw.write("<" + result.get(0));
			for (int i = 1; i < n; i++) {
				bw.write(", " + result.get(i));
			}
			bw.write(">");
		}

		bw.flush();
		bw.close();
	}

	public static List<Integer> linkedList(int n, int k) {
		List<Integer> linkedList = new LinkedList<>();		// 링크드 리스트
		List<Integer> answer = new ArrayList<>();		// 정답 배열
		k = k - 1;

		// 입력
		for (int i = 1; i <= n; i++) {
			linkedList.add(i);
		}

		for (int i = 0; i < n; i++) {
			int loop = k;
			/*
			* k 번째 사람부터 제거 해야하기 때문에 반복문에서는 loop가 0보다 크지 않을때까지 첫번째 원소를 뒤로 밀어줘야한다
			* */
			while (loop-- > 0) {		
				linkedList.add(linkedList.remove(0));
			}
			answer.add(linkedList.remove(0));
		}

		return answer;
	}

	public static List<Integer> queue(int n, int k) {
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> answer = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			queue.add(i + 1);
		}

		while (!queue.isEmpty()) {
			for (int i = 0; i < k - 1; i++) {
				queue.add(queue.remove());
			}
			answer.add(queue.remove());
		}

		return answer;
	}
}
