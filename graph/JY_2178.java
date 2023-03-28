import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
	char[][] map;
	String input[];
	int[] dr = {1, -1, 0, 0};
	int[] dc = {0, 0, 1, -1};
	int[][] visited;
	
	public void bfs() {
		Queue<Pos> q = new LinkedList<>();
		Pos cur;
		int nr, nc;
		
		q.offer(new Pos(0, 0));
		visited[0][0] = 1;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				nr = cur.r + dr[dir];
				nc = cur.c + dc[dir];
				if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
					continue;
				}
				if (visited[nr][nc] != 0 || map[nr][nc] == '0') {
					continue;
				}
				q.offer(new Pos(nr, nc));
				visited[nr][nc] = visited[cur.r][cur.c] + 1;
			}
		}
	}
	
	public void solution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split(" ");
		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);
		map = new char[row][col];
		for (int r = 0; r < row; r++) {
			map[r] = br.readLine().toCharArray();
		}

		
		visited = new int[row][col];
		bfs();
		System.out.println(visited[row-1][col-1]);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
