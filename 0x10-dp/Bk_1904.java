package DP;

import java.util.Scanner;

public class Bk_1904 {
	
	static int N; // 이진수열 길이
	static Scanner sc = new Scanner(System.in);
	static int dp [];
	static int mod = 15746;
	
	public static void main(String[] args) {
		N = sc.nextInt();
		dp = new int [N+2];
		
		System.out.println(dp());
	}
	
	public static int dp() {
		
		dp[1] = 1; // 1
		dp[2] = 2; // 00, 11
		// dp[3] = 3; // 001, 111 -> dp[2] 뒤에 1추가  100 -> dp[1]뒤에 00추가
		// dp[4] = 5; // 0011, 1111, 1001, 0000, 1100
		// dp[5] = 8;
		
		for(int i=3; i<=N; i++) {
			dp[i] = (dp[i-2] + dp[i-1]) % mod;
		}
		
		return dp[N];
		
	}

}
