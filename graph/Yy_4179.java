package graph.bfs.bkd;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No4179_불 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[r][c];
		int[][] dist = new int[r][c];
		int[][] fireDist = new int[r][c];
		
		Queue<Point> q = new LinkedList<>();
		Queue<Point> fireQ = new LinkedList<>();
		
		String str;
		for(int i=0; i<r; i++) {
			str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = str.charAt(j);
				
				dist[i][j] = -1;
				fireDist[i][j] = -1;
				
				if(map[i][j] == 'J') {
					q.add(new Point(i, j));
					dist[i][j] = 0; // 큐에 넣으면서 방문표시
				}
				else if(map[i][j] == 'F') {
					fireQ.add(new Point(i, j));
					fireDist[i][j] = 0; // 큐에 넣으면서 방문표시
				}
			}
		}
		
		int[] dRow = {-1, 1, 0, 0};
		int[] dCol = {0, 0, -1, 1};
		
		while(!fireQ.isEmpty()) {
			Point point = fireQ.poll();
			
			for(int i=0; i<4; i++) {
				int x = point.x + dRow[i];
				int y = point.y + dCol[i];
				
				// 범위 벗어나면 패스
				if(x < 0 || x >= r || y < 0 || y >= c) continue;
				
				// 벽이여도 패스
				if(map[x][y] == '#') continue;
				
				// 이미 지나왔으면 패스
				if(fireDist[x][y] != -1) continue;
				
				fireQ.add(new Point(x, y));
				fireDist[x][y] = fireDist[point.x][point.y] + 1;
			}
		}
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			
			for(int i=0; i<4; i++) {
				int x = point.x + dRow[i];
				int y = point.y + dCol[i];
				
				// 범위 벗어나면 탈출
				if(x < 0 || x >= r || y < 0 || y >= c) {
					System.out.println(dist[point.x][point.y] + 1);
					return;
				}
				
				// 벽이여도 패스
				if(map[x][y] == '#') continue;
				
				// 이미 지나왔어도 패스
				if(dist[x][y] != -1) continue;
				
				// 불이 먼저 지나왔으면 패스
				// fireDist[x][y] != -1 을 추가해서 꼭 불이 지나온거를 체크해야함
				if(fireDist[x][y] != -1 && fireDist[x][y] <= dist[point.x][point.y] + 1) continue;
				
				q.add(new Point(x, y));
				dist[x][y] = dist[point.x][point.y] + 1;
			}
		}
		
		System.out.println("IMPOSSIBLE");
		
//		int minTime = Integer.MAX_VALUE;
//		for(int i=0; i<r; i++) {
//			for(int j=0; j<c; j++) {
//				if(i == 0 || i == r-1 || j == 0 || j == c-1) {
//					if(dist[i][j] >= 0 && minTime > dist[i][j])
//						minTime = dist[i][j] + 1;
//				}
//			}
//		}
//		
//		if(minTime != Integer.MAX_VALUE)
//			System.out.println(minTime);
//		else
//			System.out.println("IMPOSSIBLE");
	}
}
