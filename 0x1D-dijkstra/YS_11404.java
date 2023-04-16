import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;

	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		map = new int[n + 1][n + 1];
		
		// 최대 거리는 10,000 * 99(99개를 지나고 해당 노선들의 비용이 모두 10,000이었을때)
		int inf = 10000000;
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				if (row == col) {
					map[row][col] = 0;
				} else {

					map[row][col] = inf;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = Math.min(map[a][b], c);

		}

		for (int vertex = 1; vertex <= n; vertex++) {
			for (int row = 1; row <= n; row++) {
				for (int col = 1; col <= n; col++) {
					if (map[row][vertex] + map[vertex][col] < map[row][col]) {

						map[row][col] = map[row][vertex] + map[vertex][col];
					}
				}
			}

		}

		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				if (map[row][col] == inf) {
					System.out.print(0 + " ");
				} else {
					System.out.print(map[row][col] + " ");
				}
			}
			System.out.println();
		}

	}
}
