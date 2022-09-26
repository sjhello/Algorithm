package baekjoon;

import java.util.Scanner;

/*
* 계단 오르기
* */
public class Main_2579 {
    static int[] dy;
    static int[] numbers;

    public static int solution(int n) {
        dy[1] = numbers[1];

        if (n >= 2) {
            dy[2] = numbers[1] + numbers[2];
        }
        for (int i = 3; i <= n; i++) {
            dy[i] = Math.max(dy[i - 3] + numbers[i - 1] + numbers[i], dy[i - 2] + numbers[i]);
        }

        return dy[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n + 1];
        numbers = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println(solution(n));
    }
}
