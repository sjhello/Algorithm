package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2606_DFSArrayList {
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> list;      // 인접 리스트
    static int[] visited;
    static int answer;

    public static void DFS(int computer) {
        visited[computer] = 1;

        for (int num : list.get(computer)) {
            if (visited[num] == 0) {
                answer++;
                DFS(num);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        list = new ArrayList<>();
        visited = new int[n+1];

        for (int i = 0; i <= n; i++) {
            list.add(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        Main_2606_DFSArrayList.DFS(1);
        System.out.println(answer);

    }
}
