package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* LV 2
* 숫자 카드 나누기
* */
public class Main_135807 {

	public static void main(String[] args) {
		int[] arrayA = {10, 20};
		int[] arrayB = {5, 17};

		int solution = solution(arrayA, arrayB);
		System.out.println(solution);
	}

	public static int solution(int[] arrayA, int[] arrayB) {
		int answer = 0;

		// 최소값을 나눌 수 있는 수만 조건에 만족함
		// ex> 10을 나눌 수 있는 10 이하의 수
		int minA = Arrays.stream(arrayA).min().getAsInt();
		int minB = Arrays.stream(arrayB).min().getAsInt();

		Set<Integer> divideNumber = new HashSet<>();
		for (int i = 2; i <= minA; i++) {
			if (minA % i == 0) divideNumber.add(i);
		}
		for (int i = 2; i <= minB; i++) {
			if (minB % i == 0) divideNumber.add(i);
		}

		List<Integer> list = new ArrayList<>(divideNumber); 	// for loop에서 비교를 위해 set을 list에 저장

		// 철수, 영희 비교
		for (int i = 0; i < list.size(); i++) {
			boolean flag = true;
			// 철수 조건 확인
			for (int j = 0; j < arrayA.length; j++) {
				// 리스트에 있는 값이 철수가 들고있는 카드의 수를 나누지 못하거나, 영희가 들고있는 카드의 수를 나눈다면
				// 해당 수는 조건의 맞지 않는 값
				if (arrayA[j] % list.get(i) != 0 || arrayB[j] % list.get(i) == 0) {
					flag = false;
					break;
				}
			}

			if (flag) answer = Math.max(answer, list.get(i));	// 철수 phase에서 조건을 만족한다면 최대값 비교
			flag = true;	// 영희도 똑같이 해야하기 때문에 flag를 true로 설정

			// 영희 조건 확인
			for (int j = 0; j < arrayA.length; j++) {
				if (arrayB[j] % list.get(i) != 0 || arrayA[j] % list.get(i) == 0) {
					flag = false;
					break;
				}
			}

			if (flag) answer = Math.max(answer, list.get(i));	// 영희 phase에서 조건을 만족한다면 최대값 비교
		}

		return answer;
	}
}
