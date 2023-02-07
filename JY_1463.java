import java.util.Scanner;

public class JY_1463 {
	
	int n;
	int[] dp;
	
	public void solution() {
		n = new Scanner(System.in).nextInt();
		dp = new int[n+1];
		for (int i = 2; i < n+1; i++) {
			dp[i] = dp[i-1]+1;
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i/2] + 1, dp[i]);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i/3] + 1, dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
	
	public static void main(String[] args) {
		new JY_1463().solution();
	}

}
