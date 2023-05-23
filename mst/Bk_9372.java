package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Bk_9372 {

	static BufferedReader br;
	static StringBuilder sb;

	static int T;
	static int N, M;

	static int[] distance;
	static boolean[] visited;

	static List<Node>[] edges;

	static final int INF = Integer.MAX_VALUE;

	static class Node implements Comparable<Node> {
		int v, c;

		public Node(int v, int c) {
			this.v = v;
			this.c = c;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.c, o.c);
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);

			edges = new ArrayList[N + 1];

			for (int i = 1; i <= N; i++)
				edges[i] = new ArrayList<>();

			int a = 0, b = 0;
			for (int i = 0; i < M; i++) {
				input = br.readLine().split(" ");

				a = Integer.parseInt(input[0]);
				b = Integer.parseInt(input[1]);

				edges[a].add(new Node(b, 1));
				edges[b].add(new Node(a, 1));
			}

			int choice = 0;
			distance = new int[N + 1];
			visited = new boolean[N + 1];

			Arrays.fill(distance, INF);

			PriorityQueue<Node> Q = new PriorityQueue<Node>();
			Q.add(new Node(1, 0));

			int ans = 0;
			while (choice != N) {
				Node node = Q.poll();
				int v = node.v;
				int c = node.c;

				if (visited[v])
					continue;

				visited[v] = true;
				ans += c;
				choice++;

				Q.addAll(edges[v]);
			}

			sb.append(ans + "\n");

		}
		System.out.println(sb);
	}

}
