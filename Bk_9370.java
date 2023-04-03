package daijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Bk_9370 {

	static int T;

	// 교차로, 도로, 목적지 후보
	static int n, m, t;
	// 출발지, 지나는 교차로
	static int s, g, h;

	static int a, b, d;

	static int[] solution;

	static List<List<Node>> edges = new ArrayList<>();
	static PriorityQueue<Node> Q;

	static int[] S;
	static int[] G;
	static int[] H;

	static int INF = Integer.MAX_VALUE;

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

	static BufferedReader br;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			String[] input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			t = Integer.parseInt(input[2]);

			for (int i = 0; i <= n; i++) {
				edges.add(new ArrayList<>());
			}

			solution = new int[t];

			input = br.readLine().split(" ");
			s = Integer.parseInt(input[0]);
			g = Integer.parseInt(input[1]);
			h = Integer.parseInt(input[2]);

			for (int i = 0; i < m; i++) {
				input = br.readLine().split(" ");
				a = Integer.parseInt(input[0]);
				b = Integer.parseInt(input[1]);
				d = Integer.parseInt(input[2]);

				// 양방향 간선
				edges.get(a).add(new Node(b, d));
				edges.get(b).add(new Node(a, d));
			}

			S = solution(s);
			G = solution(g);
			H = solution(h);

			int idx = 0;
			for (int i = 0; i < t; i++) {
				int target = Integer.parseInt(br.readLine());

				int x = S[g] + G[h] + H[target];
				int y = S[h] + H[g] + G[target];

				if (x == S[target] || y == S[target]) {
					solution[idx++] = target;
				}
			}

			Arrays.sort(solution);

			for (int i = 0; i < t; i++) {
				if (solution[i] != 0)
					sb.append(solution[i] + " ");
			}

			sb.append("\n");
			edges.clear();
		}
		System.out.println(sb);

	}

	static int[] solution(int start) {
		int[] distance = new int[n + 1];
		Arrays.fill(distance, INF);

		Q = new PriorityQueue<>();

		Q.add(new Node(start, 0));
		distance[start] = 0;

		while (!Q.isEmpty()) {
			Node node = Q.poll();

			int vertex = node.vertex;
			int cost = node.cost;

			if (cost > distance[vertex])
				continue;

			for (Node linkedNode : edges.get(vertex)) {
				if (cost + linkedNode.cost < distance[linkedNode.vertex]) {
					distance[linkedNode.vertex] = cost + linkedNode.cost;
					Q.add(new Node(linkedNode.vertex, distance[linkedNode.vertex]));
				}
			}

		}

		return distance;
	}

}
