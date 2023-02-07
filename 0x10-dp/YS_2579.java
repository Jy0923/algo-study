import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] arr;
	static int[][] dp;
	
	
    public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[2][n+1];
		
		dp[0][0] = 0;
		dp[1][0] = 0;
		dp[0][1] = 10;
		dp[1][1] = 10;

		
		for(int i = 2 ; i <= n; i++) {
			dp[0][i] = Math.max(dp[0][i-2], dp[1][i-2]) + arr[i];
			dp[1][i] = dp[0][i-1] + arr[i];
			
		}
		
		System.out.println(Math.max(dp[0][n], dp[1][n]));
		
		
	}
}
// 다시 풀 예정