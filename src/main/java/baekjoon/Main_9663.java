package baekjoon;

import java.io.*;
import java.util.*;

/*
* N-Queen
* */
public class Main_9663 {
    static int n;
    static int answer;
    static int[] board;

    public static void dfs(int level) {
        if (level == n) {
            answer++;
        } else {
            for (int i = 0; i < n; i++) {
                board[level] = i;

                if (isOk(level)) {
                    dfs(level + 1);
                }
            }
        }
    }

    public static boolean isOk(int level) {

        for (int i = 0; i < level; i++) {
            if (board[i] == board[level]) {
                return false;
            }

            else if (Math.abs(level - i) == Math.abs(board[level] - board[i])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n];

        Main_9663.dfs(0);
        System.out.println(answer);
    }
}
