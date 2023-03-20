package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bk_4179 {
	// 정점의 수, 간선 수, 시작 정점
	static int col, row;

	// 공간
	static char[][] map;
	// 불이 난 곳에서 얼마나 떨어져있는지 표기
	static int[][] dist1;
	// 지훈이가 미로를 탈출하기 위한 거리 표기
	static int[][] dist2;

	static StringBuilder sb;
	static BufferedReader br;

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static class Pair {
		int X, Y;

		public Pair(int x, int y) {
			X = x;
			Y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		//sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);

		map = new char[row][col];

		dist1 = new int[row][col];
		dist2 = new int[row][col];

		Queue<Pair> Q1 = new LinkedList<>();
		Queue<Pair> Q2 = new LinkedList<>();

		String temp = null;
		for (int i = 0; i < row; i++) {
			temp = br.readLine();
			for (int j = 0; j < col; j++) {
				map[i][j] = temp.charAt(j);

				dist1[i][j] = -1;
				dist2[i][j] = -1;

				if (map[i][j] == 'J') {
					dist2[i][j] = 0;
					Q2.add(new Pair(i, j));
				} else if (map[i][j] == 'F') {
					dist1[i][j] = 0;
					Q1.add(new Pair(i, j));
				}
			}
		}

		// 불이 퍼져나가는 거리 표시
		while (!Q1.isEmpty()) {
			Pair pair = Q1.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = pair.X + dr[dir];
				int ny = pair.Y + dc[dir];
				
				if(nx <0 || ny <0 || nx >=row || ny >= col) continue;
				if(map[nx][ny] == '#' || dist1[nx][ny] >= 0) continue;
				
				dist1[nx][ny] = dist1[pair.X][pair.Y] + 1;
				Q1.add(new Pair(nx, ny));
			}
		}
		
		// 지훈이의 초기 위치에서부터 미로를 탈출할 수 있는 거리
		while (!Q2.isEmpty()) {
			Pair pair = Q2.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nx = pair.X + dr[dir];
				int ny = pair.Y + dc[dir];
				
				if(nx <0 || ny <0 || nx >=row || ny >= col) {
					System.out.println(dist2[pair.X][pair.Y] + 1);
					System.exit(0);
				};
				
				if(dist2[nx][ny] >=0 || map[nx][ny] == '#') continue;
				if(dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[pair.X][pair.Y] + 1) continue;
				
				dist2[nx][ny] = dist2[pair.X][pair.Y] + 1;
				Q2.add(new Pair(nx, ny));
			}
		}
		
		System.out.println("IMPOSSIBLE");
	}
}
