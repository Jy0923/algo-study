import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;


class Pos{
	int h, r, c;
	Pos(int h, int r, int c){
		this.h = h;
		this.r = r;
		this.c = c;
	}
}

public class Main{
	
	int row, col, height;
	int[][][] map;
	int[][][] visited;
	String[] input;
	LinkedList<Pos> rotten;
	int answer;
	
	int[] dr = {1, -1, 0, 0, 0, 0};
	int[] dc = {0, 0, -1, 1, 0, 0};
	int[] dh = {0, 0, 0, 0, 1, -1};
	
	public void bfs() {
		Pos cur;
		int nh, nr, nc;
		
		while (!rotten.isEmpty()) {
			cur = rotten.poll();
			for (int dir = 0; dir < 6; dir++) {
				
				nh = cur.h + dh[dir];
				nr = cur.r + dr[dir];
				nc = cur.c + dc[dir];
				
				if (nh < 0 || nh >= height || nr < 0 || nr >= row || nc < 0 || nc >= col) {
					continue;
				}
				if (map[nh][nr][nc] == -1 || visited[nh][nr][nc] > 0) {
					continue;
				}
				visited[nh][nr][nc] = visited[cur.h][cur.r][cur.c] + 1;
				rotten.offer(new Pos(nh, nr, nc));
			}
		}
		
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split(" ");
		row = Integer.parseInt(input[1]);
		col = Integer.parseInt(input[0]);
		height = Integer.parseInt(input[2]);
		
		map = new int[height][row][col];
		visited = new int[height][row][col];
		rotten = new LinkedList<>();
		for (int h = 0; h < height; h++) {
			for (int r = 0; r < row; r++) {
				input = br.readLine().split(" ");
				for (int c = 0; c < col; c++) {
					map[h][r][c] = Integer.parseInt(input[c]);
					if (map[h][r][c] == 1) {						
						rotten.offer(new Pos(h, r, c));
						visited[h][r][c] = 1;
					}
				}
			}
		}
		
		boolean check = false;
		answer = -1;
		bfs();

		for (int h = 0; h < height; h++) {
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if (map[h][r][c] != -1 && visited[h][r][c] == 0) {
						check = true;
					}
					if (visited[h][r][c] > answer) {
						answer = visited[h][r][c];
					}
				}
			}
		}
		
		if (check) {
			System.out.println(-1);
		} else {
			System.out.println(answer - 1);
		}
	}
		
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
