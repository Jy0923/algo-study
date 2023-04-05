package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_1806 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N;

	static int S;

	static int[] arr;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		S = Integer.parseInt(input[1]);

		arr = new int[N];

		input = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int start = 0, end = 0;
		int sum = arr[start];
		while (start <= end && end < N) {

			if (sum >= S) {
				min = Math.min(min, end - start + 1);
				sum -= arr[start];
				start++;
			} else if (sum < S) {
				end++;
				if (end >= N)
					break;
				sum += arr[end];
			}

		}

		if (min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}

}
