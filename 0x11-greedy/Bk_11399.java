package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bk_11399 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 사람의 수
		int num = Integer.parseInt(br.readLine());

		// 시간
		int[] time = new int[num];
		int[] prefixTime = new int[num];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < num; i++) {
			time[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(time);

		prefixTime[0] = time[0];
		int sum = prefixTime[0];
		for (int i = 1; i < num; i++) {
			prefixTime[i] = prefixTime[i - 1] + time[i];
			sum += prefixTime[i];
		}

		System.out.println(sum);
	}
}
