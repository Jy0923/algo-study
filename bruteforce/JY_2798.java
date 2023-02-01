import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JY_2798 {
	
	int n;
	int m;
	int[] arr;
	int[] isused;
	int sum;
	int curSum = 0;
	int maxSum = 0;
	
	public void backtracking(int k) {
		if (k == 3) {
			if (curSum <= m && curSum > maxSum) {
				maxSum = curSum;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (isused[i] == 0) {
				isused[i] = 1;
				curSum += arr[i];
				backtracking(k+1);	
				isused[i] = 0;
				curSum -= arr[i];
			}
			
		}
	}
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		isused = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		backtracking(0);
		System.out.println(maxSum);
		
	}
	
	public static void main(String[] args) throws IOException {
		new JY_2798().solution();
	}
}
