import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int minusOne = 0;
	static int zero = 0;
	static int one = 0;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		map = new int[n][n];

		for (int row = 0; row < n; row++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int col = 0; col < n; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		find(0, 0, n);
		System.out.println(minusOne);
		System.out.println(zero);
		System.out.println(one);

	}

	public static void find(int row, int col, int size) {
		if (check(row, col, size)) {
			if (map[row][col] == -1) {
				minusOne++;
			} else if (map[row][col] == 0) {
				zero++;
			} else if (map[row][col] == 1) {
				one++;
			}
			return;
		}
		int next = size / 3;

		find(row, col, next);
		find(row, col + next, next);
		find(row, col + (next * 2), next);
		find(row + next, col, next);
		find(row + next, col + next, next);
		find(row + next, col + (next * 2), next);
		find(row + (next * 2), col, next);
		find(row + (next * 2), col + next, next);
		find(row + (next * 2), col + (next * 2), next);

		
	}
	
	
	public static boolean check(int row, int col, int size) {
		for (int i = row; i < row + size ; i++) {
			for (int j = col ; j < col + size; j++) {
				if(map[i][j] != map[row][col]) {
					return false;
				}
			}
		}
		return true;
	}
	
	
}
