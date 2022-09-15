package baekjoon;

import java.util.*;


/*
* N과 M(1)
* 백트래킹
* */
public class Main_15649 {
    static int n;
    static int m;
    static int[] numbers;       // 입력
    static boolean[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int level) {
        if (level == m) {
            for (int number : answer) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    answer[level] = numbers[i];
                    dfs(level + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        numbers = new int[n];
        visited = new boolean[n];
        answer = new int[m];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        Main_15649.dfs(0);
        System.out.println(sb);
    }
}
