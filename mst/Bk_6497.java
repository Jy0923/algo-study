package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Bk_6497 {

	static StringBuilder sb;
	static BufferedReader br;

	// 테케
	static int T;

	// 집의 개수, 간선
	static int N, M;

	static List<Node>[] edges;

	static class Node implements Comparable<Node> {
		int vertex;
		int cost;

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
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		while (true) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);

			if (N == 0 && M == 0)
				break;

			edges = new ArrayList[N];

			for (int i = 0; i < N; i++)
				edges[i] = new ArrayList<>();

			int u = 0, d = 0, c = 0;
			int totalCost = 0;
			for (int i = 0; i < M; i++) {
				input = br.readLine().split(" ");
				u = Integer.parseInt(input[0]);
				d = Integer.parseInt(input[1]);
				c = Integer.parseInt(input[2]);
				totalCost += c;

				edges[u].add(new Node(d, c));
				edges[d].add(new Node(u, c));
			}

			solution(0, totalCost);

		}

		System.out.println(sb);

	}

	static boolean[] visited;
	static PriorityQueue<Node> Q;

	private static void solution(int start, int totalCost) {
		visited = new boolean[N];
		Q = new PriorityQueue<>();
		Q.add(new Node(start, 0));

		int cost = 0, choice = 0;
		while (choice != N) {
			Node node = Q.poll();

			if (visited[node.vertex])
				continue;

			visited[node.vertex] = true;
			cost += node.cost;
			choice++;

			Q.addAll(edges[node.vertex]);
		}

		sb.append((totalCost - cost) + "\n");
	}

}
