import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int currentRow;
	static int currentCol;
	static int targetRow;
	static int targetCol;
	static int dr[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int dc[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static boolean[][] isUsed;
	static int[][] map;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			currentRow = Integer.parseInt(st.nextToken());
			currentCol = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			targetRow = Integer.parseInt(st.nextToken());
			targetCol = Integer.parseInt(st.nextToken());
			map = new int[n][n];
			for(int row = 0; row < n; row++) {
				for(int col = 0 ; col < n ; col++) {
					map[row][col] = -1;
				}
			}

			int answer = bfs(currentRow, currentCol);
			System.out.println(answer);
		}
	}

	private static int bfs(int row, int col) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(row, col));
		map[row][col] = 0;
		int count = 0;
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			int r = temp.row;
			int c = temp.col;
			if (r == targetRow && c == targetCol) {
				count = map[r][c];
				break;
			}
			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= n || nr < 0 || nc >= n || nc < 0) {
					continue;

				}
				if(map[nr][nc] != -1) {
					continue;
				}
				map[nr][nc] = map[r][c] + 1;
				queue.offer(new Node(nr, nc));

			}
		}
		return count;

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
