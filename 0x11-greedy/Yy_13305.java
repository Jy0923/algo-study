package greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No13305_주유소 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long[] distance = new long[n-1];
		for(int i=0; i<n-1; i++) 
			distance[i] = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long[] prices = new long[n-1];
		// 사실 마지막 기름값은 살 수 있는 가격이 아니기 때문에 따로 배열에 저장안했음
		for(int i=0; i<n-1; i++) 
			prices[i] = Long.parseLong(st.nextToken());

		
		long[] dp = new long[n-1];
		
		// 첫번째 마을에선 무조건 첫번째 가격이니 초기값 저장
		dp[0] = prices[0];
		
		// 최소금액 저장할 결과 변수
		long result = dp[0] * distance[0];
		
		for(int i=1; i<n-1; i++) {
			if(prices[i-1] >= prices[i]) 
				dp[i] = prices[i];
			else 
				dp[i] = prices[i-1];
			
			result += dp[i] * distance[i];
		}
		
		System.out.println(result);
	}
}
