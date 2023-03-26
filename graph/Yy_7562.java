package graph.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동_조윤영 {
	
	static int l;
	static int[][] map;
	static int nowRow, nowCol, goalRow, goalCol;
	
	static Queue<Point> q;
	static int[][] visited; // 거리로 해서 횟수 찾아야대
	
	static int[] dRow = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dCol = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static void bfs(int row, int col) {
		
		q.add(new Point(row, col));
		visited[row][col] = 0;
		
		while(!q.isEmpty()) {
			Point point = q.poll();
			
			for(int i=0; i<8; i++) {
				int newRow = point.x + dRow[i];
				int newCol = point.y + dCol[i];
				
				// 범위 넘어가면 패스
				if(newRow < 0 || newCol < 0 || newRow >= l || newCol >= l) continue;
				
				// 이미 방문했어도 패스
				if(visited[newRow][newCol] != -1) continue;
				
				// 목표점을 찾았으면 종료
				if(newRow == goalRow && newCol == goalCol) {
					System.out.println(visited[point.x][point.y] + 1);
					return;
				}
				
				q.add(new Point(newRow, newCol));
				visited[newRow][newCol] = visited[point.x][point.y] + 1;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1; tc<=t; tc++) {
			q = new LinkedList<>();
			l = Integer.parseInt(br.readLine());
			map = new int[l][l];
			visited = new int[l][l];
			for(int i=0; i<l; i++) {
				for(int j=0; j<l; j++) {
					visited[i][j] = -1;
				}
			}
			
			st = new StringTokenizer(br.readLine());
			nowRow = Integer.parseInt(st.nextToken());
			nowCol = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			goalRow = Integer.parseInt(st.nextToken());
			goalCol = Integer.parseInt(st.nextToken());
			
			if(nowRow == goalRow && nowCol == goalCol)
				System.out.println(0);
			else
				bfs(nowRow, nowCol);
		}
	}
}
