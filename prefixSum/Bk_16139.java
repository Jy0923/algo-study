package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_16139 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine(); // 주어진 문자열
		int q = Integer.parseInt(br.readLine()); // 질문 수

		// 누적합 기록
		int[][] prefixSum = new int[str.length() + 1][26];

		// 처음 값 횟수 증가
		prefixSum[1][str.charAt(0) - 'a']++;
		for (int i = 2; i <= str.length(); i++) {
			// 탐색 중인 문자
			int idx = str.charAt(i - 1) - 'a';

			// 알파벳 탐색
			for (int j = 0; j < 26; j++) {
				// 알파벳의 이전 누적합
				int pre = prefixSum[i - 1][j];

				prefixSum[i][j] = j == idx ? pre + 1 : pre;
			}
		}

		String[] st = null;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < q; i++) {
			st = br.readLine().split(" ");

			// 찾아야 하는 문자
			int idx = st[0].charAt(0) - 'a';

			// 시작점
			int start = Integer.parseInt(st[1]) + 1;
			// 끝점
			int end = Integer.parseInt(st[2]) + 1;

			sb.append(prefixSum[end][idx] - prefixSum[start - 1][idx] + "\n");
		}

		System.out.println(sb);
	}

}
