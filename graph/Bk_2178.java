package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bk_2178 {

	static int distance[][];
	static int n, m;

	static int[][] map;

	static BufferedReader br;
	static StringBuilder sb;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Pair {
		int X, Y;

		public Pair(int x, int y) {
			X = x;
			Y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		map = new int[n][m];
		distance = new int[n][m];

		String str = null;

		for (int i = 0; i < n; i++) {
			str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
				distance[i][j] = -1;

			}

		}

		Queue<Pair> Q = new LinkedList<Pair>();
		Q.add(new Pair(0, 0));
		distance[0][0] = 0;

		while (!Q.isEmpty()) {
			Pair pair = Q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = pair.X + dc[d];
				int ny = pair.Y + dr[d];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;
				if (distance[nx][ny] > 0 || map[nx][ny] != 1)
					continue;

				distance[nx][ny] = distance[pair.X][pair.Y] + 1;
				Q.add(new Pair(nx, ny));
			}

		}

		System.out.println(distance[n - 1][m - 1] + 1);
	}

}
