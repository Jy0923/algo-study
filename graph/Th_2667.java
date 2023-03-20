package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2667_단지번호붙이기 {
	
	static final int[] DX = {0,1,0,-1};
	static final int[] DY = {1,0,-1,0};
	
	static int size;
	static int[][] map;
	static boolean[][] isVisited;
	
	static Queue<Coor> que = new LinkedList<>();
	
	static ArrayList<Integer> sizeOfComplex = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		size = Integer.parseInt(sc.nextLine());
		
		map = new int[size][size];
		isVisited = new boolean[size][size];
		
		String read;
		for(int i=0; i<size; i++) {
			read = sc.nextLine();
			for(int j=0; j<size; j++) {
				map[i][j] = read.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(map[i][j] == 0 || isVisited[i][j]) continue;
				getNumOfHouse(i,j);
			}
		}
		
		Collections.sort(sizeOfComplex);
		
		StringBuilder sb = new StringBuilder();
		sb.append(sizeOfComplex.size() + "\n");
		for(Integer num : sizeOfComplex) {
			sb.append(num + "\n");
		}
		
		System.out.println(sb);
	}
	
	private static void getNumOfHouse(int x, int y) {
		que.offer(new Coor(x,y));
		isVisited[x][y] = true;
		
		int numOfHouse = 1;
		
		while(!que.isEmpty()) {
			Coor cur = que.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + DX[i];
				int ny = cur.y + DY[i];
				
				if(nx<0||ny<0||nx>=size||ny>=size)
					continue;
				
				if(isVisited[nx][ny] || map[nx][ny]==0)
					continue;
				
				isVisited[nx][ny] = true;
				numOfHouse++;
				que.offer(new Coor(nx,ny));
			}
		}
		
		sizeOfComplex.add(numOfHouse);
	}
	
	private static class Coor {
		int x, y;

		public Coor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
