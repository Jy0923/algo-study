import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;


class Pos{
	int r, c;
	Pos(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class Main{
	
	int t, row, col, k, answer;
	int[][] map;
	boolean[][] visited;
	String[] input;
	int[] dr = {-1, 1, 0, 0};
	int[] dc = {0, 0, -1, 1};
	
	public void bfs() {
		Pos cur;
		LinkedList<Pos>	q;
		int nr, nc;
		
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (map[r][c] == 0 || visited[r][c]) {
					continue;
				}
				q = new LinkedList<>();
				q.offer(new Pos(r, c));
				visited[r][c] = true;
				while (!q.isEmpty()) {
					cur = q.poll();
					for (int dir = 0; dir < 4; dir++) {
						nr = cur.r + dr[dir];
						nc = cur.c + dc[dir];
						if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
							continue;
						}
						if (map[nr][nc] == 0 || visited[nr][nc]) {
							continue;
						}
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
					}
				}
				answer++;
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			input = br.readLine().split(" ");
			col = Integer.parseInt(input[0]);
			row = Integer.parseInt(input[1]);
			k = Integer.parseInt(input[2]);
			map = new int[row][col];
			visited = new boolean[row][col];
			for (int i = 0; i < k; i++) {
				input = br.readLine().split(" ");
				map[Integer.parseInt(input[1])][Integer.parseInt(input[0])] = 1;
			}
			answer = 0;
			bfs();
			System.out.println(answer);
		}
	}
		
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
