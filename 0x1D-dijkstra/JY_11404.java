import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	final long INF = 100000 * 100000;

	int n, m, a, b, c;
	long[][] adjMat;
	String[] input;

	public void floyd() {
		long d;
		for (int mid = 1; mid <= n; mid++) {
			for (int st = 1; st <= n; st++) {
				for (int en = 1; en <= n; en++) {
					d = adjMat[st][mid] + adjMat[mid][en];
					if (d < adjMat[st][en]) {
						adjMat[st][en] = d;
					}
				}
			}
		}
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		adjMat = new long[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				adjMat[i][j] = INF;
			}
		}
		for (int i = 0; i <= n; i++)
			adjMat[i][i] = 0;

		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);
			if (adjMat[a][b] > c) adjMat[a][b] = c;
		}

		floyd();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sb.append(adjMat[i][j] == INF ? 0 : adjMat[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
