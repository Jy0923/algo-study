import java.util.Scanner;

public class JY_9461 {
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int n;
		long[] dp = new long[101];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		dp[5] = 2;
		for (int i = 6; i < 101; i++) {
			dp[i] = dp[i-1] + dp[i-5];
		}
		for (int i = 0; i < t; i++) {
			n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
	
	public static void main(String[] args) {
		new JY_9461().solution();
	}

}
