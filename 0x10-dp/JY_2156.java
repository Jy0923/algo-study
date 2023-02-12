import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JY_2156 {
	
	int n;
	int[] arr;
	int[][] dp;
	int answer = Integer.MIN_VALUE;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		dp = new int[n+1][3];
		
		for (int i = 1; i < n+1; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1][1] = arr[1];
		for (int i = 2; i < n+1; i++) {
			dp[i][0] = Math.max(Math.max(dp[i-1][0], dp[i-1][1]), dp[i-1][2]);
			dp[i][1] = dp[i-1][0] + arr[i];
			dp[i][2] = dp[i-1][1] + arr[i];
		}
		
		for (int i = n-1; i < n+1; i++) {
			for (int j = 0; j < 3; j++) {
				answer = Math.max(answer, dp[i][j]);
			}
		}
		
		System.out.println(answer);
		
	}
	
	public static void main(String[] args) throws IOException {
		new JY_2156().solution();
	}

}
