package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1759 {
    static int l;
    static int c;
    static char[] arr;
    static boolean[] visited;
    static char[] answer;
    static StringBuilder sb = new StringBuilder();

    public static boolean isValid() {
        int mo = 0;
        int ja = 0;

        for (char character : answer) {
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                mo++;
            } else {
                ja++;
            }
        }

        if (mo > 0 && ja > 1) {
            return true;
        }
        return false;
    }

    public static void dfs(int level, int depth) {
        if (level == l) {
            if (isValid()) {
                sb.append(answer);
                sb.append("\n");
            }
        } else {
            for (int i = depth; i < c; i++) {
                if(!visited[i]) {
                    answer[level] = arr[i];
                    visited[i] = true;
                    dfs(level + 1, i + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        visited = new boolean[c];
        answer = new char[l];
        arr = new char[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, 0);
        System.out.println(sb);
    }
}
