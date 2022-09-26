package inflearn.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
* 가장 높은 탑 쌓기
* */
public class Main_4 {
    static int[] dy;

    static class Brick implements Comparable<Brick> {
        int s;      // 넓이
        int h;      // 높이
        int w;      // 무게

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            /*
            * 0 = 같은 수
            * 음수 = 작은 수
            * 양수 = 큰 수
            * */
            return this.s - o.s;        // 오름차순
//            return o.s - this.s;    // 내림차순
        }
    }

    public int solution(ArrayList<Brick> brickArrayList) {
        int answer = 0;
        Collections.sort(brickArrayList);
        dy[0] = brickArrayList.get(0).h;
        answer = dy[0];

        for (int i = 0; i < brickArrayList.size(); i++) {
            int maxHeight = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (brickArrayList.get(j).w > brickArrayList.get(i).w && dy[j] > maxHeight) {
                    maxHeight = dy[j];
                }
            }
            dy[i] = maxHeight + brickArrayList.get(i).h;
            answer = Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main_4 main = new Main_4();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Brick> brickArrayList = new ArrayList<>();
        dy = new int[n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            brickArrayList.add(new Brick(s, h, w));
        }
        System.out.println(main.solution(brickArrayList));
    }
}
