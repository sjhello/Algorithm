package baekjoon;

import java.io.*;
import java.util.*;

/*
* N과 M(4)
* */
public class Main_15652 {
    static int n;
    static int m;
    static int[] numbers;
    static int[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int level, int depth) {
        if (level == m) {
            for (int number : answer) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = depth; i < numbers.length; i++) {
                answer[level] = numbers[i];
                dfs(level + 1, i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        answer = new int[m];
        numbers = new int[n];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        Main_15652.dfs(0, 0);
        System.out.println(sb);
    }
}
