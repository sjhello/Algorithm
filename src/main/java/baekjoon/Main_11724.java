package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11724 {
	static ArrayList<Integer>[] list;
	static boolean[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());	// 노드 수
		int e = Integer.parseInt(st.nextToken());	// 에지 갯수
		list = new ArrayList[n+1];	// 인접 리스트
		arr = new boolean[n+1];		// 방문 배열

		for (int i = 1; i < n + 1 ; i++) {		// 리스트 초기화
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < e; i++) {		// 에지 입력
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// 양방향이라서 서로 연결
			list[a].add(b);
			list[b].add(a);
		}

		int result = 0;		// 연결요소의 갯수(그래프의 갯수)
		for (int i = 1; i < n + 1; i++) {
			if(arr[i] == false) {
				result++;
				DFS(i);
			}
		}

		System.out.println(result);
	}

	static void DFS(int v) {
		if (arr[v]) {
			return ;
		}

		arr[v] = true;		// 첫방문인 경우 방문했다고 표시
		for(int num : list[v]) {	// 인접 노드가 여러개인 경우 루프실행
			if (arr[num] == false) {		// 해당 노드에 방문하지 않았다면 탐색 실행
				DFS(num);
			}
		}
	}
}
