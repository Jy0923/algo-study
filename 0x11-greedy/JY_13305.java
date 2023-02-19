import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JY_13305{

	public void solution() throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] dist = new int[n-1];
		int[] gas = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n-1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			gas[i] = Integer.parseInt(st.nextToken());
		}
		
		long answer = 0;
		long minCost = gas[0];
		for (int i = 0; i < n-1; i++) {
			answer += minCost * dist[i];
			if (gas[i+1] <= minCost) {
				minCost = gas[i+1];
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		new JY_13305().solution();
	}
}
