package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7569_토마토_조윤영 {
	
	static int m, n, h; // 상자의 크기 열, 행, 높이
	static int[][][] map;
	static Queue<int[]> q; 
	static int[][][] visited;
	static boolean[][][] isTomato;
	static int[] dRow = {0, 0, -1, 1, 0, 0}; // 위 아래 상 하 좌 우
	static int[] dCol = {0, 0, 0, 0, -1, 1};
	static int[] dHeight = {-1, 1, 0, 0, 0, 0}; 
	static int days;
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			int[] point = q.poll();
			
			for(int i=0; i<6; i++) {
				int newHeight = point[0] + dHeight[i];
				int newRow = point[1] + dRow[i];
				int newCol = point[2] + dCol[i];
				
				if(newHeight < 0 || newRow < 0 || newCol < 0 || 
				   newHeight >= h || newRow >= n || newCol >= m) continue;
				
				if(visited[newHeight][newRow][newCol] != -1) continue;
				
				// 토마토가 없으면 패스
				if(map[newHeight][newRow][newCol] == -1) continue;
				
				int[] tmp = {newHeight, newRow, newCol};
				q.add(tmp);
				visited[newHeight][newRow][newCol] = visited[point[0]][point[1]][point[2]] + 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		days = 0;
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		q = new LinkedList<>();
		visited = new int[h][n][m];
		map = new int[h][n][m]; // 높이 // 행 // 열
		isTomato = new boolean[h][n][m];
		
		// 방문배열 초기화
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					visited[i][j][k] = -1;
				}
			}
		}
		
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if(map[k][i][j] == 1) {
						int[] tmp = {k, i, j};
						q.add(tmp);
						visited[k][i][j] = 0;
					}
					
					if(map[k][i][j] != -1)
						isTomato[k][i][j] = true;
				}
			}
		}
		
		bfs();
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(isTomato[i][j][k]) {
						if(visited[i][j][k] == -1) {
							System.out.println(-1);
							return;
						}
						
						if(visited[i][j][k] > days)
							days = visited[i][j][k];
					}
				}
			}
		}
		
		System.out.println(days);
	}
}
