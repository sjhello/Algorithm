package baekjoon.queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Objects;

/*
* sout은 느리다
* */
public class Main_10845 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");

			switch (str[0]) {
				case "push":
					queue.add(Integer.parseInt(str[1]));
					break;
				case "pop":
					Integer popNumber = queue.poll();
					if (Objects.isNull(popNumber)) {
						bw.write("-1\n");
					} else {
						bw.write(popNumber + "\n");
					}
					break;
				case "size":
					bw.write(queue.size() + "\n");
					break;
				case "empty":
					int isEmpty = queue.isEmpty() ? 1 : 0;
					bw.write(isEmpty + "\n");
					break;
				case "front":
					Integer frontNumber = queue.peekFirst();
					if (Objects.isNull(frontNumber)) {
						bw.write("-1\n");
					} else {
						bw.write(frontNumber + "\n");
					}
					break;
				case "back":
					Integer backNumber = queue.peekLast();
					if (Objects.isNull(backNumber)) {
						bw.write("-1\n");
					} else {
						bw.write(backNumber + "\n");
					}
					break;
			}
		}

		bw.flush();
		bw.close();
	}
}
