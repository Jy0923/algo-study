package graph.bfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No2667 {
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> q;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static int djCnt, cnt;
	static List<Integer> list = new ArrayList<>();
	
	static void count(int index) {
		djCnt = 0; // 단지수
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				boolean isPoll = false;
				
				if(map[i][j] == 0) continue;
				
				if(!visited[i][j]) {
					q.add(new Point(i, j));
					visited[i][j] = true;
					cnt = 1;
					djCnt++;
				}
				
				while(!q.isEmpty()) {
					Point p = q.poll();
					
					for(int idx=0; idx<4; idx++) {
						int newRow = p.x + dRow[idx];
						int newCol = p.y + dCol[idx];
						
						if(newRow < 0 || newRow >= n || newCol < 0 || newCol >= n) continue;
						
						if(visited[newRow][newCol] || map[newRow][newCol] == 0) continue;
						
						q.add(new Point(newRow, newCol));
						visited[newRow][newCol] = true;
						cnt++;
					}
					
					isPoll = true;
				}
				
				if(isPoll)
					list.add(cnt);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		q = new LinkedList<Point>();
		
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) 
				map[i][j] = str.charAt(j) - '0';
		}
		
		visited = new boolean[n][n];
		
		count(0);
		Collections.sort(list);
		System.out.println(djCnt);
		for(int i=0; i<djCnt; i++) {
			System.out.println(list.get(i));
		}
	}
}