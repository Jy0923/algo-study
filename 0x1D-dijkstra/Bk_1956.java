package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bk_1956 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	// 마을
	static int V;
	// 도로
	static int E;

	// 모든 마을 쌍에 대한 최단거리
	static long[][] dist;

	static final long INF = Integer.MAX_VALUE;

	static long min;

	public static void main(String[] args) throws IOException {

		String[] input = br.readLine().split(" ");

		V = Integer.parseInt(input[0]);
		E = Integer.parseInt(input[1]);

		dist = new long[V + 1][V + 1];

		for (int i = 1; i <= V; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}

		int a = 0, b = 0, c = 0;
		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);

			// 쌍이 같은 도로가 여러 번 주어지지 않음
			dist[a][b] = c;
		}

		for (int i = 1; i <= V; i++)
			for (int st = 1; st <= V; st++)
				for (int end = 1; end <= V; end++)
					dist[st][end] = Math.min(dist[st][end], dist[st][i] + dist[i][end]);

		min = INF;
		for (int i = 1; i <= V; i++) {
			for (int j = i + 1; j <= V; j++) {
				min = Math.min(dist[i][j] + dist[j][i], min);
			}
		}

		if (min == INF)
			min = -1;

		System.out.println(min);
	}
}
