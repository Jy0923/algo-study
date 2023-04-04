import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int v;
	static int e;
	static long[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		map = new long[v + 1][v + 1];
		int inf = 4000005;
		for (int row = 0; row < v + 1; row++) {
			for (int col = 0; col < v + 1; col++) {
				map[row][col] = 4000005;
			}
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			map[a][b] = c;

		}

		for (int vertex = 1; vertex <= v; vertex++) {
			for (int row = 1; row <= v; row++) {
				for (int col = 1; col <= v; col++) {
					if (map[row][col] > map[row][vertex] + map[vertex][col]) {
						map[row][col] = map[row][vertex] + map[vertex][col];
					}
				}
			}
		}

		long temp = 0;
		long min = Integer.MAX_VALUE;
		for (int row = 1; row < v + 1; row++) {
			if (map[row][row] < inf) {
				temp = map[row][row];
				if (min > temp) {
					min = temp;
				}
			}
		}

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

	}
}
