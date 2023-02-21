import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JY_2559 {
	
	int n;
	int k;
	int[] prefixSum;
	int answer = Integer.MIN_VALUE;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		prefixSum = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
		}
		for (int i = k; i < n+1; i++) {
			answer = Math.max(answer, prefixSum[i] - prefixSum[i-k]);
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws IOException {
		new JY_2559().solution();
	}
	
}
