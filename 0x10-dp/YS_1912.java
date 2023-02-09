import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[] arr;
	static int[] dp;
	static int[] tmp;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		tmp = new int[n + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {

			tmp[i] = arr[i];
			max = tmp[i];
			for (int j = i + 1; j < n; j++) {
				tmp[j] = tmp[j - 1] + arr[j];
				if (tmp[j] > max) {
					max = tmp[j];
				}

			}
			dp[i] = max;

		}
		max = Integer.MIN_VALUE;
		for(int i = 0; i < dp.length; i++) {
			if ( dp[i] > max ) {
				max = dp[i];
			}
		}
		
		System.out.println(max);

	}

}
// 시간 초과,,,,
