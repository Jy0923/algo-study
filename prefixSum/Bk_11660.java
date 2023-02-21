package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bk_11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 표 크기
		int M = Integer.parseInt(st.nextToken());// 합 구하기 횟수

		int[][] graph = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				graph[r][c] += graph[r - 1][c];
			}
		}

		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				graph[r][c] += graph[r][c - 1];
			}
		}

		int x1, y1, x2, y2;
		StringBuilder sb = new StringBuilder();
		int result = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			result = graph[x2][y2] - graph[x2][y1 - 1] - graph[x1 - 1][y2] + graph[x1 - 1][y1 - 1];

			sb.append(result + "\n");
		}

		System.out.println(sb);

	}

}
