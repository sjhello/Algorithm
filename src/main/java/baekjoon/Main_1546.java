package baekjoon;

import java.util.Scanner;

public class Main_1546 {

    public static void main(String[] args) {
        // 입력
        Scanner sc = new Scanner(System.in);

        int subject = sc.nextInt();
        int[] scores = new int[subject];

        for (int i = 0; i < subject; i++) {
            scores[i] = sc.nextInt();
        }

        /*
        * 최대값 남기기
        * 과목 수를 모두 다 더한 값 남기기
        * 평균 구하기
        * */
        int max = 0;
        int hap = 0;

        for (int i = 0; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
            }
        }

        for (int i = 0; i < scores.length; i++) {
            hap += scores[i];
        }

        double result = hap * 100.0 / max / subject;
        System.out.println(result);
    }
}
