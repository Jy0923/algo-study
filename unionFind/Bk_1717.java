import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bk_1717 {

	static int[] p;

	static int n, m;

	static StringBuilder sb;
	static BufferedReader br;

	static final int UNION = 0;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		p = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			p[i] = i;
		}

		int a = 0, b = 0, c = 0;
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);

			int nx = findSet(b);
			int ny = findSet(c);

			if (a == UNION)
				union(nx, ny);
			else {
				if (nx != ny)
					sb.append("NO\n");
				else
					sb.append("YES\n");
			}
		}

		System.out.println(sb);

	}

	static void union(int x, int y) {
		p[x] = y;
	}

	static int findSet(int x) {
		if (p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}

}
