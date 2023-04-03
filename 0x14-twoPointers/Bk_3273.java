package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bk_3273 {

	static BufferedReader br;
	static StringBuilder sb;

	static int N;

	static int[] arr;

	static int sum;
	static int cnt;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];

		String[] input = br.readLine().split(" ");
		for (int i = 1; i <= N; i++)
			arr[i] = Integer.parseInt(input[i - 1]);

		Arrays.sort(arr);

		sum = Integer.parseInt(br.readLine());

		int start = 1, end = N;

		while (start < end) {
			int cur = arr[start] + arr[end];
			if (cur > sum)
				end--;
			else if (cur < sum)
				start++;
			else {
				cnt++;
				start++;
				end--;
			}
		}

		System.out.println(cnt);
	}

}
