package inflearn;

import java.util.Scanner;


/*
* 바둑이 승차(DFS)
* */
public class Problem8_02 {
    static int answer = 0;
    static int c;
    static int n;
    static int[] weight;

    public void DFS(int level, int sum, int[] arr) {
        if (sum > c) {
            return ;
        }

        if (level == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(level + 1, arr[level] + sum, arr);
            DFS(level + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        c = sc.nextInt();   // 목표 무게(넘지않아야함)
        n = sc.nextInt();   // 바둑이
        weight = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        Problem8_02 problem8_02 = new Problem8_02();
        problem8_02.DFS(0, 0, weight);
        System.out.println(answer);
    }
}
