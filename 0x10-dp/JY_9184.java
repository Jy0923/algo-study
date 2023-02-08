import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JY_9184 {
	
	int cnt;
	
	int[][][] dp = new int[21][21][21];
	
	public int recursion(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		
		if (a > 20 || b > 20 || c > 20) {
			return recursion(20, 20, 20);
		}
		
		if (dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		
		if (a < b && b < c) {
			dp[a][b][c] = recursion(a, b, c-1) + recursion(a, b-1, c-1) - recursion(a, b-1, c);
			return dp[a][b][c];
		}
		
		dp[a][b][c] = recursion(a-1, b, c) + recursion(a-1, b-1, c) + recursion(a-1, b, c-1) - recursion(a-1, b-1, c-1);
		return dp[a][b][c];
	}
	
	public void solution() throws IOException {
		dp[0][0][0] = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a;
		int b;
		int c;
		while (true) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			if (a == -1 && b == -1 && c == -1) {
				break;
			}
			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + recursion(a, b, c));
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		new JY_9184().solution();
	}
}
