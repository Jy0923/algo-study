import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JY_1931{
	
	public void solution() throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr, (e1, e2) -> {
			if (e1[1] != e2[1]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
		
		int answer = 1;
		int curEnd = arr[0][1];
		for (int i = 1; i < n; i++) {
			if (arr[i][0] >= curEnd) {
				answer++;
				curEnd = arr[i][1];
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) throws Exception {
		new JY_1931().solution();
	}
}
