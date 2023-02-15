package dp;

import java.util.Scanner;

public class Bk_1463 {
	static int num;
	static int dp[];
	static Scanner sc = new Scanner(System.in);

	public static void solution() {
		num = sc.nextInt(); // 주어진 수
		dp = new int[1000001];

		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;

		for (int n = 4; n <= num; n++) {
			dp[n] = dp[n-1] + 1;
			
			if(n%3==0) dp[n] = Math.min(dp[n], dp[n/3]+1);
			if(n%2==0) dp[n] = Math.min(dp[n], dp[n/2]+1);
		}
		
		System.out.println(dp[num]);
	}

	public static void main(String[] args) {
		solution();
	}

}
