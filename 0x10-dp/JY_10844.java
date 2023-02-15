import java.util.Scanner;

public class JY_10844 {
	
	int n;
	int[][] dp;
	int answer;
	
	public void solution() {
		int n = new Scanner(System.in).nextInt();
		dp = new int[n][10];
		for (int i = 1; i < 10; i++) {
			dp[0][i] = 1;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][0] = dp[i-1][1] % 1000000000;
				} else if (j == 9) {
					dp[i][9] = dp[i-1][8] % 1000000000;
				} else {
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
				}
			}
		}
		
		for (int i = 0; i < 10; i++) {
			answer = (answer + dp[n-1][i]) % 1000000000;
		}
		System.out.println(answer);
				
	}
	
	public static void main(String[] args) {
		new JY_10844().solution();
	}

}
