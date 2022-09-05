package baekjoon;

import java.io.*;
import java.util.*;


/*
* DFS 인접 행렬 풀이
* */
public class Main_2606_DFS {
    static int n;   // 컴퓨터의 수
    static int m;   // 네트워크 상에서 직접 연결되어있는 컴퓨터 쌍의 수
    static int[][] network;   // 네트워크 표현, 인접행렬
    static int answer;
    static int[] visited;

    public static void DFS(int computer) {
        visited[computer] = 1;

        for (int i = 1; i <= n; i++) {
            if (network[computer][i] == 1 && visited[i] == 0) {
                answer++;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        network = new int[n + 1][n + 1];
        visited = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            network[a][b] = 1;
            network[b][a] = 1;
        }

        Main_2606_DFS.DFS(1);
        System.out.println(answer);

    }
}
