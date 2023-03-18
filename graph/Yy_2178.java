package graph.bfs.bkd;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2178_미로탐색 {
	
	static int n, m; // (1,1)에서 출발하여 (n,m)위치로 이동해야함
	static boolean[][] map;
	static int[][] dist; // 출발점에서 거리 넣을 배열
	static Queue<Point> q = new LinkedList<Point>();
	static int[] deltaRow = {-1, 1, 0, 0}; // 상하좌우
	static int[] deltaCol = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		dist = new int[n][m];
		
		char[] tmp = new char[m];
		for(int i=0; i<n; i++) {
			tmp = br.readLine().toCharArray();
			for(int j=0; j<m; j++) {
				if(tmp[j] == '1') 
					map[i][j] = true;
			}
		}
		
		// 거리배열 전부 -1로 지정하면 visited[][] 없이도 방문 여부 확인이 가능
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				dist[i][j] = -1;
			}
		}
		
		// BFS 하기
		// 1. 방문기록하기
		// 방문 가능한 곳에서 시작해서 델타배열 도는데
		// 방문이 가능하고 + 방문기록이 없으면 방문등록 후 이동
		// 큐에 넣기
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// 방문 불가하거나 이미 방문했하면 패스
				if(!map[i][j] || dist[i][j] != -1) continue;
				
				// 방문가능하면
				// 큐에 넣어주고 방문기록 해주기
				q.add(new Point(i, j));
				dist[i][j] = 0;
				
				// 큐가 빌때까지 상하좌우 반복
				while(!q.isEmpty()) {
					Point point = q.poll();
					
					for(int k=0; k<4; k++) {
						int row = point.x + deltaRow[k];
						int col = point.y + deltaCol[k];
						
						// 인덱스 범위 벗어나면 패스
						if(row < 0 || row >= n || col < 0 || col >= m) continue;
						
						// 방문 불가하면 패스
						if(!map[row][col]) continue;
						
						// 이미 방문했어도 패스
						if(dist[row][col] != -1) continue;
						
						// 방문 가능하면 처리
						q.add(new Point(row, col));
						dist[row][col] = dist[point.x][point.y] + 1;
					}
				}
			}
		}
		
		System.out.println(dist[n-1][m-1]+1);
	}
}
