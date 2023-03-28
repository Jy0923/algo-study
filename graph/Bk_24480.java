package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bk_24480 {

	// 정점의 수와 간선의 수, 시작 정점
	static int N, M, R;

	// 그래프
	static List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	static int[] visited;

	static int cnt = 1;

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

		int u = 0, v = 0;

		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");

			u = Integer.parseInt(input[0]);
			v = Integer.parseInt(input[1]);

			// 양방향 간선 추가
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		dfs(R);
		
		for(int i=1; i<=N; i++) {
			sb.append(visited[i] + "\n");
		}
		
		System.out.println(sb);
	}

	static void dfs(int r) {
		visited[r] = cnt++;
		List<Integer> list = graph.get(r);
		Collections.sort(list, (o1, o2) -> o2 - o1);

		int cur = 0;
		for (int i = 0; i < list.size(); i++) {
			cur = list.get(i);
			if(visited[cur] == 0) dfs(cur);
		}

	}

}
