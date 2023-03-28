import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[][] map = new char[n][m];
		int[][] dist = new int[n][m];

//		for (int row = 0; row < n; row++) {
//			for (int col = 0; col < m; col++) {
//				dist[row][col] = -1;
//			}
//		}

		for (int row = 0; row < n; row++) {
			String line = br.readLine();
			for (int col = 0; col < m; col++) {
				map[row][col] = line.charAt(col);
				
			}
		}
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0,0));
		dist[0][0] = 0;
		while(!queue.isEmpty()) {
			Node index = queue.poll();
			int row = index.row;
			int col = index.col;
			for(int i = 0; i < 4 ; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
				if(dist[nr][nc] > 0 || map[nr][nc] == '0') continue;
				dist[nr][nc] = dist[row][col] + 1;
				queue.offer(new Node(nr, nc));
				
				
			}
		}
		
		System.out.println(dist[n-1][m-1] + 1);
		
	}
	
	static class Node{
		int row;
		int col;
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
}
