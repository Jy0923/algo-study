package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bk_2470 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;

	static int[] arr;

	static int ans1, ans2;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		String [] input = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		Arrays.sort(arr);

		int start = 0, end = N - 1;
		int sum = 0;
		while (start < end) {
			sum = arr[start] + arr[end];

			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				ans1 = arr[start];
				ans2 = arr[end];
			}

			if (sum < 0) {
				start++;
			} else if (sum > 0) {
				end--;
			} else
				break;

		}

		System.out.println(ans1 + " " + ans2);
	}

}
