package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* N,M은 50이하의 자연수
* */
public class Main_1388 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int vertical = Integer.parseInt(st.nextToken());		// 세로의 크기
		int width = Integer.parseInt(st.nextToken());		// 가로의 크기

		int result = 0;
		char[][] arr = new char[vertical][width];

		for (int i = 0; i < vertical; i++) {
			arr[i] = br.readLine().toCharArray();		// i번째 줄 나무 판자
			for (int j = 0; j < width; j++) {
				if (arr[i][j] == '-') {
					result++;
					while (j < width && arr[i][j] == '-') {
						j++;
					}
				}
			}
		}

		for (int i = 0; i < width; i++) {
			for (int j = 0; j < vertical; j++) {
				if (arr[j][i] == '|') {
					result++;
					while (j < vertical && arr[j][i] == '|') {
						j++;
					}
				}
			}
		}
		System.out.println(result);

	}
}
