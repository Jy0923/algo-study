package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bk_11404 {
	// 도시, 버스의 수
	static int n, m;

	static int[][] dist;

	static final int INF = 9900001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dist[i], INF);
		}

		int s = 0, e = 0, cost = 0;
		String[] input = null;
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			s = Integer.parseInt(input[0]);
			e = Integer.parseInt(input[1]);
			cost = Integer.parseInt(input[2]);

			// 방향 그래프
			dist[s][e] = Math.min(dist[s][e], cost);
		}

		for (int i = 1; i <= n; i++)
			dist[i][i] = 0;

		for (int i = 1; i <= n; i++)
			for (int r = 1; r <= n; r++)
				for (int c = 1; c <= n; c++)
					dist[r][c] = Math.min(dist[r][c], dist[r][i] + dist[i][c]);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == INF)
					dist[i][j] = 0;
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

}
