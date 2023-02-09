package dp;

import java.util.Scanner;

public class Bk_11053 {

	static int[] arr = new int[1001];
	static int[] dp = new int[1001];
	static int N;
	static int maxVal;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		for (int i = 1; i <= N; i++)
			arr[i] = sc.nextInt();

		for (int i = 1; i <= N; ++i) {
			dp[i] = 1;
			for (int j = 1; j < i; ++j) {
				if (arr[i] > arr[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
			maxVal = Math.max(maxVal, dp[i]);
		}
		
		System.out.println(maxVal);
	}
}
