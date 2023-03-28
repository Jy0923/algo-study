package graph.bfs.bkd;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No7576_토마토 {
	
	static int m, n; 
	static int[][] map, dist;
	static Queue<Point> q = new LinkedList<>();
	static int[] deltaRow = {-1, 1, 0, 0};
	static int[] deltaCol = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				dist[i][j] = -1;
				
				if(map[i][j] == 1)
					q.add(new Point(i, j)); // 시작점으로 가능하면 큐에 다 넣어주기
			}
		}
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			int x = point.x;
			int y = point.y;
			
			if(dist[x][y] == -1)
				dist[x][y] = 0;
			
			for(int i=0; i<4; i++) {
				int newRow = x + deltaRow[i];
				int newCol = y + deltaCol[i];
				
				if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) continue;
				
				if(map[newRow][newCol] != 0 || dist[newRow][newCol] != -1) continue;
				
				dist[newRow][newCol] = dist[x][y] + 1;
				map[newRow][newCol] = 1;
				q.add(new Point(newRow, newCol));
			}
		}
		
		int maxCnt = 0;
		boolean notRipe = false;
		label:
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(dist[i][j] > maxCnt)
					maxCnt = dist[i][j];
				
				if(dist[i][j] == -1 && map[i][j] != -1) {
					notRipe = true;
					break label;
				}
			}
		}
		
		if(notRipe)
			System.out.println(-1);
		else
			System.out.println(maxCnt);
	}
}
