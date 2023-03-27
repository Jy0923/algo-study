import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
	
	int n, m, u, v, w, st;
	ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
	String[] input;
	int[] dist;
	
	public void dijkstra() {
		int[] cur;
		dist[st] = 0;
		PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
		
		q.offer(new int[] {0, st});
		while (!q.isEmpty()) {
			cur = q.poll();

			if (cur[0] == dist[cur[1]]) {
				for (int[] e : adjList.get(cur[1])) {
					if (dist[cur[1]] + e[1] < dist[e[0]]) {
						dist[e[0]] = dist[cur[1]] + e[1];
						q.offer(new int[] {dist[e[0]], e[0]});
					}
				}
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		st = Integer.parseInt(br.readLine());
		
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			u = Integer.parseInt(input[0]);
			v = Integer.parseInt(input[1]);
			w = Integer.parseInt(input[2]);
			adjList.get(u).add(new int[] {v, w});
		}
		
		dist = new int[n+1];
		for (int i = 1; i < n+1; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dijkstra();
		for (int i = 1; i <= n; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				bw.write("INF\n");
			} else {
				bw.write(dist[i] + "\n");
			}
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
