package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11660 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /*
        * 2차원 배열의 크기, 구간 합 질의의 갯수
        * 2차원 배열의 크기 만큼의 2차원 배열 정의
        * 질의 갯수만큼의 숫자 입력(좌표 ~ 좌표 까지의 구간 합)
        * */

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 원본 배열
        int [][] originArray = new int[a + 1][a + 1];
        for (int i = 1; i <= a; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= a; j++) {
                originArray[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구간 합 배열
        int [][] hapArray = new int[a + 1][a + 1];
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= a; j++) {
                hapArray[i][j] = hapArray[i][j-1] + hapArray[i-1][j] - hapArray[i-1][j-1] + originArray[i][j];
            }
        }

        int result = 0;
        for (int i = 0; i < b; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            result = hapArray[x2][y2] - hapArray[x1-1][y2] - hapArray[x2][y1-1] + hapArray[x1-1][y1-1];
            System.out.println(result);
        }
    }
}
