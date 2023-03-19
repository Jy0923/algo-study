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
	int[][] tomato;
	Queue<Pos> rotenTomato = new LinkedList<>();
	String[] input;
	int[] dr = {-1, 1, 0, 0};
	int[] dc = {0, 0, -1, 1};
	int[][] visited;
	
	public void bfs() {
		Pos cur;
		int nr, nc;
		
		while (!rotenTomato.isEmpty()) {
			cur = rotenTomato.poll();
			for (int dir = 0; dir < 4; dir++) {
				nr = cur.r + dr[dir];
				nc = cur.c + dc[dir];
				if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
					continue;
				}
				if (visited[nr][nc] > 0 || tomato[nr][nc] == -1) {
					continue;
				}
				visited[nr][nc] = visited[cur.r][cur.c] + 1;
				rotenTomato.offer(new Pos(nr, nc));
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split(" ");
		row = Integer.parseInt(input[1]);
		col = Integer.parseInt(input[0]);
		
		tomato = new int[row][col];
		visited = new int[row][col];
		boolean allRoten = true;

		for (int r = 0; r < row; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < col; c++) {
				tomato[r][c] = Integer.parseInt(input[c]);
				if (tomato[r][c] == 1) {
					rotenTomato.offer(new Pos(r, c));
					visited[r][c] = 1;
				}
				if (tomato[r][c] == 0) {
					allRoten = false;
				}
			}
		}
		if (allRoten) {
			System.out.println(0);
			System.exit(0);
		}
	
		bfs();
		
		int answer = 0;
		allRoten = true;
		for (int r = 0; r < row; r++) {
			for (int c = 0; c < col; c++) {
				if (visited[r][c] > answer) {
					answer = visited[r][c];
				}
				if (tomato[r][c] != -1 && visited[r][c] == 0) {
					allRoten = false;
				}
			}
		}
		if (!allRoten) {
			System.out.println(-1);
		} else {
			System.out.println(answer - 1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
