import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];
		int[][] dist = new int[n][m];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		Queue<Node> queue = new LinkedList<>();
		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());

			for (int col = 0; col < m; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
				if (map[row][col] == -1) {
					dist[row][col] = -1;
				}
				if (map[row][col] == 1) {
					queue.offer(new Node(row, col));
				}
			}
		}

		while (!queue.isEmpty()) {
			Node index = queue.poll();
			int r = index.row;
			int c = index.col;
//						System.out.println(r + " " + c);

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
					continue;
				}
				if (map[nr][nc] == -1 || map[nr][nc] == 1)
					continue;
				if (dist[nr][nc] > 0) {
					if (dist[nr][nc] <= dist[r][c] + 1)
						continue;
					else {
						dist[nr][nc] = Math.min(dist[nr][nc], dist[r][c] + 1);
						queue.offer(new Node(nr, nc));
					}
				} else {
					dist[nr][nc] = dist[r][c] + 1;
					queue.offer(new Node(nr, nc));
				}
//							System.out.println(Arrays.deepToString(dist));
				queue.offer(new Node(nr, nc));
			}
		}

		int max = 0;

		loop: for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (dist[row][col] == 0 && map[row][col] != 1) {
					max = -1;
					break loop;
				}

				if (dist[row][col] > max) {
					max = dist[row][col];
				}
			}
		}
		System.out.println(max);

	}

	static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
