import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JY_17830 {
	
	int n;
	int[][] mat;
	String[] input;
	int[][] result;
	
	public int innerProduct(int[][] a, int[][] b, int r, int c) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += a[r][i] * b[i][c];
		}
		return sum % 1000;
	}
	
	public int[][] matrixProduct(int[][] a, int[][] b){
		int[][] result = new int[n][n];
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				result[r][c] = innerProduct(a, b, r, c);
			}
		}
		return result;
	}
	
	public int[][] dq(int[][] a, long k){
		if (k == 1) {
			return a;
		}
		int[][] tmp = dq(a, k/2);
		if ((k&1) == 1) {
			return matrixProduct(matrixProduct(tmp, tmp), a);
		} else {
			return matrixProduct(tmp, tmp);
		}
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		long k = Long.parseLong(input[1]);
		mat = new int[n][n];
		for (int r = 0; r < n; r++) {
			input = br.readLine().split(" ");
			for (int c = 0; c < n; c++) {
				mat[r][c] = Integer.parseInt(input[c]);
			}
		}
		
		result = dq(mat, k);
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				sb.append(result[r][c]%1000).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		new JY_17830().solution();
	}
}
