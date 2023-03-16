package bfs.bkd;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No1926_그림 {
	
	static int n, m;
	static int[][] map;
	static boolean[][] isVisit;
	static Queue<Point> q = new LinkedList<>();
	static int[] deltaRow = {-1, 1, 0, 0};
	static int[] deltaCol = {0, 0, -1, 1};
	static int cnt; // 그림 개수
	static int maxArea, area; // 최대면적, 면적
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		isVisit = new boolean[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				
				// 1. 시작점 찾기
				// 그림이 없거나, 이미 방문했으면 패스
				if(map[i][j] == 0 || isVisit[i][j]) continue;
				
				// 시작점을 찾았으면 
				// 방문표시 후
				isVisit[i][j] = true;
				// 큐에 좌표 삽입
				q.add(new Point(i, j));
				// 그림면적 계산하기
				area = 1;
				
				// 큐가 빌때까지 반복해서 그림 1개의 크기를 찾는다.
				while(!q.isEmpty()) {
					
					// 큐에서 좌표하나 pop한 뒤 델타배열 순회 ㄱㄱ
					Point p = q.poll();
					int x = p.x;
					int y = p.y;
					
					// BFS 시작
					for(int k=0; k<4; k++) {
						int newRow = x+deltaRow[k];
						int newCol = y+deltaCol[k];
						
						// 우선 범위안에 안들면 패스
						if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= m) continue;
						
						// 그림이 아니거나, 방문했으면 패스
						if(map[newRow][newCol] == 0 || isVisit[newRow][newCol]) continue;
						
						// 그림이면서, 방문 안했으면
						// 방문표시 후
						isVisit[newRow][newCol] = true;
						// 큐에 좌표 삽입
						q.add(new Point(newRow, newCol));
						// 그림면적 계산하기
						area++;
					}
				}
				// 최대면적 비교해서 스왑
				if(maxArea < area)
					maxArea = area;
				
				// 그림 1개 찾았으니 카운트
				cnt++;
			}
		}
		
		System.out.println(cnt);
		System.out.println(maxArea);
	}
	
}
