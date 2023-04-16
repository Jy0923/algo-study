package two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bk_1644 {

	static int N;
	static List<Integer> arr;
	static boolean[] visited;

	static int ans;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());

		make_prime(N);

		arr = new ArrayList<Integer>();
		for (int i = 2; i <= N; i++) {
			if (visited[i])
				continue;

			arr.add(i);

		}

		int size = arr.size();

		int start = 0, end = 0;
		int sum = arr.get(start);

		int cnt = 0;

		while (start <= end && end < size) {

			if (sum < N) {
				end++;
				if (end < size)
					sum += arr.get(end);
			} else if (sum > N) {
				sum -= arr.get(start);
				start++;
			} else if (sum == N) {
				cnt++;
				sum -= arr.get(start);
				start++;
			}
		}

		System.out.println(cnt);

	}

	private static void make_prime(int number) {
		visited = new boolean[N + 2];

		// 1은 소수가 아님
		if (number < 2) {
			System.out.println(0);
			System.exit(0);
		}

		visited[0] = visited[1] = true;

		for (int i = 2; i <= Math.sqrt(number + 1); i++) {
			if (visited[i])
				continue;

			for (int j = i * i; j <= N; j += i) {
				visited[j] = true;
			}
		}

	}

}
