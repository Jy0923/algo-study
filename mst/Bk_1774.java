package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Bk_1774 {

	// 정점의 개수, 간선의 개수
	static int N, M;

	static StringBuilder sb;
	static BufferedReader br;

	static Node[] loc;
	static int[] parent;

	static class Node {
		int row, col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Node [row=" + row + ", col=" + col + "]";
		}

	}

	static class Edge implements Comparable<Edge> {

		int u, d;
		double cost;

		public Edge(int u, int d, double cost) {
			this.u = u;
			this.d = d;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		loc = new Node[N + 1];
		int r = 0, c = 0;
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			r = Integer.parseInt(input[0]);
			c = Integer.parseInt(input[1]);

			loc[i] = new Node(r, c);
		}

		PriorityQueue<Edge> Q = new PriorityQueue<Edge>();
		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {

				Node node1 = loc[i];
				Node node2 = loc[j];

				double cost = Math.sqrt(Math.pow(node1.row - node2.row, 2) + Math.pow(node1.col - node2.col, 2));
				Q.add(new Edge(i, j, cost));
			}
		}

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);

			int px = findSet(x);
			int py = findSet(y);

			if (px != py) {
				union(px, py);
				cnt++;
			}
		}

		double ans = 0;
		while (!Q.isEmpty()) {
			Edge edge = Q.poll();

			int px = findSet(edge.u);
			int py = findSet(edge.d);

			if (px == py)
				continue;

			union(px, py);
			cnt++;
			ans += edge.cost;

			if (cnt == N - 1)
				break;

		}

		System.out.printf("%.2f", ans);

	}

	static int findSet(int x) {
		if (parent[x] != x)
			parent[x] = findSet(parent[x]);
		return parent[x];
	}

	static void union(int x, int y) {
		parent[x] = y;
	}

}
