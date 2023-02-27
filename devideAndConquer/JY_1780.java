import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JY_1780 {

	int[][] arr;
	String[] input;
	int minus = 0;
	int zero = 0;
	int plus = 0;

	public int check(int n, int row, int col) {
		int color = arr[row][col];
		for (int r = row; r < row + n; r++) {
			for (int c = col; c < col + n; c++) {
				if (arr[r][c] != color) {
					return 2;
				}
			}
		}
		return color;
	}

	public void dq(int n, int row, int col) {
		if (n == 1) {
			if (arr[row][col] == -1) {
				minus++;
			} else if (arr[row][col] == 0) {
				zero++;
			} else {
				plus++;
			}
			return;
		}

		int check = check(n, row, col);
		if (check != 2) {
			if (check == -1) {
				minus++;
			} else if (check == 0) {
				zero++;
			} else {
				plus++;
			}
			return;
		}

		int newN = n / 3;
		for (int r = row; r < row + n; r += newN) {
			for (int c = col; c < col + n; c += newN) {
				dq(newN, r, c);
			}
		}
	}

	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		for (int r = 0; r < n; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < n; c++) {
				arr[r][c] = Integer.parseInt(input[c]);
			}
		}

		dq(n, 0, 0);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}

	public static void main(String[] args) throws IOException {
		new JY_1780().solution();
	}
}
