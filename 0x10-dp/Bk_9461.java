package DP;

import java.util.Scanner;

public class Bk_9461 {
	static int T; // 테스트 케이스
	static int max = 0;
	static long[] dp;

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		T = sc.nextInt();
		int[] test = new int[T];
		for (int i = 0; i < T; i++) {
			test[i] = sc.nextInt();
			max = Math.max(max, test[i]);
		}
		
		init(); // dp 배열 초기화
		
		for(int i : test) {
			System.out.println(dp[i]);
		}
	}

	// dp 배열 값 세팅
	public static void init() {
		dp = new long[max + 1];
		dp[1] = 1; dp[2] = 1; dp[3] = 1;
		dp[4] = 2; dp[5] = 2; // N=5까지 규칙 X

		for (int i = 6; i <= max; i++) {
			dp[i] = dp[i- 5] + dp[i - 1];
		}
	}

	// 배열에서 해당 값 찾아오기
	public static long find(int N) {
		return dp[N];
	}

}
