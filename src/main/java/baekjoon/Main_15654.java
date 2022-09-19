package baekjoon;

import java.util.*;

public class Main_15654 {
    static int n;
    static int m;
    static ArrayList<Integer> numbers;
    static int[] visited;
    static int[] answer;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int level) {
        if (level == m) {
            for (int number : answer) {
                sb.append(number).append(" ");
            }
            sb.append("\n");
        } else {
            for (int i = 0; i < numbers.size(); i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    answer[level] = numbers.get(i);
                    dfs(level + 1);
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        visited = new int[n];
        answer = new int[m];
        numbers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }

        Collections.sort(numbers);

        Main_15654.dfs(0);
        System.out.println(sb);
    }
}
