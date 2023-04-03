package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bk_2230 {

	static BufferedReader br;
	static StringBuilder sb;

	static int N;

	static int[] arr;

	static int M;

	static int min;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		min = Integer.MAX_VALUE;

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int start = 0, end = 0;

		while (start < N && end < N) {
			int cur = Math.abs(arr[start] - arr[end]);

			if (cur < M)
				end++;
			else if (cur > M) {
				start++;
				min = Math.min(min, cur);
			}
			else {
				min = M;
				break;
			}
		}

		System.out.println(min);

	}

}
