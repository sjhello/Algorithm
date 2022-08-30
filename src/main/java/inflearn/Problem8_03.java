package inflearn;

import java.util.Scanner;

public class Problem8_03 {

    static int m;
    static int n;
    static int answer = 0;

    public void DFS(int level, int sum, int time, int[] timeArr, int[] scoreArr) {
        if (time > m) {
            return;
        }

        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(level + 1, sum + scoreArr[level], time + timeArr[level], timeArr, scoreArr);
            DFS(level + 1, sum, time, timeArr, scoreArr);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   // 문제 갯수
        m = sc.nextInt();   // 제한시간

        int[] scoreArr = new int[n];
        int[] timeArr = new int[n];

        for (int i = 0; i < n; i++) {
            scoreArr[i] = sc.nextInt();   // 문제당 점수
            timeArr[i] = sc.nextInt();    // 푸는데 걸리는 시간
        }

        Problem8_03 problem = new Problem8_03();
        problem.DFS(0, 0, 0, timeArr, scoreArr);
        System.out.println(answer);
    }
}
