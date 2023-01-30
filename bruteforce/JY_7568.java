import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JY_7568 {
	
	int[][] arr;
	int n;
	int[] answer;
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int cnt, curX, curY;
		answer = new int[n];
		
		for (int i = 0; i < n; i++) {
			cnt = 1;
			curX = arr[i][0];
			curY = arr[i][1];
			for (int j = 0; j < n; j++) {
				if (i == j) {
					continue;
				}
				if (curX < arr[j][0] && curY < arr[j][1]) {
					cnt++;
				}
			}
			answer[i] = cnt;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(answer[i] + " ");
		}
		
	}
	public static void main(String[] args) throws Exception {
		new JY_7568().solution();
	}
}
