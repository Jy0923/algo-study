import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

class Pos{
	int r, c;
	Pos(int r, int c){
		this.r = r;
		this.c = c;
	}
}

public class Main{
	
	int n;
	char[][] map;
	
	int[] dr = {-1, 1, 0, 0};
	int[] dc = {0, 0, -1, 1};
	
	ArrayList<Integer> numArr = new ArrayList<>();
	
	public void bfs() {
		Pos cur;
		int nr, nc, cnt;
		LinkedList<Pos> q;
		boolean[][] visited = new boolean[n][n];
		
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (map[r][c] == '0' || visited[r][c]) {
					continue;
				}
				
				q = new LinkedList<>();
				q.offer(new Pos(r, c));
				visited[r][c] = true;
				cnt = 1;
				while (!q.isEmpty()) {
					cur = q.poll();
					for (int dir = 0; dir < 4; dir++) {
						nr = cur.r + dr[dir];
						nc = cur.c + dc[dir];
						if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
							continue;
						}
						if (visited[nr][nc] || map[nr][nc] == '0') {
							continue;
						}
						q.offer(new Pos(nr, nc));
						visited[nr][nc] = true;
						cnt++;
					}
				}
				numArr.add(cnt);
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new char[n][n];
		
		for (int r = 0; r < n; r++) {
			map[r] = br.readLine().toCharArray();
		}
		
		bfs();
		
		numArr.sort((e1, e2) -> e1.compareTo(e2));
		
		System.out.println(numArr.size());
		for (int e : numArr) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
