package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bk_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int cnt = 0;
			Queue<int[]> queue = new LinkedList<int[]>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				// 초기 위치, 중요도
				queue.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}

			while (!queue.isEmpty()) {
				int[] current = queue.remove(); // 가장 첫 원소
				boolean isMax = true; // front 원소가 가장 큰 원소인지 판단

				// 뒤의 요소들과 우선순위 비교
				for (int[] q : queue) {
					if (q[1] > current[1]) {
						isMax = false;
						break;
					}
				}

				if (isMax) {
					cnt++;
					if (current[0] == M)
						break;
				} else
					queue.add(current);
			}

			sb.append(cnt + "\n");
		}

		System.out.println(sb);
	}

}
