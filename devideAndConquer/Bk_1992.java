package dac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_1992 {
	// 압축 결과
	static StringBuilder sb = new StringBuilder();
	// 영상 크기
	static int N;
	// 영상
	static int[][] video;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		video = new int[N][N];
		String str = "";
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				video[i][j] = str.charAt(j) - '0';
			}
		}

		solution(0, 0, N);

		System.out.println(sb);

	}

	static void solution(int row, int col, int size) {

		if (checkVideo(row, col, size)) {
			sb.append(video[row][col]);

			return;
		}

		int temp = size / 2;

		sb.append("(");
		// 왼쪽 위
		solution(row, col, temp);
		// 오른쪽 위
		solution(row, col + temp, temp);
		// 왼쪽 아래
		solution(row + temp, col, temp);
		// 오른쪽 아래
		solution(row + temp, col + temp, temp);

		sb.append(")");
	}

	static boolean checkVideo(int row, int col, int size) {

		// 첫번째 요소
		int v = video[row][col];
		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (video[i][j] != v)
					return false;
			}
		}

		return true;
	}

}
