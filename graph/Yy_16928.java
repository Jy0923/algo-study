package graph.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임_조윤영 {
	
	static int[][] map;
	static Queue<Point> q;
	static int[][] visited;
	
	static void bfs() {
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=1; i<=6; i++) {
				int next = 10 * p.x + p.y + 1 + i;
				if(next > 100) break; // continue아니고 break
				
				if(map[(next-1)/10][(next-1)%10] != 0) 
					next = map[(next-1)/10][(next-1)%10];
				
				if(visited[(next-1)/10][(next-1)%10] != -1) continue;
				
				visited[(next-1)/10][(next-1)%10] = visited[p.x][p.y] + 1;
				q.add(new Point((next-1)/10, (next-1)%10));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 사다리의 수
		int m = Integer.parseInt(st.nextToken()); // 뱀의 수
		
		q = new LinkedList<>();
		map = new int[10][10];
		visited = new int[10][10];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			map[(x-1)/10][(x-1)%10] = y;
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[(u-1)/10][(u-1)%10] = v;
		}
		
		// 방문 초기화
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				visited[i][j] = -1;
			}
		}
		
		// 시작점
		visited[0][0] = 0;
		q.add(new Point(0, 0));
		
		bfs();
		
		System.out.println(visited[9][9]);
	}
}
