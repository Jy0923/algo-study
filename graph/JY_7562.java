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
	
	int t, n, toR, toC;
	int[][] visited;
	String[] input;
	Pos st;
	int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
	int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	public void bfs() {
		int nr, nc;
		Pos cur;
		
		visited = new int[n][n];
		LinkedList<Pos> q =  new LinkedList<>();
		q.offer(st);
		visited[st.r][st.c] = 1;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int dir = 0; dir < 8; dir++) {
				nr = cur.r + dr[dir];
				nc = cur.c + dc[dir];
				if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
					continue;
				}
				if (visited[nr][nc] > 0) {
					continue;
				}
				q.offer(new Pos(nr, nc));
				visited[nr][nc] = visited[cur.r][cur.c] + 1;
				if (nr == toR && nc == toC) {
					return;
				}
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			input = br.readLine().split(" ");
			st = new Pos(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			input = br.readLine().split(" ");
			toR = Integer.parseInt(input[0]);
			toC = Integer.parseInt(input[1]);
			
			bfs();
			System.out.println(visited[toR][toC] - 1);
		}
	}
		
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
