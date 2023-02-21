package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bk_1931_ {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];

		int key = 0, val = 0;
		String[] str = null;

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			time[i][0] = Integer.parseInt(str[0]);
			time[i][1] = Integer.parseInt(str[1]);
		}

		Arrays.sort(time, (a, b) -> {
			if (a[1] == b[1]) {
				return a[0] - b[0];
			} else {
				return a[1] - b[1];
			}
		});

		int cnt = 0, end = 0;
		for (int i = 0; i < N; i++) {
			if (end <= time[i][0] && end <= time[i][1]) {
				cnt++;
				end = time[i][1];
			}
		}

		System.out.println(cnt);

	}

}
