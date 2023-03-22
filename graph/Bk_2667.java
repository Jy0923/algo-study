package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bk_2667 {

	// 지도의 사이즈
	static int size;

	static int[][] map;
	static boolean[][] visited;

	static BufferedReader br;
	static StringBuilder sb;

	// 단지 수
	static int total;
	static int[] apt;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Pair {
		int X, Y;

		public Pair(int x, int y) {
			X = x;
			Y = y;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		// 지도 크기
		size = Integer.parseInt(br.readLine());

		map = new int[size][size];
		apt = new int[size * size];
		visited = new boolean[size][size];

		String input = null;
		for (int i = 0; i < size; i++) {
			input = br.readLine();
			for (int j = 0; j < size; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (visited[i][j])
					continue;
				if (map[i][j] == 0)
					continue;
				dfs(i, j);
			}
		}

		System.out.println(total);
		Arrays.sort(apt);
		for (int i = 0; i < apt.length; i++) {
			if (apt[i] != 0)
				System.out.println(apt[i]);
		}

	}

	private static void dfs(int i, int j) {
		// 새로운 아파트 단지
		total++;
		Queue<Pair> Q = new LinkedList<Pair>();
		Q.add(new Pair(i, j));
		apt[total]++;
		visited[i][j] = true;

		Pair pair = null;
		while (!Q.isEmpty()) {
			pair = Q.poll();
			// 4방 탐색
			for (int d = 0; d < 4; d++) {
				int nx = pair.X + dr[d];
				int ny = pair.Y + dc[d];

				if (nx < 0 || ny < 0 || nx >= size || ny >= size)
					continue;
				if (visited[nx][ny] || map[nx][ny] == 0)
					continue;

				Q.add(new Pair(nx, ny));
				visited[nx][ny] = true;
				apt[total]++;
			}
		}

	}

}
