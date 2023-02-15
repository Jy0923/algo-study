import java.util.Scanner;

public class JY_1904 {
	
	public void solution() {
		int n = new Scanner(System.in).nextInt();
		int[] dp = new int[n+2];
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < n+1; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 15746;
		}
		System.out.println(dp[n]);
	}
	
	public static void main(String[] args) {
		new JY_1904().solution();
	}

}
