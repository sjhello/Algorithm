package inflearn;

import java.util.Scanner;

/*
 * dfs 경로탐색
 * 백트래킹
 * 인접 행렬(2차원 배열)
 * 정점의 갯수가 작을때에는 사용 가능
 * 방향그래프에서의 1번 정점에서 N번 정점으로 가는 모든 경로의 갯수
 * 입력
 * 5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
* 출력
* 6
 * */
public class DFSRootSearch {
    static int[] visited;
    static int answer;
    static int n;
    static int m;
    static int[][] graph;
    static int[] arr;

    public void DFS(int L, int v) {
        if (n == v) {
            answer++;
            for (int i = 0; i <= n; i++) {
                if (arr[i] != 0) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        } else {
            for (int i = 1; i <= n; i++) {
                if (graph[v][i] == 1 && visited[i] == 0) { // 그래프를 순회하면서 정점에서 i번 정점으로 이동가능한지 체크, 재귀를 돌면서 방문하지 않은 정점 확인
                    visited[i] = 1;
                    arr[L + 1] = i;
                    DFS(L + 1, i);
                    arr[L + 1] = 0;     // 재귀 끝나고 나서 방문 했던 지점은 0 처리
                    visited[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        DFSRootSearch dfsRootSearch = new DFSRootSearch();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 정점의 수
        m = sc.nextInt();   // 간선의 수
        graph = new int[n + 1][n + 1];  // 인접행렬을 표현하는 그래프
        visited = new int[n + 1];       // 방문 정점 체크 배열
        arr = new int[n + 1];       // 가지 수 담는 배열

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();       // 행
            int b = sc.nextInt();       // 열
            graph[a][b] = 1;            // 간선 방향 그래프
        }

        visited[1] = 1;     // 시작에서 시작할때 방문했다고 체크
        arr[0] = 1;     // 가지 수 출력 시 항상 시작점은 1
        dfsRootSearch.DFS(0, 1);
        System.out.println(answer);
    }
}
