package dac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_1780 {

	// 사이즈
	static int N;
	// 행렬
	static int[][] arr;

	// -1 종이
	static int paper1;
	// 0 종이
	static int paper2;
	// 1 종이
	static int paper3;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		String[] str = null;
		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		solution(0, 0, N);

		System.out.println(paper1);
		System.out.println(paper2);
		System.out.println(paper3);

	}

	public static void solution(int row, int col, int size) {

		if (checkNum(row, col, size)) {
			if (arr[row][col] == -1)
				paper1++;
			else if (arr[row][col] == 0)
				paper2++;
			else
				paper3++;

			return;
		}

		int tempSize = size / 3;

		for (int i = 0; i < size; i += tempSize) {
			for (int j = 0; j < size; j += tempSize) {
				solution(row + i, col + j, tempSize);
			}
		}

	}

	public static boolean checkNum(int row, int col, int size) {
		int i = arr[row][col];

		for (int r = row; r < row + size; r++) {
			for (int c = col; c < col + size; c++) {
				if (arr[r][c] != i)
					return false;
			}
		}

		return true;
	}

}
