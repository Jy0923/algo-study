import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int paintCount = 0;
		int paintSize = 0;
		map = new int[n][m];
		visited = new boolean[n][m];

		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < m; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());

			}
		}

		for (int row = 0; row < n; row++) {

			for (int col = 0; col < m; col++) {

				if (map[row][col] == 1 && !visited[row][col]) {
//					System.out.println(row + " " + col);
					int result = bfs(row, col);
					if (result > paintSize) {
						paintSize = result;

					}
					paintCount++;
				}
			}
		}

		System.out.println(paintCount);
		System.out.println(paintSize);

	}

	public static int bfs(int r, int c) {
		int size = 1;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(r, c));
		visited[r][c] = true;
		while (!queue.isEmpty()) {
			Node index = queue.poll();
			int row = index.row;
			int col = index.col;

			for (int i = 0; i < 4; i++) {
				int newRow = row + dr[i];
				int newCol = col + dc[i];
				if (newRow < 0 || newRow >= n || newCol < 0 || newCol >= m)
					continue;
//				System.out.println(map[newRow][newCol]);
//				System.out.println(visited[newRow][newCol]);

				if (map[newRow][newCol] == 0 || visited[newRow][newCol])
					continue;
				queue.offer(new Node(newRow, newCol));
				visited[newRow][newCol] = true;
				size++;
			}
		}
		return size;

	}

	public static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}

	}

}
