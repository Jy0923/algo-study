import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JY_11053 {
	
	int n;
	int[] arr;
	int[] dp;
	int answer = 1;
	
	public void fillTable() {
		int curMax;
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			curMax = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (dp[j] > curMax) {
						curMax = dp[j];
					}
				}
			}
			dp[i] = curMax + 1;
			if (dp[i] > answer) {
				answer = dp[i];
			}
		}
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		fillTable();
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		new JY_11053().solution();
	}
}
