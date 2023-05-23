package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bk_1197 {

	// 정점의 개수, 간선의 개수
	static int V, E;

	static Edge[] graph;
	static boolean[] visited;

	static StringBuilder sb;
	static BufferedReader br;

	static int[] p;

	static class Edge {
		int in;
		int out;
		int cost;

		public Edge(int in, int out, int cost) {
			this.in = in;
			this.out = out;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);

		graph = new Edge[E];
		visited = new boolean[V + 1];
		int u = 0, d = 0, c = 0;
		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			u = Integer.parseInt(input[0]);
			d = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);

			graph[i] = new Edge(u, d, c);
		}

		Arrays.sort(graph, (a, b) -> Integer.compare(a.cost, b.cost));

		p = new int[V + 1];

		// 자기 자신을 부모로 만듦 -> 각각 서로소 집합 상태
		for (int i = 1; i <= V; i++) {
			p[i] = i;
		}

		int ans = 0, cnt = 0;
		for (int i = 0; i < E; i++) {
			Edge e = graph[i];

			int px = findSet(e.in);
			int py = findSet(e.out);

			// 이미 같은 집합, 사이클 존재
			if (px == py)
				continue;

			union(px, py);
			cnt++;
			ans += e.cost;

			if (cnt == V - 1)
				break;
		}

		System.out.println(ans);

	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);

		return p[x];
	}

	static void union(int x, int y) {
		p[x] = y;
	}

}
