import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos{
	int r, c;
	Pos(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class Main{
	
	int row, col;
	String[] input;
	int[][] map;
	boolean[][] visited;
	int maxArea = 0;
	int cnt = 0;
	
	int[] dr = {-1, 1, 0, 0};
	int[] dc = {0, 0, -1, 1};
	
	public void bfs() {
		Pos cur;
		int nr, nc;
		int curArea;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (map[r][c] == 0 || visited[r][c]) {
					continue;
				}
				Queue<Pos> q = new LinkedList<>();
				q.offer(new Pos(r, c));
				visited[r][c] = true;
				curArea = 1;
				while (!q.isEmpty()) {
					cur = q.poll();
					for (int dir = 0; dir < 4; dir++) {
						nr = cur.r + dr[dir];
						nc = cur.c + dc[dir];
						
						if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
							continue;
						}
						if (visited[nr][nc] || map[nr][nc] == 0) {
							continue;
						}
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
						curArea++;
					}
				}
				cnt++;
				if (curArea > maxArea) {
					maxArea = curArea;
				}
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split(" ");
		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);
		map = new int[row][col];
		
		for (int r = 0; r < row; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < col; c++) {
				map[r][c] = Integer.parseInt(input[c]);
			}
		}
		
		visited = new boolean[row][col];
		bfs();
		System.out.println(cnt);
		System.out.println(maxArea);
		
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
