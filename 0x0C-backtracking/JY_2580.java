import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JY_2580 {
	
	int[][] arr = new int[9][9];
	ArrayList<int[]> blank = new ArrayList<>();
	
	public boolean duplicateBox(int cur, int row, int col) {
		int startRow = row / 3 * 3;
		int startCol = col / 3 * 3;
		for (int i = startRow; i < startRow+3; i++) {
			for (int j = startCol; j < startCol+3; j++) {
				if (i == row && j == col) {
					continue;
				}
				if (arr[i][j] == cur) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean duplicateRowCol(int cur, int row, int col) {
		for (int i = 0; i < 9; i++) {
			if (i == row) {
				continue;
			}
			if (arr[i][col] == cur) {
				return false;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (i == col) {
				continue;
			}
			if (arr[row][i] == cur) {
				return false;
			}
		}
		return true;
	}
	
	public void backtracking(int k) {
		if (k == blank.size()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		int row = blank.get(k)[0];
		int col = blank.get(k)[1];
		for (int i = 1; i < 10; i++) {
			if (duplicateRowCol(i, row, col) && duplicateBox(i, row, col)) {
				arr[row][col] = i;
				backtracking(k+1);
				arr[row][col] = 0;
			}
		}
	}
	
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int cur;
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				cur = Integer.parseInt(st.nextToken());
				arr[i][j] = cur;
				if (cur == 0) {
					blank.add(new int[] {i, j});
				}
			}
		}
		backtracking(0);
	}
	
	public static void main(String[] args) throws IOException {
		new JY_2580().solution();
	}
}
