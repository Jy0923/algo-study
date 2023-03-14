import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.Vector;


public class Main {
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	static int n, m;
	static int[][] board1 = new int[10][10];
	static int[][] board2 = new int[10][10];
	static LinkedList<Node> cctv = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int mn = 0;

		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < m; col++) {
				board1[row][col] = Integer.parseInt(st.nextToken());
				if (board1[row][col] != 0 && board1[row][col] != 6)
					cctv.add(new Node(row, col));

				if (board1[row][col] == 0) {
					mn++;
				}
			}
		}
		
		for(int tmp = 0; tmp < (1<<(2*cctv.size())); tmp++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					board2[i][j] = board1[i][j];
				}
			}
			
			int brute = tmp;
			for(int i = 0; i < cctv.size(); i++) {
				int dir = brute % 4;
				brute /= 4;
				int x = cctv.get(i).row;
				int y = cctv.get(i).col;
				if(board1[x][y] == 1) {
					upd(x,y,dir);
				} else if(board1[x][y] == 2) {
					upd(x,y,dir);
					upd(x,y,dir+2);
				} else if(board1[x][y] == 3) {
					upd(x,y,dir);
					upd(x,y,dir+1);
				} else if(board1[x][y] == 4) {
					upd(x,y,dir);
					upd(x,y,dir+1);
					upd(x,y,dir+2);
				} else {
					upd(x,y,dir);
					upd(x,y,dir+1);
					upd(x,y,dir+2);
					upd(x,y,dir+3);

				}
				
			}
			int val = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(board2[i][j] == 0) {
						val++;
					}
				}
			}
			mn = Math.min(mn, val);
			
			
		}
		System.out.println(mn);
		
		
		

	}

	static class Node {
		int row;
		int col;

		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static boolean OOB(int a, int b) {
		return a < 0 || a >= n || b < 0 || b >= m;
	}

	static void upd(int x, int y, int dir) {
		dir %= 4;
		while (true) {
			x += dx[dir];
			y += dy[dir];
			if (OOB(x, y) || board2[x][y] == 6)
				return;
			if (board2[x][y] != 0)
				continue;
			board2[x][y] = 7;
		}
	}

}
