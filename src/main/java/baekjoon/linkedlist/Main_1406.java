package baekjoon.linkedlist;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/*
* ListIterator 사용 <- 실제 커서
* 에디터
* */
public class Main_1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// input
		String str = br.readLine();
		List<Character> list = new LinkedList<>();	// util.LinkedList는 이중 연결 리스트
		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}
		int n = Integer.parseInt(br.readLine());

		// 구현
		ListIterator<Character> iter = list.listIterator();

		// 다음 원소가 존재한다면 커서의 위치를 옮긴다
		// 커서를 맨 마지막으로 옮긴다
		while (iter.hasNext()) {
			iter.next();
		}

		for (int i = 0; i < n; i++) {
			String[] command = br.readLine().split(" ");

			if (command[0].equals("L")) {
				if (iter.hasPrevious()) {
					iter.previous();
				}
			}

			if (command[0].equals("D")) {
				if (iter.hasNext()) {
					iter.next();
				}
			}

			if (command[0].equals("B")) {
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			}

			if (command[0].equals("P")) {
				iter.add(command[1].charAt(0));
			}
		}

		for (char s : list) {
			bw.write(s);
		}

		bw.flush();
		bw.close();
	}
}
