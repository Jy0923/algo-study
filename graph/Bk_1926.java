package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bk_1926 {

	// 정점의 수, 간선 수, 시작 정점
	static int col, row;

	static int[][] map;
	// 방문 여부 표기
	static boolean[][] checked;

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
		row = Integer.parseInt(input[0]);
		col = Integer.parseInt(input[1]);

		checked = new boolean[row][col];
		map = new int[row][col];

		// 입력
		for (int i = 0; i < row; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < col; j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}

		// 그림의 개수
		int total = 0;
		// 가장 넓은 그림의 넓이
		int MX = -1;
		int temp = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				Queue<Pair> queue = new LinkedList<Pair>();
				// bfs의 시작점
				if ((!checked[i][j]) && map[i][j] == 1) {
					// 그림의 개수 증가
					total++;

					checked[i][j] = true;
					queue.add(new Pair(i, j));

					// 현재 그림의 넓이
					temp = 1;

					while (!queue.isEmpty()) {
						Pair pair = queue.poll();

						// 네 방향 체크
						for (int d = 0; d < 4; d++) {
							int nx = pair.X + dr[d];
							int ny = pair.Y + dc[d];

							if (nx < 0 || ny < 0 || nx >= row || ny >= col)
								continue;
							if (checked[nx][ny] || map[nx][ny] == 0)
								continue;

							// 확인 여부 체크
							checked[nx][ny] = true;
							queue.add(new Pair(nx, ny));
							temp++;
						}
					}
				}

				MX = Math.max(MX, temp);
			}
		}

		System.out.println(total);
		System.out.println(MX);
	}
}
