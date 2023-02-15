package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_1912 {
	static int max = Integer.MIN_VALUE; // 누적합 최대값
	static int N; // 수열의 개수
	static int[] arr = new int[100001]; // 수열
	static int[] dp = new int[100001]; // 연속하는 누적합

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {

		// 수열 개수
		N = Integer.parseInt(br.readLine());
		// 수열 값 넣기
		String[] str = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(str[i - 1]);
		}

		for (int i = 1; i <= N; i++) {
			if (dp[i - 1] > 0)
				dp[i] = dp[i - 1] + arr[i];
			else
				dp[i] = arr[i];
			max = Integer.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
