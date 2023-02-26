package dac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk_2630 {

	static int white;
	static int blue;
	static int N;
	static boolean[][] paper;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		paper = new boolean[N][N];
		// 색종이 입력

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				// 파란색 색종이
				if (st.nextToken().equals("1"))
					paper[i][j] = true;
				else
					paper[i][j] = false;
			}
		}

		solution(0, 0, N);

		System.out.println(white);
		System.out.println(blue);

	}

	static void solution(int row, int col, int size) {

		// 모든 영역이 같은 색이라면
		if (colorCheck(row, col, size)) {
			// true면 파란색
			if (paper[row][col])
				blue++;
			else
				white++;
		} else {
			int temp = size / 2;
			solution(row, col, temp);
			solution(row + temp, col, temp);
			solution(row, col + temp, temp);
			solution(row + temp, col + temp, temp);

		}

	}

	static boolean colorCheck(int row, int col, int size) {
		// 첫번째 종이 색깔 기준 검사
		boolean color = paper[row][col];

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				// 만약 종이 색이 다른 것이 있다면, false 리턴
				if (paper[i][j] != color)
					return false;
			}
		}

		return true;
	}

}
