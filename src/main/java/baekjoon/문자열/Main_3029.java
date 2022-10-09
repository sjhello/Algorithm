package baekjoon.문자열;

import java.io.IOException;
import java.util.Scanner;

public class Main_3029 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String currentTime = sc.next();
		String natriumThrowTime = sc.next();

		sc.close();

		boolean isTimeSame = currentTime.equals(natriumThrowTime);

		if (isTimeSame) {
			System.out.println("24:00:00");
		} else {
			int h = Integer.parseInt(natriumThrowTime.split(":")[0]) - Integer.parseInt(currentTime.split(":")[0]);
			int m = Integer.parseInt(natriumThrowTime.split(":")[1]) - Integer.parseInt(currentTime.split(":")[1]);
			int s = Integer.parseInt(natriumThrowTime.split(":")[2]) - Integer.parseInt(currentTime.split(":")[2]);

			if (s < 0) {
				s += 60;
				--m;
			}

			if (m < 0) {
				m += 60;
				--h;
			}

			if (h < 0) {
				h += 24;
			}

			System.out.format("%02d:%02d:%02d", h, m, s);
		}
	}
}
