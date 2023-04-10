import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	int n, a, b, c;
	ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
	String[] input;
	int[] dist;

	public void dfs(int cur) {
		for (int[] nxt : adjList.get(cur)) {
			if (dist[nxt[0]] == -1) {
				dist[nxt[0]] = dist[cur] + nxt[1];
				dfs(nxt[0]);
			}
		}
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			c = Integer.parseInt(input[2]);
			adjList.get(a).add(new int[] { b, c });
			adjList.get(b).add(new int[] { a, c });
		}
		
		dist = new int[n + 1];
		Arrays.fill(dist, -1);
		dist[0] = 0;
		dfs(1);
		
		int st = 0;
		int maxDist = Integer.MIN_VALUE;
		maxDist = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			if (dist[i] > maxDist) {
				maxDist = dist[i];
				st = i;
			}
		}
		
		dist = new int[n + 1];
		Arrays.fill(dist, -1);
		dist[st] = 0;
		dfs(st);
		
		maxDist = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			if (dist[i] > maxDist) {
				maxDist = dist[i];
			}
		}
		System.out.println(maxDist);
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
