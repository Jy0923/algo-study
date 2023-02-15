package silver.s2.no1912;

import java.util.Arrays;
import java.util.Scanner;

public class No1912_3 {
	
	static int n;
	static int[] arr;
	static int[] dp; // 해당 자리에서 최대 합
	static int maxSum = Integer.MIN_VALUE; // dp에서 최대값
	
	static void dp(int n) {
		
		for(int i=1; i<n; i++) 
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
		
		for(int i=0; i<n; i++) 
			maxSum = Math.max(maxSum, dp[i]);
		
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(dp));
		
		System.out.println(maxSum);
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		arr = new int[n]; // 근데 dp 문제에서 왜 일반적으로 n+1을 하는지 모르겠음
		dp = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = sc.nextInt();
		
		dp[0] = arr[0]; // 첫번쨰값은 최대합이 본인
		
		dp(n);
		
	}
}
