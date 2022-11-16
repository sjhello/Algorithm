package programmers;

import java.util.Arrays;

/*
* LV 2
* 카펫
* */
public class Main_42842 {

	public static void main(String[] args) {
		System.out.println(15 / 4);
	}

	/*
	* brown >= 8
	* yellow >= 1
	* 카펫의 가로(행) 길이는 세로(열) 길이와 같거나, 세로 길이보다 길다
	* */
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int sum = brown + yellow;	// 전체 격자의 수

		// 노란색이 가운데에 오기 위해선 행과 열이 3이상 이어야 한다
		for (int i = 3; i <= sum; i++) {
			if (sum % i == 0) {		// row를 계산하는 연산이 몫만 표현하기 때문에 정확한 전체 사이즈 계산을 위해 이 조건이 필요함
				int column = i;	// 열, 세로
				int row = sum / column;	// 행, 가로

				if (row >= column) {
					if ((column - 2) * (row - 2) == yellow) {
						answer[0] = row;
						answer[1] = column;
					}
				}
			}
		}

		return answer;
	}
}
