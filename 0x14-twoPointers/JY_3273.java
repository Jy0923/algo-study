import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	int n, x;
	int[] arr;

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		x = Integer.parseInt(br.readLine());
		Arrays.sort(arr);

		int st = 0;
		int en = n - 1;
		int cnt = 0;
		int sum;
		while (st < en) {
			sum = arr[st] + arr[en];
			if (sum == x) {
				cnt++;
				st++;
			} else if (sum < x) {
				st++;
			} else {
				en--;
			}
		}
		System.out.println(cnt);
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
