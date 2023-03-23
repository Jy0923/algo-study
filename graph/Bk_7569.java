package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bk_7569 {

	// 상자의 크기
	static int row, col, height;

	static int[] dr = { 0, 0, -1, 1, 0, 0 };
	static int[] dc = { -1, 1, 0, 0, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };

	static int[][][] boxes;
	static int[][][] distance;
	static int max = Integer.MIN_VALUE;

	static BufferedReader br;
	static StringBuilder sb;
	static Queue<Point> Q;

	static class Point {
		int X, Y, H;

		public Point(int h, int x, int y) {
			// super();
			H = h;
			X = x;
			Y = y;
		}

	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		Q = new LinkedList<>();
		String[] input = br.readLine().split(" ");

		col = Integer.parseInt(input[0]);
		row = Integer.parseInt(input[1]);
		height = Integer.parseInt(input[2]);

		boxes = new int[height][row][col];
		distance = new int[height][row][col];

		for (int h = 0; h < height; h++) {
			for (int r = 0; r < row; r++) {
				input = br.readLine().split(" ");
				for (int c = 0; c < col; c++) {
					boxes[h][r][c] = Integer.parseInt(input[c]);
					// 시작점 넣어놓고 시작
					if (boxes[h][r][c] == 1)
						Q.add(new Point(h, r, c));
					else if (boxes[h][r][c] == 0)
						distance[h][r][c] = -1;

				}
			}
		}

		while (!Q.isEmpty()) {
			Point p = Q.poll();

			for (int d = 0; d < dr.length; d++) {
				int nh = p.H + dh[d];
				int nx = p.X + dr[d];
				int ny = p.Y + dc[d];

				if (nh < 0 || nx < 0 || ny < 0)
					continue;
				if (nh >= height || nx >= row || ny >= col)
					continue;
				if (distance[nh][nx][ny] >= 0)
					continue;

				distance[nh][nx][ny] = distance[p.H][p.X][p.Y] + 1;
				Q.add(new Point(nh, nx, ny));
			}
		}

		
		int ans = 0;
		for (int h = 0; h < height; h++) {
			for (int r = 0; r < row; r++) {
				for (int c = 0; c < col; c++) {
					if(distance[h][r][c] == -1) {
						System.out.println(-1);
						System.exit(0);
					}
					else ans = Math.max(ans, distance[h][r][c]);
				}
			}
		}
		
		System.out.println(ans);

	}

}
