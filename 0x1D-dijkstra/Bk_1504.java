package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Bk_1504 {

	// 정점 개수, 간선의 개수
	static int V, E;

	// 인접리스트
	static List<List<Node>> graph;

	// 시작점에서부터 해당 정점까지의 최단 거리
	static int[] distance;

	static boolean[] visited;

	// 반드시 지나야 하는 간선
	static int A, B;

	static final int INF = Integer.MAX_VALUE;

	static class Node implements Comparable<Node> {
		int vertex;
		int cost;

		static ArrayList<Node> list = new ArrayList<Node>();

		public Node(int vertex, int cost) {
			this.vertex = vertex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);

		graph = new ArrayList<List<Node>>();

		// V+1개 -> 정점이 1부터 시작하므로
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<Node>());
		}

		distance = new int[V + 1];

		int a = 0, b = 0, c = 0;
		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);

			// 양반향 간선
			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		input = br.readLine().split(" ");
		A = Integer.parseInt(input[0]);
		B = Integer.parseInt(input[1]);

		int result1 = daijkstra(1, A);
		int result2 = daijkstra(A, B);
		int result3 = daijkstra(B, V);

		int ans1 = 0, ans2 = 0;
		if (result1 == INF || result2 == INF || result3 == INF)
			ans1 = INF;
		else ans1 = result1 + result2 + result3;

		result1 = daijkstra(1, B);
		result3 = daijkstra(A, V);
		if (result1 == INF || result2 == INF || result3 == INF)
			ans2 = INF;
		else ans2 = result1 + result2 + result3;

		if (ans1 == INF && ans2 == INF)
			System.out.println(-1);
		else
			System.out.println(Math.min(ans1, ans2));

	}

	private static int daijkstra(int v1, int v2) {

		Arrays.fill(distance, INF);

		PriorityQueue<Node> Q = new PriorityQueue<Node>();
		distance[v1] = 0;
		Q.add(new Node(v1, 0));

		while (!Q.isEmpty()) {
			Node node = Q.poll();

			int vertex = node.vertex;
			int cost = node.cost;

			if (cost > distance[vertex])
				continue;

			// 인접 노드들
			for (Node n : graph.get(vertex)) {
				if (cost + n.cost < distance[n.vertex]) {
					distance[n.vertex] = cost + n.cost;
					Q.add(new Node(n.vertex, distance[n.vertex]));
				}
			}

		}

		return distance[v2];

	}
}
