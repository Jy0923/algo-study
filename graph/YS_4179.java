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
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		Queue<Node> queue1 = new LinkedList<>();
		Queue<Node> queue2 = new LinkedList<>();
		int[][] dist1 = new int[r][c];
		int[][] dist2 = new int[r][c];
		
		for(int row = 0; row < r; row++) {
			for(int col = 0; col < c; col++) {
					dist1[row][col] = -1;
			}
		}
		
		for(int row = 0; row < r; row++) {
			for(int col = 0; col < c; col++) {
					dist2[row][col] = -1;
			}
		}
		
		char[][] map = new char[r][c];
		for (int row = 0; row < r; row++) {
			String line = br.readLine();
			for (int col = 0; col < c; col++) {
				map[row][col] = line.charAt(col);
				if(map[row][col] == 'J') {
					queue2.offer(new Node(row,col));
					dist2[row][col] = 0;
				}
				if(map[row][col] == 'F') {
					queue1.offer(new Node(row,col));
					dist1[row][col] = 0;
				}
			}
		}
		

		
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while(!queue1.isEmpty()) {
			Node temp = queue1.poll();
			int row = temp.row;
			int col = temp.col;
			for (int i = 0; i < 4 ; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;
				if (dist1[nr][nc] >= 0 || map[nr][nc] == '#') continue;
				
				dist1[nr][nc] = dist1[row][col] + 1;
				queue1.offer(new Node(nr, nc));
				}
			}
		int result = -3;
		
	loop:
	while(!queue2.isEmpty()) {
		Node temp = queue2.poll();
		int row = temp.row;
		int col = temp.col;
		for (int i = 0; i < 4 ; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			if (nr < 0 || nr >= r || nc < 0 || nc >= c) {
				result = dist2[row][col] + 1;
				break loop;
				}
			if (dist2[nr][nc] >= 0 || map[nr][nc] == '#') continue;
			if (dist1[nr][nc] != -1 && dist1[nr][nc] <= dist2[row][col] + 1) continue;
			
			dist2[nr][nc] = dist2[row][col] + 1;
			queue2.offer(new Node(nr, nc));
			}
		}
	
	if (result == -3) {
		System.out.println("IMPOSSIBLE");
	
	} else {
		System.out.println(result);
	}

//		queue.offer(j);
//		queue.offer(f);
//		int jCount = 1;
//		int moveCount = 1;
//		loop: while (!queue1.isEmpty()) {
//			Node temp = queue1.poll();
//			int row = temp.row;
//			int col = temp.col;
//
//			if (map[row][col] == 'J') {
//				moveCount++;
//				for (int i = 0; i < 4; i++) {
//					int nr = row + dr[i];
//					int nc = col + dc[i];
//					if (nr < 0 || nr >= r || nc < 0 || nc >= c)
//						continue;
//
//					if (map[nr][nc] == '.') {
//						map[nr][nc] = 'J';
//						jCount++;
//						if (nr == 0 || nr == r - 1 || nc == 0 || nc == c - 1) {
//							System.out.println(moveCount);
//							break loop;
//						}
//						queue1.offer(new Node(nr, nc));
//
//					}
//				}
//			} else if (map[row][col] == 'F') {
//				for (int i = 0; i < 4; i++) {
//					int nr = row + dr[i];
//					int nc = col + dc[i];
//					if (nr < 0 || nr >= r || nc < 0 || nc >= c)
//						continue;
//
//					if (map[nr][nc] == '.') {
//						map[nr][nc] = 'F';
//						queue1.offer(new Node(nr, nc));
//					} else if (map[nr][nc] == 'J') {
//						map[nr][nc] = 'F';
//						jCount--;
//						if (jCount == 0) {
//							System.out.println("IMPOSSIBLE");
//							break loop;
//						}
//						queue1.offer(new Node(nr, nc));
//					}
//				}
//			}
//
//		}

}

static class Node {
	int row;
	int col;

	public Node(int row, int col) {
		this.row = row;
		this.col = col;
	}
}}
