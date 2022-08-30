package inflearn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem8_05 {

    static int n;
    static int m;
    static Integer[] coin;
    static int answer = Integer.MAX_VALUE;      // 최소값을 찾기 위함

    public void DFS(int level, int sum) {
        if (sum > m || level >= answer) {
            return ;
        }

        if (sum == m) {
            answer = Math.min(answer, level);
        } else {
            for (int i = 0; i < coin.length; i++) {
                DFS(level + 1, sum + coin[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();       // 동전 종류의 개수
        coin = new Integer[n];

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        m = sc.nextInt();       // 거슬러줄 금액

        Arrays.sort(coin, Comparator.reverseOrder());
        Problem8_05 problem = new Problem8_05();
        problem.DFS(0, 0);
        System.out.println(answer);
    }
}
