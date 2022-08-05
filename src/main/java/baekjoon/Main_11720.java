package baekjoon;

import java.util.Scanner;

public class Main_11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int first = sc.nextInt();
        String second = sc.next();
        char[] secondNum = second.toCharArray();

        int sum = 0;
        for (int i = 0; i < secondNum.length; i++) {
            sum += secondNum[i] - '0';
        }

        System.out.println(sum);
    }
}
