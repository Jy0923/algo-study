import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class JY_10026{
	
	int n;
	char[][] map;
	int[][] visited;
	int[] dr = {-1, 1, 0, 0};
	int[] dc = {0, 0, 1, -1};
	int ans1, ans2;
	
	public int bfs() {
		
		Deque<int[]> q = new LinkedList<>();
		int cnt = 0;
		char curValue;
		int[] cur;
		int nr, nc, dir;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 1) {
					continue;
				}
				q.addFirst(new int[] {i, j});
				visited[i][j] = 1;
				curValue = map[i][j];
				if (map[i][j] == 'G') {
					map[i][j] = 'R';
				}
				while (!q.isEmpty()) {
					cur = q.pollLast();
					for (dir = 0; dir < 4; dir++) {
						nr = cur[0] + dr[dir];
						nc = cur[1] + dc[dir];
						if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
							continue;
						}
						if (visited[nr][nc] == 1 || map[nr][nc] != curValue) { 
							continue;
						}
						q.addFirst(new int[] {nr, nc});
						visited[nr][nc] = 1;
						if (map[nr][nc] == 'G') {
							map[nr][nc] = 'R';
						}
					}
				}
				cnt++;
			}
		}
		return cnt;
	}
	
	public void solution() throws Exception { 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		String input;
		for (int i = 0; i < n; i++) {
			input = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		visited = new int[n][n];
		ans1 = bfs();
		visited = new int[n][n];
		ans2 = bfs();
		System.out.print(ans1 + " " + ans2);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}