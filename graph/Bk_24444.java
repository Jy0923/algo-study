package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bk_24444 {

	static int N, M, R;
	static List<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] visited;
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

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		int u = 0, v = 0;
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");

			u = Integer.parseInt(input[0]);
			v = Integer.parseInt(input[1]);

			// 양방향 간선 연결
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		// 오름차순으로 간선 정렬
		for (int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}

		cnt = 1;
		visited = new int[N + 1];
		
		bfs(R);
		
		for(int i=1; i<=N; i++) {
			sb.append(visited[i] + "\n");
		}
		
		System.out.println(sb);
		
	}

	static Queue<ArrayList<Integer>> queue = new LinkedList<ArrayList<Integer>>();

	static void bfs(int r) {
		visited[r] = cnt++;

		queue.add(graph.get(r));

		while (!queue.isEmpty()) {
			List<Integer> list = queue.poll();
			for (int x : list) {
				if (visited[x] == 0) {
					visited[x] = cnt++;
					queue.add(graph.get(x));
				}
			}
		}

	}
}
