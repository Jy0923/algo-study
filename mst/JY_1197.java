import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main{
	
	int t, n, m, a, b, c;
	String[] input;
	ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
	
	public int prim() {
		int[] cur;
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
		boolean[] visited = new boolean[n+1];
		int[] dist = new int[n+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		pq.offer(new int[] {1, 0});
		
		while (!pq.isEmpty()) {
			cur = pq.poll();
			if (!visited[cur[0]] && dist[cur[0]] > cur[1]) {
				dist[cur[0]] = cur[1];
				visited[cur[0]] = true;
				for (int[] nxt : adjList.get(cur[0])) {
					pq.offer(nxt);
				}
			}
		}
		
		int weight = 0;
		for (int i = 1; i <= n; i++) {
			weight += dist[i];
		}
		return weight;
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
			adjList.get(a).add(new int[] {b, c});
			adjList.get(b).add(new int[] {a, c});
		}
		
		System.out.println(prim());
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
