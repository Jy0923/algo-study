package dp.silver;

import java.util.Scanner;


// 문제에서 정답을 1,000,000,000으로 나눈 나머지를 출력하라고 했는데
// 왜 반복문에서 %MOD를 하는지 이해가안됨 ㅠ 
// 마지막에만 %MOD하는게 맞지 않나요..
public class No10844 {
	
	static int n;
	static long[][] dp; // 자릿수 & 0~9로 시작하는 수들 중 가능한 계단의 개수
	static final long MOD = 1000000000L;
	
	
	static void dp(int n) {
		
		// 1자리수는 모두 개수 1개
		for(int i=1; i<=9; i++) 
			dp[1][i] = 1; 
		
		for(int i=2; i<=n; i++) {
			
			// 0으로 시작하는 계단 수는 길이가 i-1이고 1로 시작하는 계단의 개수와 동일
			dp[i][0] = dp[i-1][1] % MOD;
			
			// 9로 시작하는 계단 수는 길이가 i-1이고 8로 시작하는 계단의 개수와 동일
			dp[i][9] = dp[i-1][8] % MOD;
			
			// 1~8로 시작하는 계단 수
			for(int j=1; j<=8; j++) 
				dp[i][j] = (dp[i-1][j-1] % MOD + dp[i-1][j+1] % MOD) % MOD;
		}
		
//		for(int i=0; i<=n; i++) {
//			for(int j=0; j<=9; j++) {
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		long result = 0;
		for(int i=0; i<=9; i++) {
			result += dp[n][i];
		}
		
		System.out.println(result % MOD);
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		dp = new long[n+1][10];
		
		dp(n);
	}
	
}

