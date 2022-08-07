package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10986 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		/*
		* 입력
		* N: 수의 갯수
		* M: 나눌 수
		* A: 합 배열
		* B: 같은 나머지의 갯수 세는 배열
		* mod: 나머지 연산의 값
		* result: 결과
		* */
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[] A = new long[N];		// 두개의 int를 더해서 int값을 벗어날수도 있기 떄문에 long으로 초기화

		st = new StringTokenizer(br.readLine());
		A[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
		}

		long result = 0;
		long[] B = new long[M];
		
		for (int i = 0; i < N; i++) {
			int mod = (int) (A[i] % M);

			if (mod == 0) {
				result++;
			}

			B[mod]++;
		}

		for (int i = 0; i < M; i++) {
			if (B[i] > 1) {
				result = result + (B[i] * (B[i] -1) / 2);
			}
		}

		System.out.println(result);
	}
}
