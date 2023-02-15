package silver.s2.no9184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No9184_2 {
	
	static int a, b, c;
	static int[][][] dp = new int[21][21][21];
	// 0 이하의 수는 모두 동일한 값 취급되고
	// 20 초과의 수도 모두 동일한 값 취급
	// 20 + 1 로 크기지정
	
	
	static int w(int a, int b, int c) {
		
		if(a <= 0 || b <= 0 || c <= 0) 
			return dp[0][0][0] = 1;
		
		if(a > 20 || b > 20 || c > 20)
			return dp[20][20][20] = w(20, 20, 20);
		
		if(dp[a][b][c] != 0)
			return dp[a][b][c];
		
		if(a < b && b < c) 
			return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
		
		
		return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
	}
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		while(!str.equals("-1 -1 -1")) {
			
			StringTokenizer st = new StringTokenizer(str);
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			str = br.readLine();
			
			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
		}
		
	}
	
}
