package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bk_1967_bfs {

	static StringBuilder sb;
	static BufferedReader br;

	static int N;

	static List<Node>[] edges;

	static boolean[] visited;

	static int end;

	static int max;

	static class Node {
		int v;
		int cost;

		public Node(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		edges = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++)
			edges[i] = new ArrayList<>();

		String[] input = null;
		int a = 0, b = 0, c = 0;
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			for (int j = 1; j + 1 < input.length; j += 2) {
				b = Integer.parseInt(input[j]);
				c = Integer.parseInt(input[j + 1]);

				edges[a].add(new Node(b, c));
			}
		}

		// 루트에서 가장 먼 거리의 노드 구하기
		visited = new boolean[N + 1];
		max = Integer.MIN_VALUE;
		bfs(1);

		// 루트에서 가장 먼거리의 노드에서 가장 멀리 떨어진 노드 구하기
		visited = new boolean[N + 1];
		max = Integer.MIN_VALUE;
		bfs(end);

		System.out.println(max);
	}

	private static void bfs(int cur) {
		Queue<Node> Q = new LinkedList<Node>();
		Q.add(new Node(cur, 0));
		visited[cur] = true;

		while (!Q.isEmpty()) {
			Node node = Q.poll();
			int v = node.v;
			int c = node.cost;


			if(max < c) {
				max = c;
				end = v;
			}
			
			for (Node next : edges[v]) {
				if (visited[next.v]) continue;
				
				visited[next.v] = true;
				Q.add(new Node(next.v, c + next.cost));
			}

		}
	}

}
