import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	
	int n;
	int[] arr;
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(arr);
		
		int abs = Integer.MAX_VALUE;
		int st = 0, en = n-1;
		int[] result = {0, 0};
		int sum;
		
		while (st < en) {
			sum = arr[st] + arr[en];
			if (Math.abs(sum) < abs) {
				abs = Math.abs(sum);
				result = new int[] {arr[st], arr[en]};
			}
			if (sum == 0) {
				break;
			} else if (sum > 0) {
				en--;
			} else {
				st++;
			}
		}
		System.out.println(result[0] + " " + result[1]);
		
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
