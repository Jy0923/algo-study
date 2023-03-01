import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long b;
	static int k;
	static int[][] a;
	static int[][] c;
	static long cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		b = Long.parseLong(st.nextToken());
		a = new int[n][n];
		c = new int[n][n];


		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < n; col++) {
				a[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		


		c = multiple(a,a);
		
		for (int i = 0; i < b-2; i++) {
			c = multiple(a, c);
		}


		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				System.out.print(c[row][col] + " ");
			}
			System.out.println();
		}


	}

	public static int[][] multiple(int[][] array1, int[][] array2) {
		int[][] result = new int[n][n];
		for (int row = 0; row < n; row++) {
			for (int num = 0; num < n; num++) {
				for (int col = 0; col < n; col++) {
					result[row][num] += array1[row][col] * array2[col][num];
				}
				result[row][num] %= 1000;

			}

		}
		return result;
	}

}
// 시간초과,,
