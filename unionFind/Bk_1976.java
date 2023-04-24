import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_1976 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	static int N, M;
	static int[][] edges;
	static int[] route;

	static int[] p;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		p = new int[N + 1];
		edges = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++)
			p[i] = i;

		String[] input = null;
		for (int i = 1; i <= N; i++) {
			input = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				edges[i][j] = Integer.parseInt(input[j - 1]);
				if (edges[i][j] == 1)
					union(i, j);
			}
		}

		input = br.readLine().split(" ");
		String ans = "YES";
		for (int i = 1; i < M; i++) {
			int p1 = findSet(Integer.parseInt(input[i - 1]));
			int p2 = findSet(Integer.parseInt(input[i]));

			if (p1 != p2) {
				ans = "NO";
				break;
			}
		}

		System.out.println(ans);

	}

	static void union(int x, int y) {
		p[findSet(x)] = p[findSet(y)];
	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}
}
