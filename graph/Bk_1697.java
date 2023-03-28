package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bk_1697 {

	// 수빈이가 있는 위치, 동생이 있는 위치
	static int N, K;

	static int[] visited = new int[100002];

	static BufferedReader br;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		// 수빈이 현재 위치
		N = Integer.parseInt(input[0]);
		// 동생의 현재 위치
		K = Integer.parseInt(input[1]);

		// -1로 초기화
		Arrays.fill(visited, -1);

		Queue<Integer> queue = new LinkedList<Integer>();
		visited[N] = 0;
		queue.add(N);

		while (visited[K] == -1) {
			int cur = queue.poll();
			int[] temp = { cur - 1, cur + 1, cur * 2 };
			for (int nx : temp) {
				if (nx < 0 || nx > 100000)
					continue;
				if (visited[nx] != -1)
					continue;

				visited[nx] = visited[cur] + 1;
				queue.add(nx);
			}

		}

		System.out.println(visited[K]);

	}
}
