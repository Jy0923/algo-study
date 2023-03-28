package graph;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1012_유기농배츄 {
	
	static boolean[][] map, visited;
	static int m, n, k;
	static int x, y;
	static int bugs;
	static Queue<Point> q;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	
	static void bfs(int row, int col) {
		
		for(int i=row; i<n; i++) {
			for(int j=col; j<m; j++) {
				if(map[i][j] && !visited[i][j]) {
					boolean escape = false;
					
					q.offer(new Point(i, j));
					visited[i][j] = true;
					
					while(!q.isEmpty()) {
						Point point = q.poll();
						
						for(int k=0; k<4; k++) {
							int newRow = point.x + dRow[k];
							int newCol = point.y + dCol[k];
							
							if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) continue;
							
							if(!map[newRow][newCol]) continue;
							
							if(visited[newRow][newCol]) continue;
							
							q.offer(new Point(newRow, newCol));
							visited[newRow][newCol] = true;
						}
						
						escape = true;
					}
					
					if(escape)
						bugs++;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int tc=0; tc<t; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken()); // 배츄개수
			
			bugs = 0;
			q = new LinkedList<>();
			
			map = new boolean[n][m];
			visited = new boolean[n][m];
			
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				map[y][x] = true;
			}
			
			bfs(0, 0);
			System.out.println(bugs);
		}
	}
	
}
