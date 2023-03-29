package daijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import javax.print.StreamPrintService;

public class Bk_13549 {

	// 수빈이가 있는 현재 점, 동생이 있는 현재 점
	static int N, K;

	static int[] dir = { -1, 1, 2 };
	static int[] addCost = { 1, 1, 0 };

	static int[] distance;

	static final int INF = Integer.MAX_VALUE;

	// static List<List<Integer>> graph;

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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		distance = new int[100002];

		Arrays.fill(distance, INF);

		daijkstra(N);

		System.out.println(distance[K]);
	}

	private static void daijkstra(int start) {
		PriorityQueue<Node> Q = new PriorityQueue<>();
		distance[start] = 0;
		Q.add(new Node(start, 0));

		while (!Q.isEmpty()) {
			Node node = Q.poll();
			int v = node.vertex;
			int c = node.cost;

			if (c > distance[v])
				continue;

			int nv = 0;
			for (int i = 0; i < 3; i++) {
				if (i == 2)
					nv = v * 2;
				else
					nv = v + dir[i];

				if (nv < 0 || nv > 100000)
					continue;

				if (c + addCost[i] < distance[nv]) {
					distance[nv] = c + addCost[i];
					Q.add(new Node(nv, distance[nv]));
				}
			}

		}
	}

}
