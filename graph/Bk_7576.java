package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bk_7576 {

	// 정점의 수, 간선 수, 시작 정점
	static int col, row;

	// 격자 모양 상자
	static int[][] box;
	// 확인 여부 표기
	static int[][] distance;

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
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		col = Integer.parseInt(input[0]);
		row = Integer.parseInt(input[1]);

		distance = new int[row][col];
		box = new int[row][col];

		Queue<Pair> queue = new LinkedList<Pair>();
		// 입력
		for (int i = 0; i < row; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				box[i][j] = Integer.parseInt(input[j]);
				if (box[i][j] == 1)
					queue.add(new Pair(i, j));
				else if (box[i][j] == 0)
					distance[i][j] = -1;
			}
		}

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = pair.X + dr[d];
				int ny = pair.Y + dc[d];

				if (nx < 0 || ny < 0 || nx >= row || ny >= col)
					continue;
				// distance가 -1인 경우만 아직 체크하지 않은 안 익은 토마토
				if (distance[nx][ny] >= 0)
					continue;

				distance[nx][ny] = distance[pair.X][pair.Y] + 1;
				queue.add(new Pair(nx, ny));
			}
		}

		int ans = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(distance[i][j] == -1) {
					System.out.println(-1);
					System.exit(0);
				}
				else ans = Math.max(ans, distance[i][j]);
			}
		}
		
		System.out.println(ans);
	}
}
