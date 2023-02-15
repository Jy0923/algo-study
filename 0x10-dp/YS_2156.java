import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int[] arr;
	static int[] dp;
	static long max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		max = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		if (n == 1) {
			max = arr[0];
		} else if (n == 2) {
			max = arr[1] + arr[0];
		} else if (n == 3) {
			dp[0] = arr[0];
			dp[1] = arr[0] + arr[1];

			max = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));

		}

		else {
			dp[0] = arr[0];
			dp[1] = arr[0] + arr[1];
			dp[2] = Math.max(dp[1], Math.max(arr[0] + arr[2], arr[1] + arr[2]));

			for (int i = 3; i < n; i++) {
				dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));

			}
			max = Math.max(dp[n - 1], dp[n - 2]);
		}
		System.out.println(max);
	}

}
