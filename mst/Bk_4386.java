package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Bk_4386 {

	// 정점의 개수, 간선의 개수
	static int N;

	static StringBuilder sb;
	static BufferedReader br;

	static Node[] loc;
	static int[] parent;

	static class Node {
		double row, col;

		public Node(double row, double col) {
			this.row = row;
			this.col = col;
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

		N = Integer.parseInt(br.readLine());
		loc = new Node[N + 1];
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++)
			parent[i] = i;

		String[] input = null;
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			double r = Double.parseDouble(input[0]);
			double c = Double.parseDouble(input[1]);

			loc[i] = new Node(r, c);
		}

		PriorityQueue<Edge> Q = new PriorityQueue<>();
		for (int i = 1; i <= N - 1; i++) {
			for (int j = i + 1; j <= N; j++) {
				Node node1 = loc[i];
				Node node2 = loc[j];

				double cost = Math.sqrt(Math.pow(node1.row - node2.row, 2) + Math.pow(node1.col - node2.col, 2));
				Q.add(new Edge(i, j, cost));
			}
		}

		int cnt = 0;
		double ans = 0;
		while (!Q.isEmpty()) {
			Edge edge = Q.poll();
			int v1 = edge.u;
			int v2 = edge.d;

			int px = findSet(v1);
			int py = findSet(v2);

			if (px == py)
				continue;

			union(px, py);
			cnt++;
			ans += edge.cost;

			if (cnt == N - 1)
				break;
		}

		System.out.println(ans);
	}

	static void union(int x, int y) {
		parent[x] = y;
	}

	static int findSet(int x) {
		if (parent[x] != x)
			parent[x] = findSet(parent[x]);
		return parent[x];
	}
}
