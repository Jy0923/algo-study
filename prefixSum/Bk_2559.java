package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_2559 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int total, days; // 전체 날짜, 구간 숫자
	static int[] arr = new int[100001]; // 주어진 숫자
	static long[] sum = new long[100001]; // 구간 누적합
	static long max;

	public static void main(String[] args) throws IOException {

		String[] nm = br.readLine().split(" ");
		total = Integer.parseInt(nm[0]);
		days = Integer.parseInt(nm[1]);

		String[] str = br.readLine().split(" ");

		for (int i = 1; i <= days; i++) { // 첫번째 구간 누적합 값 저장
			arr[i] = Integer.parseInt(str[i - 1]);
			sum[1] += arr[i];
			max = sum[1];
		}

		int cnt = 2; // sum 배열 인덱스
		for (int i = days + 1; i <= total; i++) {
			arr[i] = Integer.parseInt(str[i - 1]);
			sum[cnt] = sum[cnt - 1] + arr[i] - arr[i - days];

			if (sum[cnt] > max)
				max = sum[cnt];

			cnt++;

		}

		System.out.println(max);

	}

}
