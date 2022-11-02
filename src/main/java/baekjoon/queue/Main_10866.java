package baekjoon.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/*
* Deque
* */
public class Main_10866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> deque = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");

			switch (str[0]) {
				case "push_front":
					deque.addFirst(Integer.parseInt(str[1]));
					break;
				case "push_back":
					deque.addLast(Integer.parseInt(str[1]));
					break;
				case "pop_front":
					Integer frontNumber = deque.pollFirst();
					if (Objects.isNull(frontNumber)) {
						System.out.println(-1);
					} else {
						System.out.println(frontNumber);
					}
					break;
				case "pop_back":
					Integer backNumber = deque.pollLast();
					if (Objects.isNull(backNumber)) {
						System.out.println(-1);
					} else {
						System.out.println(backNumber);
					}
					break;
				case "size":
					System.out.println(deque.size());
					break;
				case "empty":
					System.out.println(deque.isEmpty() ? 1 : 0);
					break;
				case "front":
					Integer front = deque.peekFirst();
					if (Objects.isNull(front)) {
						System.out.println(-1);
					} else {
						System.out.println(front);
					}
					break;
				case "back":
					Integer last = deque.peekLast();
					if (Objects.isNull(last)) {
						System.out.println(-1);
					} else {
						System.out.println(last);
					}
					break;
			}
		}
	}
}
