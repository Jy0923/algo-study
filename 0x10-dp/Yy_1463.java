package silver.s3.no1463;

import java.util.Scanner;

public class No1463 {
	// 1로 만들기
	
	static int n;
	static int[] dp;
	
	// n을 입력받았을 때 연산의 최소횟수 구하는 함수
	static int dp(int n) {
		
		if(n >= 1)     // n은 1부터 시작하므로 1일땐 연산이 없어서 0
			dp[1] = 0;
		
		if(n >= 2)     // 2일땐 나누기2 1번 연산이니까 1
			dp[2] = 1;
		
		if(n >= 3)     // 3일땐 나누기3 1번 연산이니까 1
			dp[3] = 1;
		
		// 숫자4부터는 
		// i) n이 3의 배수일때 : n/3에서 최소횟수 + 1 과
		// ii) n이 2의 배수일때 : n/2에서 최소횟수 + 1 과
		// iii) n-1을 했을 때 : n-1에서 최소횟수 + 1  
		// 위의 세가지를 비교하여 가장 작은 횟수가 dp[n]이 된다.
		// i, ii번 연산은 항상 이루어지지 않지만 iii번 조건은 항상 이루어지니까 반목문에서 제일 처음 계산해봤다.
		for(int i=4; i<=n; i++) {
			
			// -1연산을 했을 때 횟수를 일단 넣어준 후
			dp[i] = Math.min(dp[i], dp[i-1] + 1);
			
			// 2나 3으로 나누어 떨어지면 값을 비교해서 더 작은 횟수를 넣어주기
			if(i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
			
			if(i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
		}
		
		return dp[n];
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+1]; // 보통 dp에서 배열을 n+1로 만들길래 이번엔 그렇게 만들어봤음
		
		// 인덱스0 은 null
		// 입력값 1부터 n까지 해당 숫자에서 최소연산수를 구하기 위해 배열에 10^6보다 큰 수를 일단 넣어줬음
		for(int i=1; i<dp.length; i++) {
			dp[i] = 100001;
		}
		
		System.out.println(dp(n));
	}
}
