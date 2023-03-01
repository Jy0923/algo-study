import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int k;
	static int[][] a;
	static int[][] b;
	static int[][] c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new int[n][m];

		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < m; col++) {
				a[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		b = new int[m][k];
		c = new int[n][k];

		for (int row = 0; row < m; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < k; col++) {
				b[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < k; col++) {
				for(int bRow = 0; bRow < m; bRow++) {
					cnt += a[row][bRow] * b[bRow][col];
				}
				c[row][col] = cnt;
				cnt = 0;
			}
		}
		
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < k ; col++) {
				System.out.print(c[row][col] + " ");
			}
			System.out.println();
		}

	}



}
