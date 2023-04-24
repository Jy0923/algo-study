package union_find;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bk_4195 {

	static BufferedReader br;
	static StringBuilder sb;

	// 테스트 케이스 개수
	static int T;

	// 친구 관계 수
	static int F;

	static int[] parent;
	static int[] level;

	static Map<String, Integer> map;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			F = Integer.parseInt(br.readLine());

			parent = new int[F * 2];
			level = new int[F * 2];

			for (int i = 0; i < F * 2; i++) {
				parent[i] = i;
				level[i] = 1;
			}
			
			int idx = 0;
			map = new HashMap<String, Integer>();
			String[] input = null;
			for (int i = 0; i < F; i++) {
				input = br.readLine().split(" ");

				if (!map.containsKey(input[0]))
					map.put(input[0], idx++);

				if (!map.containsKey(input[1]))
					map.put(input[1], idx++);

				sb.append(union(map.get(input[0]), map.get(input[1])) + "\n");
			}

		}

		System.out.println(sb);

	}

	static int union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (px != py) {
			parent[px] = parent[py];
			level[py] += level[px];

			level[px] = 1;
		}

		return level[py];

	}

	static int findSet(int x) {
		if (parent[x] != x)
			parent[x] = findSet(parent[x]);

		return parent[x];
	}
}
