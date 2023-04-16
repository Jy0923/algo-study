import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	int n, m, a, b, c;
	ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
	String[] input;
	long[] dist;

	public boolean bellmanFord() {
		dist[1] = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int v = 1; v <= n; v++) {
				for (int[] e : adjList.get(v)) {
					if (dist[v] == Long.MAX_VALUE) {
						break;
					}
					if (dist[v] + e[1] < dist[e[0]]) {
						dist[e[0]] = dist[v] + e[1];
					}
				}
			}
		}
		for (int v = 1; v <= n; v++) {
			for (int[] e : adjList.get(v)) {
				if (dist[v] == Long.MAX_VALUE) {
					break;
				}
				if (dist[v] + e[1] < dist[e[0]]) {
					return false;
				}
			}
		}
		return true;
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);
			adjList.get(a).add(new int[] { b, c });
		}
		dist = new long[n + 1];
		Arrays.fill(dist, Long.MAX_VALUE);

		boolean check = bellmanFord();
		if (!check) {
			System.out.println(-1);
		} else {
			for (int i = 2; i <= n; i++) {				
				if (dist[i] == Long.MAX_VALUE) System.out.println(-1);
				else System.out.println(dist[i]);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
