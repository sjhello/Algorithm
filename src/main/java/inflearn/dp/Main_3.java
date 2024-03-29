package inflearn.dp;

import java.util.Scanner;

/*
* 최댜부분증가수열
* */
public class Main_3 {
    static int[] dy;
    static int[] arr;

    public int solution() {
        int answer = 0;
        dy = new int[arr.length];
        dy[0] = 1;

        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
                dy[i] = max + 1;
                answer = Math.max(answer, dy[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main_3 main = new Main_3();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.solution());
    }
}
