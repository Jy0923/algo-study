import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	int n, m;
	int[] arr;
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		int st = 0;
		int en = 0;
		int diff;
		int min = Integer.MAX_VALUE;
		while (st < n && en < n) {
			diff = arr[en] - arr[st];
			if (diff >= m && diff < min) {
				min = diff;
			}
			if (diff == m) {
				break;
			} else if (diff > m) {
				st++;
			} else {
				en++;
			}
		}
		System.out.println(min);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
