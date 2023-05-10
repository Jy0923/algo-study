package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bk_1167_dfs {

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
		dfs(1, 0);

		// 루트에서 가장 먼거리의 노드에서 가장 멀리 떨어진 노드 구하기
		visited = new boolean[N + 1];
		max = Integer.MIN_VALUE;
		dfs(end, 0);

		System.out.println(max);
	}

	private static void dfs(int cur, int cost) {
		if (cost > max) {
			end = cur;
			max = cost;
		}

		visited[cur] = true;
		for (Node nxt : edges[cur]) {
			if (visited[nxt.v])
				continue;
			dfs(nxt.v, nxt.cost + cost);
		}
	}

}
