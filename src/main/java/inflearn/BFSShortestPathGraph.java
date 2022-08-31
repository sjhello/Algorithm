package inflearn;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
* bfs
* 그래프 최단거리
* 1번 정점에서 각 정점으로 가는 최소 이동 간선 수
* 입력
* 6 9
1 3
1 4
2 1
2 5
3 4
4 5
4 6
6 2
6 5
* 출력
* 2 : 3
3 : 1
4 : 1
5 : 2
6 : 2
* */
public class BFSShortestPathGraph {
    static int n;   // 정점의 갯수
    static int m;   // 간선의 갯수
    static int[] visited;
    static int[] dis;
    static ArrayList<ArrayList<Integer>> graph;

    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[1] = 1;
        dis[v] = 0;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            for (int nv : graph.get(current)) {
                if (visited[nv] == 0) {
                    visited[nv] = 1;
                    queue.offer(nv);
                    dis[nv] = dis[current] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        BFSShortestPathGraph bfsShortestPathGraph = new BFSShortestPathGraph();

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        visited = new int[n + 1];
        dis = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }

        bfsShortestPathGraph.BFS(1);
        for (int i = 2; i <= n; i++) {
            System.out.print(i + " : " + dis[i]);
            System.out.println();
        }
    }
}
