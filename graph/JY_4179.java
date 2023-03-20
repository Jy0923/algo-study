import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pos {
	int r, c;

	Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Main {

	int row, col;
	char[][] map;
	int[][] visited;
	String input;
	Pos jPos;
	Queue<Pos> fPos = new LinkedList<>();
	int[] dr = { -1, 1, 0, 0 };
	int[] dc = { 0, 0, -1, 1 };
	int answer;

	public boolean bfsJ() {
		Pos cur;
		int nr, nc;
		boolean check = false;

		Queue<Pos> q = new LinkedList<>();
		q.offer(jPos);
		visited[jPos.r][jPos.c] = -1;
		if (jPos.r == 0 || jPos.r == row - 1 || jPos.c == 0 || jPos.c == col - 1) {
			answer = 1;
			return true;
		}
		while (!q.isEmpty()) {
			cur = q.poll();

			for (int dir = 0; dir < 4; dir++) {
				nr = cur.r + dr[dir];
				nc = cur.c + dc[dir];
				if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
					continue;
				}
				if (map[nr][nc] == '#' || (visited[nr][nc] != 0 && visited[nr][nc] <= Math.abs(visited[cur.r][cur.c]) + 1)) {
					continue;
				}
				visited[nr][nc] = visited[cur.r][cur.c] - 1;

				if (nr == 0 || nr == row - 1 || nc == 0 || nc == col - 1) {
					check = true;
					answer = -visited[nr][nc];
					break;
				}
				q.offer(new Pos(nr, nc));
			}
			if (check) {
				break;
			}
		}
		return check;
	}

	public void bfsF() {
		Pos cur;
		int nr, nc;

		while (!fPos.isEmpty()) {
			cur = fPos.poll();

			for (int dir = 0; dir < 4; dir++) {
				nr = cur.r + dr[dir];
				nc = cur.c + dc[dir];
				if (nr < 0 || nr >= row || nc < 0 || nc >= col) {
					continue;
				}
				if (map[nr][nc] == '#' || visited[nr][nc] > 0) {
					continue;
				}
				visited[nr][nc] = visited[cur.r][cur.c] + 1;
				fPos.offer(new Pos(nr, nc));
			}
		}
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		row = Integer.parseInt(input.split(" ")[0]);
		col = Integer.parseInt(input.split(" ")[1]);

		map = new char[row][col];
		visited = new int[row][col];
		for (int r = 0; r < row; r++) {
			input = br.readLine();
			for (int c = 0; c < col; c++) {
				map[r][c] = input.charAt(c);
				if (map[r][c] == 'J') {
					jPos = new Pos(r, c);
				}
				if (map[r][c] == 'F') {
					fPos.offer(new Pos(r, c));
					visited[r][c] = 1;
				}
			}
		}

		bfsF();

		boolean check = bfsJ();

		if (check) {
			System.out.println(answer);
		} else {
			System.out.println("IMPOSSIBLE");
		}

	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
