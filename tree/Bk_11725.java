package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bk_11725 {

	static StringBuilder sb;
	static BufferedReader br;

	static int N;

	static List<Integer>[] graph;

	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		int a = 0, b = 0;
		String[] input = null;
		for (int i = 1; i < N; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);

			graph[a].add(b);
			graph[b].add(a);
		}

		bfs(1);

		for (int idx = 2; idx <= N; idx++) {
			System.out.println(parent[idx]);
		}

	}

	private static void bfs(int root) {
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(root);

		parent = new int[N + 1];

		while (!Q.isEmpty()) {
			int cur = Q.poll();

			for (int node : graph[cur]) {
				// 만약에 부모 노드면 탐색 X
				if (node == parent[cur])
					continue;

				Q.add(node);
				// 부모 노드로 등록
				parent[node] = cur;
			}
		}

	}

}
