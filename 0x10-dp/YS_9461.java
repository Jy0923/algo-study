import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TestCase = Integer.parseInt(br.readLine());
		for (int idx = 0; idx < TestCase; idx++) {
			System.out.println(find(Integer.parseInt(br.readLine())));
		}
	}

	public static long find(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 1;
		} else if (n == 3) {
			return 1;
		}

		long[] dp = new long[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 3];
		}

		return dp[n];

	}

}
// 이건 제 손으로 품..!!
