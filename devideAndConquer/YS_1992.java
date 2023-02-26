import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] map;
	static int n;
	static StringBuilder sb = new StringBuilder();
	static boolean complete;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		String line;

		for (int i = 0; i < n; i++) {
			line = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}

		find(0, 0, n);
		System.out.println(sb);
	}

	public static void find(int row, int col, int size) {
		if (check(row, col, size)) {
			if (map[row][col] == 1) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			return;
		}

		int next = size / 2;

		sb.append('(');
		find(row, col, next);
		find(row, col + next, next);
		find(row + next, col, next);
		find(row + next, col + next, next);
		sb.append(')');
	}

	public static boolean check(int row, int col, int size) {
		complete = true;
		loop1: for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (map[i][j] != map[row][col]) {
					complete = false;
					break loop1;
				}
			}
		}
		return complete;

	}

}
