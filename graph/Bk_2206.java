package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bk_2206 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	// 맵
	static int N, M;

	static int[][] map;

	// 방문 배열
	static boolean[][][] visited;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Node {
		int row, col;
		int cnt;
		int isDestroyed;

		public Node(int row, int col, int cnt, int isDestroyed) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
			this.isDestroyed = isDestroyed;
		}

	}

	public static void main(String[] args) throws IOException {

		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1][2];

		String init = null;
		for (int i = 1; i <= N; i++) {
			init = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = init.charAt(j - 1);
			}
		}

		int result = bfs();

		System.out.println(result);
	}

	private static int bfs() {
		Queue<Node> Q = new LinkedList<Node>();
		visited[1][1][0] = true;
		Q.add(new Node(1, 1, 1, 0));

		while (!Q.isEmpty()) {
			Node node = Q.poll();

			// 꺼낸 노드가 도착점이라면 리턴
			if (node.row == N && node.col == M)
				return node.cnt;

			for (int d = 0; d < 4; d++) {
				int nx = node.row + dr[d];
				int ny = node.col + dc[d];

				if (nx <= 0 || ny <= 0 || nx > N || ny > M)
					continue;
				if (visited[nx][ny][node.isDestroyed])
					continue;

				if (map[nx][ny] == '0') {
					Q.add(new Node(nx, ny, node.cnt + 1, node.isDestroyed));
					visited[nx][ny][node.isDestroyed] = true;
				} else if (map[nx][ny] == '1' && node.isDestroyed == 0) {
					Q.add(new Node(nx, ny, node.cnt + 1, 1));
					visited[nx][ny][1] = true;
				}

			}
		}
		return -1;
	}

}
