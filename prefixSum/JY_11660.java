import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JY_11660 {
	
	int n;
	int m;
	int[][] arr;
	int[] query = new int[4];
	int answer;
	
	public void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1][n+1];
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				arr[i][j] += arr[i][j-1];
			}
		}
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < n+1; j++) {
				arr[i][j] += arr[i-1][j];
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 4; j++) {
				query[j] = Integer.parseInt(st.nextToken());
			}
			answer = arr[query[2]][query[3]] + arr[query[0] - 1][query[1]-1] 
					- arr[query[0] - 1][query[3]] - arr[query[2]][query[1]-1];
			System.out.println(answer);
		}
	}

	public static void main(String[] args) throws IOException {
		new JY_11660().solution();
	}
}
