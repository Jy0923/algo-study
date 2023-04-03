package daijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bk_11657 {

	// 도시의 개수, 버스의 개수
	static int n, m;

	// 시작도시, 도착도시, 버스를 타고 이동하는데 걸리는 시간
	static int A, B, C;

	static long[] dist;

	static final long INF = Long.MAX_VALUE;

	static List<Node> edges = new ArrayList<>();

	static class Node implements Comparable<Node> {
		// 들어오는 정점
		int s;
		// 나가는 정점
		int e;
		// 가중치
		int w;

		public Node(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.w, o.w);
		}

	}

	static BufferedReader br;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			A = Integer.parseInt(input[0]);
			B = Integer.parseInt(input[1]);
			C = Integer.parseInt(input[2]);

			edges.add(new Node(A, B, C));
		}

		dist = new long[n + 1];
		Arrays.fill(dist, INF);

		// 1번 도시에서 출반
		dist[1] = 0;

		// 정점 개수만큼 반복
		for (int i = 1; i <= n; i++) {
			// 모든 간선 확인
			for (Node node : edges) {
				if (dist[node.s] == INF)
					continue;

				if (dist[node.e] > dist[node.s] + node.w) {
					dist[node.e] = dist[node.s] + node.w;

					if (i == n) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		
		for(int i=2; i<=n; i++) {
			if(dist[i] == INF) System.out.println(-1);
			else System.out.println(dist[i]);
		}

	}

}
