package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bk_24479 {

	// 정점의 수, 간선 수, 시작 정점
	static int N, M, R;

	// 방문 여부 표기
	static int[] visited;

	static List<ArrayList<Integer>> graph = new ArrayList<>();

	static int cnt;

	static StringBuilder sb;
	static BufferedReader br;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);

		visited = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		// 간선 정보
		int u = 0, v = 0;
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");

			u = Integer.parseInt(input[0]);
			v = Integer.parseInt(input[1]);

			// 양방향 간선
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		// 오름차순 정렬
		for (int i = 1; i < graph.size(); i++) {
			// 그래프 간선 오름차순으로 정렬
			Collections.sort(graph.get(i));
		}

		cnt = 1;
		dfs(R);

		for (int i = 1; i < visited.length; i++) {
			sb.append(visited[i]).append("\n");
		}

		System.out.println(sb);

	}

	static void dfs(int r) {
		// 방문 표기
		visited[r] = cnt;

		List<Integer> list = graph.get(r);
		// 정점 번호
		for (int x : list) {
			if (visited[x] == 0) {
				cnt++;
				dfs(x);
			}
		}

	}
}
