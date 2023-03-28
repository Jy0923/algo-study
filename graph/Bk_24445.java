package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bk_24445 {

	static int N, M, R;
	static List<ArrayList<Integer>> graph = new ArrayList<>();
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

			// 양방향 간선 연결
			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		bfs(R);
		
		for(int i=1; i<=N; i++) {
			sb.append(visited[i] + "\n");
		}
		
		System.out.println(sb);

	}

	private static void bfs(int r) {

		Queue<Integer> Q = new LinkedList<Integer>();

		visited[r] = cnt++;
		Q.add(r);

		int data = 0;
		while (!Q.isEmpty()) {
			List<Integer> list = graph.get(Q.poll());

			Collections.sort(list, (o1, o2) -> o2 - o1);
			
			for (int i = 0; i < list.size(); i++) {
				data = list.get(i);
				if (visited[data] == 0) {
					visited[data] = cnt++;
					Q.add(data);
				}
			}
		}
	}

}
