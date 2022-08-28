package inflearn;

/*
* 부분 집합 구하기
* 입력: 3
* 출력
* 1 2 3
* 1 2
* 1 3
* 1
* 2 3
* 2
* 3
* */
public class Subset {
    static int n;       // 입력
    static int[] check;

    public void DFS(int level) {
        if (level == n + 1) {
            for (int i = 1; i <= n; i++) {
                if (check[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            check[level] = 1;
            DFS(level + 1);
            check[level] = 0;
            DFS(level + 1);
        }
    }

    public static void main(String[] args) {
        Subset subset = new Subset();
        n = 3;
        check = new int[n + 1];

        subset.DFS(1);
    }
}
