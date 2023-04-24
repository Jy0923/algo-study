package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_20040 {

	static BufferedReader br;
	static StringBuilder sb;

	static int N, M;

	static int[] parent;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		parent = new int[N];
		for (int i = 0; i < N; i++)
			parent[i] = i;

		boolean flag = true;

		int result = 0;
		for (int i = 1; i <= M; i++) {
			input = br.readLine().split(" ");

			if (flag) {
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);

				int px = findSet(x);
				int py = findSet(y);

				if (px == py) {
					result = i;
					flag = false;
				}
				union(px, py);
			}
		}

		System.out.println(result);

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
