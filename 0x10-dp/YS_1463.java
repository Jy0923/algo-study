import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int cnt;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dp = new int[n+1];

		// 초기값 = 0;
		dp[1] = 0;
		
		for(int i = 2; i <= n; i++) {
			// 이전 값에서 숫자를 하나 더하는 3번의 경우가 기본
			// 이 경우와 2를 나누는 경우, 3을 나누는 경우를 비교하여 최솟값을 찾는다.
			// 값을 계속 dp[i]에 저장하기 때문에 이전 값을 다시 계산할 필요가 없다.
			// dp[3]을 찾을 때 이 값은 이미 저장되어 있음.
			dp[i] = dp[i-1] + 1;
			
			if(i % 2 == 0) {
				// 이전 값에서 +1 한 경우와 나누기 2를 하는 경우 비교
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
			}
			
			if(i % 3 == 0) {
				// 이전 값에서 +1 한 경우와 나누기 3을 하는 경우 비교
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			}
		}
		System.out.println(dp[n]);
	}

}
// 코드는 블로그 참조
