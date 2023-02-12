package dp;

import java.util.Scanner;

public class Bk_10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mod = 1000000000; // 나눠줄 수

		int N = sc.nextInt(); // 숫자의 길이
		int[][] dp = new int[N + 1][10]; // 숫자의 길이가 a일 때, 마지막 숫자가 b일 때의 경우의 개수

		for (int i = 1; i < 10; i++)
			dp[1][i] = 1; // 길이가 1인 숫자의 경우의 수는 무조건 1개(0 제외)

		for (int i = 2; i <= N; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0)
					dp[i][j] = dp[i - 1][j + 1];
				else if (j == 9)
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][j - 1];
				dp[i][j] %= mod;
			}
		}

		int sum = 0;
		for (int i = 0; i < 10; i++)
			sum = (sum + dp[N][i]) % mod;

		System.out.println(sum);

	}

}
