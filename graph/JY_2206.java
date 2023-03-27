import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Pos{
	int r, c, cnt;
	Pos(int r, int c, int cnt){
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Main{
	
	int row, col;
	String[] input;
	String sInput;
	int[][] map;
	int[][][] visited;
	int[] dr = {-1, 1, 0, 0};
	int[] dc = {0, 0, -1, 1};
	
	public void bfs() {
		Pos cur;
		int nr, nc;
		
		LinkedList<Pos> q = new LinkedList<>();
		q.offer(new Pos(0, 0, 0));
		visited[0][0][0] = 1;
		
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int dir = 0; dir < 4; dir++) {
				nr = cur.r + dr[dir];
				nc = cur.c + dc[dir];
				// 범위 초과
				if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
					continue;
				}
				// 벽 못 부술 때
				if (cur.cnt != 0 && map[nr][nc] == 1) {
					continue;
				}
				// 이미 벽을 부순 경우
				if (cur.cnt == 1 && visited[nr][nc][1] != 0) {
					continue;
				}
				
				if (cur.cnt == 0 && visited[nr][nc][0] != 0) {
					continue;
				}
				
				if (cur.cnt == 0 && map[nr][nc] == 0) {
					visited[nr][nc][0] = visited[cur.r][cur.c][0] + 1;
					q.offer(new Pos(nr, nc, 0));
				}
				else if (cur.cnt == 0 && map[nr][nc] == 1) {
					visited[nr][nc][1] = visited[cur.r][cur.c][0] + 1;
					q.offer(new Pos(nr, nc, 1));
				} else if (cur.cnt == 1 && map[nr][nc] == 0) {
					visited[nr][nc][1] = visited[cur.r][cur.c][1] + 1;
					q.offer(new Pos(nr, nc, 1));
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
			sInput = br.readLine();
			for (int c = 0; c < col; c++) {
				map[r][c] = sInput.charAt(c) - '0';
			}
		}
		visited = new int[row][col][2]; // 0 : 벽을 안 부순 상태, 1 : 벽을 부순 상태
		bfs();
		int nb = visited[row-1][col-1][0];
		int b = visited[row-1][col-1][1];
		if (nb == 0 && b == 0) {
			System.out.println(-1);
		} else if (nb == 0 && b > 0) {
			System.out.println(b);
		} else if (nb > 0 && b == 0){
			System.out.println(nb);
		} else {
			System.out.println(Math.min(b, nb));
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
