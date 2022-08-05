package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11659 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        // 1. 데이터의 수
        // 2. 질의 개수
        // 3. 합 배열
        // 4. 질의 갯수만큼의 i ~ j 구간 합 구하기

        int count = Integer.parseInt(st.nextToken());
        int queryCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // 합 배열
        // 0 번째 원소는 빈 방
        int[] hap = new int[count + 1];
        for (int i = 1; i <= count; i++) {
            hap[i] = hap[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < queryCount; i++) {
            st = new StringTokenizer(br.readLine());
            int iNumber = Integer.parseInt(st.nextToken());
            int jNumber = Integer.parseInt(st.nextToken());
            System.out.println(hap[jNumber] - hap[iNumber -1]);
        }

    }
}
