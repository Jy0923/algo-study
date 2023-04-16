import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	final int INF = 1000000000;
	int n, m, a, b, c, d;
	String[] input;
	int[][] adjMat;
	int answer;
	
	public void floyd() {
		for (int mid = 1; mid <= n; mid++) {
			for (int st = 1; st <= n; st++) {
				for (int en = 1; en <= n; en++) {
					d = adjMat[st][mid] + adjMat[mid][en];
					if (adjMat[st][en] > d) {
						adjMat[st][en] = d;
					}
				}
			}
		}
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		adjMat = new int[n+1][n+1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(adjMat[i], INF);
		}
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);
			if (adjMat[a][b] > c) {
				adjMat[a][b] = c;
			}
		}
		
		floyd();
		answer = INF;
		for (int st = 1; st <= n; st++) {
			for (int en = 1; en <= n; en++) {
				if (st == en) {
					continue;
				}
				d = adjMat[st][en] + adjMat[en][st];
				if (d < answer) {
					answer = d;
				}
			}
		}
		
		if (answer == INF) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
