import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] dp;
	static int size;
	static int[] arr;
	static int cnt;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		arr = new int[size];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dp = new int[size + 1];
		for (int i = 0; i < size; i++) {
			cnt = 1;
			max = Integer.MIN_VALUE;
			for (int j = 0; j <= i; j++) {

				if ((arr[j] < arr[i]) && (arr[j] > max)) {
					max = arr[j];
					cnt++;
				}
			}
			dp[i] = cnt;
		}
		
		max = Integer.MIN_VALUE;
		for(int i = 0; i < dp.length; i++) {
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(max);

	}
}
// 틀림...
