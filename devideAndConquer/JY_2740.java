import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JY_2740 {
	
	int n, m, k;
	int[][] a;
	int[][] b;
	String[] input;
	int[][] result;
	
	public int innerProduct(int r, int c) {
		int sum = 0;
		for (int i = 0; i < m; i++) {
			sum += a[r][i] * b[i][c];
		}
		return sum;
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		a = new int[n][m];
		for (int r = 0; r < n; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < m; c++) {
				a[r][c] = Integer.parseInt(input[c]);
			}
		}
		input = br.readLine().split(" ");
		k = Integer.parseInt(input[1]);
		b = new int[m][k];
		for (int r = 0; r < m; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < k; c++) {
				b[r][c] = Integer.parseInt(input[c]);
			}
		}
		
		result = new int[n][k];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < k; c++) {
				result[r][c] = innerProduct(r, c);
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < k; j++) {
				sb.append(result[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void main(String[] args) throws Exception {
		new JY_2740().solution();
	}
}
