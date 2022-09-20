package baekjoon;

import java.util.*;

public class Main_1182 {
    static int n;
    static int s;
    static int answer;
    static int[] visited;
    static int[] numbers;

    public static void dfs(int level, int sum, int[] numbers) {
        if (level == n) {
            if (sum == s) {
                answer++;
            }
        } else {
            dfs(level + 1, sum + numbers[level], numbers);
            dfs(level + 1, sum, numbers);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        visited = new int[n];
        numbers = new int[n];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        Main_1182.dfs(0, 0, numbers);
        if (s == 0) {
            answer--;
        }
        System.out.println(answer);
    }
}
