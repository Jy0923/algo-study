package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bk_1012 {

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

	static int col, row, loc;

	static int[][] map;
	static boolean[][] visited;
	static int ans;

	static Queue<Pair> Q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			// 초기화
			ans = 0;

			String[] input = br.readLine().split(" ");

			row = Integer.parseInt(input[0]);
			col = Integer.parseInt(input[1]);
			loc = Integer.parseInt(input[2]);

			
			map = new int[row][col];
			visited = new boolean[row][col];

			int x = 0, y = 0;
			for (int i = 0; i < loc; i++) {
				input = br.readLine().split(" ");
				x = Integer.parseInt(input[0]);
				y = Integer.parseInt(input[1]);

				map[x][y] = 1;
			}

			// 시작점 찾기
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (visited[i][j])
						continue;
					if (map[i][j] == 0)
						continue;
					dfs(i, j);

				}
			}

			sb.append(ans + "\n");
		}

		System.out.println(sb);

	}

	private static void dfs(int i, int j) {
		ans++;

		Q = new LinkedList<Pair>();
		visited[i][j] = true;
		Q.add(new Pair(i, j));

		Pair pair = null;
		while (!Q.isEmpty()) {
			pair = Q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = pair.X + dr[d];
				int ny = pair.Y + dc[d];

				if (nx < 0 || ny < 0 || nx >= row || ny >= col)
					continue;
				if (visited[nx][ny] || map[nx][ny] == 0)
					continue;

				visited[nx][ny] = true;
				Q.add(new Pair(nx, ny));
			}
		}

	}

}
