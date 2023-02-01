import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos{
	
	int row;
	int col;
	
	Pos(int row, int col){
		this.row = row;
		this.col = col;
	}
}

public class JY_14502 {
	
	int row;
	int col;
	int[][] map;
	List<Pos> virus = new ArrayList<>();
	Queue<Pos> q;
	int[] dr = {0, 0, -1, 1};
	int[] dc = {1, -1, 0, 0};
	int[][] visited;
	int[] isused;
	Pos[] newWall = new Pos[3];
	int answer;
	int numOne = 0;
	
	public int bfs() {
		
		int cnt = 0;
		visited = new int[row][col];
		q = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			Pos startPosition = virus.get(i); 
			if (visited[startPosition.row][startPosition.col] == 1) {
				continue;
			}
			q.offer(startPosition);
			visited[startPosition.row][startPosition.col] = 1;
			while (!q.isEmpty()) {
				Pos p = q.poll();
				int cr = p.row;
				int cc = p.col;
				for (int d = 0; d < 4; d++) {
					int nr = cr + dr[d];
					int nc = cc + dc[d];
					if (!isValidPosition(nr, nc)) {
						continue;
					}
					if (visited[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 1) {
						continue;
					}
					visited[nr][nc] = 1;
					cnt++;
					q.offer(new Pos(nr, nc));
				}
			}
		}
		return cnt + virus.size();
	}
	
	public boolean isValidPosition(int row, int col) {
		if (row < 0 || row >= this.row || col < 0 || col >= this.col) {
			return false;
		}
		return true;
	}
	
	public void backtracking(int k) {
		if (k == 3) {
			for (int i = 0; i < 3; i++) {
				map[newWall[i].row][newWall[i].col] = 1;
			}
			int cnt = row * col - bfs() - numOne - 3;
			if (cnt > answer) {
				answer = cnt;
			}
			for (int i = 0; i < 3; i++) {
				map[newWall[i].row][newWall[i].col] = 0; 
			}
			return;
		}
		for (int i = 0; i < row*col; i++) {
			int idxRow = i / col;
			int idxCol = i % col;
			if (isused[i] == 0 && map[idxRow][idxCol] == 0) {
				newWall[k] = new Pos(idxRow, idxCol);
				isused[i] = 1;
				backtracking(k+1);
				isused[i] = 0;
			}
		}
		
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		row = Integer.parseInt(st.nextToken());
		col = Integer.parseInt(st.nextToken());
		map = new int[row][col];
		
		for (int r = 0; r < row; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < col; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 2) {
					virus.add(new Pos(r, c));
				} else if(map[r][c] == 1) {
					numOne++;
				}
			}
		}	
		isused = new int[row * col];
		
		backtracking(0);
		System.out.println(answer);
	}
	
	public static void JY_14502(String[] args) throws Exception {
		new Main().solution();
	}
}
