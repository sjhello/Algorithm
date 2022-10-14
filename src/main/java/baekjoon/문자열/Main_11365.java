package baekjoon.문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11365 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer bf;
		String answer;

		while (true) {
			String line = br.readLine();
			if (line.equals("END")) {
				break;
			}

			bf = new StringBuffer(line);
			answer = bf.reverse().toString();
			System.out.println(answer);
		}
	}
}
