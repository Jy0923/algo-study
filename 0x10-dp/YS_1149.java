// [+] Add RGB거리 영석

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] arr;
	static int[][] dp;
	static int[][] tmp;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		dp = new int[n][3];
		tmp = new int[n][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {

				arr[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j == 0) {
					dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
				} else if (j == 1) {
					dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
				} else if (j == 2) {
					dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
				}

			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			if (dp[n - 1][i] < min) {
				min = dp[n - 1][i];
			}
		}

		System.out.println(min);

	}
}
// 맞았다~~~