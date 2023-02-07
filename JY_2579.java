import java.util.Scanner;

public class JY_2579 {
	
	int n;
	int[] stair;
	int[][] dp;
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		stair = new int[n+1];
		dp = new int[n+1][2];
		
		for (int i = 1; i < n+1; i++) {
			stair[i] = sc.nextInt();
		}
		
		dp[1][0] = stair[1];
		dp[1][1] = stair[1];
		
		for (int i = 2; i < n+1; i++) {
			dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stair[i];
			dp[i][1] = dp[i-1][0] +stair[i];
		}
		
		System.out.println(Math.max(dp[n][0], dp[n][1]));
	}
	
	public static void main(String[] args) {
		new JY_2579().solution();
	}

}
