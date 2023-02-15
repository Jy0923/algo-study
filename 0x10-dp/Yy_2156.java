package dp.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 포도주 시식
public class No2156 {
	
	static int n;
	static int[] arr, dp;
	static int maxSum = Integer.MIN_VALUE;
	
	static void dp(int n) {
		
		dp[1] = arr[1];
		
		if(n >= 2)
			dp[2] = arr[1] + arr[2];
		
		for(int i=3; i<=n; i++) 
			// 계단오르기 문제와 거의 똑같은데, 계단오르기는 마지막 계단을 반드시 밟아야 해서 
			// dp[n]을 구할 때
			// dp[n-2] + arr[n] 과 dp[n-1] + arr[n-1] + arr[n] 만 비교했는데
			// 여기서는 본인을 포함하지 않은 dp[n-1]까지 비교해준다
			dp[i] = Math.max(dp[i-3]+arr[i-1]+arr[i], Math.max(dp[i-1], dp[i-2]+arr[i]));
		
		
		for(int i=n; i>0; i--) {
			if(maxSum < dp[i])
				maxSum = dp[i];
		}
		
		System.out.println(maxSum);
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1];
		dp = new int[n+1];
		
		for(int i=1; i<=n; i++) 
			arr[i] = Integer.parseInt(br.readLine());
		
		dp(n);
	}
}
