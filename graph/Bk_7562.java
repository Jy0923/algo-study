package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bk_7562 {

	static int[] dr = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dc = { 1, 2, 2, 1, -1, -2, -2, -1 };

	static StringBuilder sb;
	static BufferedReader br;

	static int T, size;

	static int[][] map;
	static boolean[][] visited;

	// 나이트 시작 위치
	static int startX, startY;

	// 나이트 이동 목표 위치
	static int dtX, dtY;

	// 이동 횟수
	static int ans;

	static Queue<Pair> Q;

	static class Pair {
		int X, Y;

		public Pair(int x, int y) {
			super();
			X = x;
			Y = y;
		}

	}

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {

			size = Integer.parseInt(br.readLine());

			map = new int[size][size];
			visited = new boolean[size][size];

			String[] input = br.readLine().split(" ");
			startX = Integer.parseInt(input[0]);
			startY = Integer.parseInt(input[1]);

			input = br.readLine().split(" ");
			dtX = Integer.parseInt(input[0]);
			dtY = Integer.parseInt(input[1]);
			map[dtX][dtY] = -1;

			// 이동할 필요가 없는 경우
			if (startX == dtX && startY == dtY) {
				sb.append(0 + "\n");
				continue;
			}

			dfs(startX, startY);

			sb.append(ans + "\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int x, int y) {
		Q = new LinkedList<>();
		Q.add(new Pair(x, y));
		visited[x][y] = true;

		Pair pair = null;
		while (!Q.isEmpty()) {
			pair = Q.poll();

			for (int d = 0; d < dr.length; d++) {
				int nx = pair.X + dr[d];
				int ny = pair.Y + dc[d];

				if (nx < 0 || ny < 0 || nx >= size || ny >= size)
					continue;
				if (visited[nx][ny])
					continue;

				visited[nx][ny] = true;
				map[nx][ny] = map[pair.X][pair.Y] + 1;

				if (nx == dtX && ny == dtY) {
					ans = map[nx][ny];
					return;
				}

				Q.add(new Pair(nx, ny));
			}
		}
	}

}
