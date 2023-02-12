package dp;

import java.util.Scanner;

public class Bk_2156 {
	static int[] cup = new int[10001]; // 각 잔 와인의 양
	static int[] dp = new int[10001]; // n번째 잔까지 왔을 때, 마실 수 있는 최대 와인 양

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 잔 개수

		for (int i = 1; i <= n; i++) {
			cup[i] = sc.nextInt(); // 와인 양 세팅
		}

		dp[1] = cup[1];
		dp[2] = cup[1] + cup[2];

		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i - 3] + cup[i - 1], dp[i - 2]) + cup[i];
			dp[i] = Math.max(dp[i], dp[i - 1]);// 반드시 마지막잔을 마시는 경우가 최댓값이 아닐 수 있음
		}

		System.out.println(dp[n]);
	}
}
