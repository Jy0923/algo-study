import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] isUsed;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < tc; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// n : 가로
			n = Integer.parseInt(st.nextToken());

			// m : 세로
			m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			map = new int[m][n];
			isUsed = new boolean[m][n];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int col = Integer.parseInt(st.nextToken());
				int row = Integer.parseInt(st.nextToken());

				map[row][col] = 1;

			}
			int count = 0;
			for (int row = 0; row < m; row++) {
				for (int col = 0; col < n; col++) {
					if (map[row][col] != 0 && !isUsed[row][col]) {
						bfs(row, col);
						count++;
					}
				}
			}
			System.out.println(count);

		}
	}

	static void bfs(int r, int c) {
		isUsed[r][c] = true;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(r, c));
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			int row = temp.row;
			int col = temp.col;
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];

				if (nr < 0 || nr >= m || nc < 0 || nc >= n)
					continue;
				if (map[nr][nc] != 1 || isUsed[nr][nc])
					continue;
				isUsed[nr][nc] = true;
				queue.offer(new Node(nr, nc));

			}

		}

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
