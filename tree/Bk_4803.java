package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Bk_4803 {

	static int N, M;

	static StringBuilder sb;
	static BufferedReader br;

	static int[] parent;

	static boolean[] cycle;

	static List<Integer>[] edges;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int tc = 1;
		while (true) {
			String[] input = br.readLine().split(" ");

			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);

			if (N == 0 && M == 0)
				break;

			parent = new int[N + 1];
			cycle = new boolean[N + 1];
			for (int i = 1; i <= N; i++)
				parent[i] = i;

			int a = 0, b = 0;
			for (int i = 0; i < M; i++) {
				input = br.readLine().split(" ");
				a = Integer.parseInt(input[0]);
				b = Integer.parseInt(input[1]);

				int from = findSet(a);
				int to = findSet(b);

				if (from == to) {
					cycle[from] = true;
				} else {
					if (cycle[from] || cycle[to]) {
						cycle[from] = true;
						cycle[to] = true;
					}

					union(a, b);
				}
			}

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				if (cycle[i])
					continue;

				if (parent[i] == i)
					ans++;
			}

			if (ans > 1)
				sb.append("Case " + tc + ": A forest of " + ans + " trees.\n");
			else if (ans == 1)
				sb.append("Case " + tc + ": There is one tree.\n");
			else
				sb.append("Case " + tc + ": No trees.\n");

			tc++;
		}

		System.out.println(sb);

	}

	public static int findSet(int x) {
		if (parent[x] != x)
			parent[x] = findSet(parent[x]);

		return parent[x];
	}

	public static void union(int x, int y) {
		parent[findSet(x)] = parent[findSet(y)];
	}

}
