package inflearn;


import java.util.ArrayList;
import java.util.Scanner;

/*
* dfs 경로탐색
* 백트래킹
* 인접 리스트
* 정점의 갯수가 작을때에는 인접행렬(2차원 배열)로 해결 할 수 있지만
* 정점의 갯수가 무수히 많아지면 인접행렬을 for문을 돌면서 작성하는 것은
* 시간 복잡도, 메모리 측면에서 비효율
* 때문에 ArrayList를 사용하여 인접 리스트로 표현하는 것이 유리하다
* 방향그래프에서의 1번 정점에서 N번 정점으로 가는 모든 경로의 갯수
* 입력
*5 9
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
public class DFSRootSearch2 {
    static int[] visited;
    static int answer;
    static int n;
    static int m;
    static ArrayList<ArrayList<Integer>> graph;

    public void DFS(int v) {
        if (n == v) {
            answer++;
        } else {
            for (int nv : graph.get(v)) {   // v번째 리스트에 있는 리스트를 꺼내서 그 안의 원소를 순회
                if (visited[nv] == 0) {
                    visited[nv] = 1;
                    DFS(nv);
                    visited[nv] = 0;
                }
            }
        }
    }


    public static void main(String[] args) {
        DFSRootSearch2 dfsRootSearch2 = new DFSRootSearch2();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();   // 정점의 수
        m = sc.nextInt();   // 간선의 수
        graph = new ArrayList<>();  // 인접 리스트
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new int[n + 1];       // 방문 정점 체크 배열

        for (int i = 0; i < m; i++) {   //
            int a = sc.nextInt();       // 행
            int b = sc.nextInt();       // 열
            graph.get(a).add(b);            // 방향 그래프
        }

        visited[1] = 1;     // 시작에서 시작할때 방문했다고 체크
        dfsRootSearch2.DFS(1);
        System.out.println(answer);
    }
}
