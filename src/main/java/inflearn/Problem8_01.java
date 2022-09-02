package inflearn;

import java.util.Scanner;


/*
* 합이 같은 부분집합(DFS: 아마존 인터뷰)
* */
public class Problem8_01 {
    static String answer = "NO";
    static int n;       // 입력값의 갯수
    static int total = 0;   // 입력값의 모든 합
    static int[] arr;       // 입력값을 담을 배열
    static boolean flag = false;

    public void DFS(int level, int sum, int[] arr) {
        if (flag) {
            return;
        }

        if (level == n) {
            if ((total - sum) == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(level + 1, sum + arr[level], arr);
            DFS(level + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Problem8_01 problem = new Problem8_01();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        problem.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
