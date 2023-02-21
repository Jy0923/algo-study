import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JY_11659 {
	
	int n;
	int m;
	int[] prefixSum;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		prefixSum = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n+1; i++) {
			prefixSum[i] = prefixSum[i-1] + Integer.parseInt(st.nextToken());
		}
		int i, j;
		for (int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			System.out.println(prefixSum[j] - prefixSum[i-1]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new JY_11659().solution();
	}
	
}
