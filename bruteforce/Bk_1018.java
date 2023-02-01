package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_1018 {

	static boolean[][] map;
	static int whiteCnt;
	static int blackCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int r = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);

		map = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			String line = br.readLine();
			for (int j = 0; j < c; j++) {
				if (line.charAt(j) == 'W')
					map[i][j] = true;
				else
					map[i][j] = false;
			}
		}

		int min = Integer.MAX_VALUE;
		for (int row = 0; row + 7 < r; row++) {
			for (int col = 0; col + 7 < c; col++) {
				search(row, col);

				// 최소값 찾기
				if (blackCnt < min)
					min = blackCnt;
				if (whiteCnt < min)
					min = whiteCnt;

			}
		}

		System.out.println(min);

	}

	static void search(int row, int col) {
		boolean isWhite = true;
		blackCnt = 0;
		whiteCnt = 0;
		for (int i = row; i < row + 8; i++) {
			for (int j = col; j < col + 8; j++) {

				// 시작 지점 - 백
				if (map[i][j] != isWhite) {
					whiteCnt++;
				}

				// 시작 지점 - 흑
				if (map[i][j] == isWhite)
					blackCnt++;

				isWhite = !isWhite;
			}
			// 행이 바뀌면, 시작 색 바뀜
			isWhite = !isWhite;
		}
	}

}
