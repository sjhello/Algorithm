package baekjoon;

import java.util.*;

public class Main_15655 {
    static int n;
    static int m;
    static int[] answer;
    static int[] numbers;
    static int[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int level, int depth) {
        if (level == m) {
            for (int number : answer) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = depth; i < numbers.length; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    answer[level] = numbers[i];
                    dfs(level + 1, i + 1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer = new int[m];
        visited = new int[n];
        numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);

        Main_15655.dfs(0, 0);
        System.out.println(sb);
    }
}
