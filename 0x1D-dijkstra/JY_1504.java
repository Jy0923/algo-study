import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main{

	int n, m, u, v, w, v1, v2;
	String[] input;
	ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
	int[] dist1, distV1, distV2;
	
	public void initDist(int[] d) {
		for (int i = 1; i <= n; i++) {
			d[i] = Integer.MAX_VALUE;
		}
	}
	
	public void dijkstra(int st, int[] dist) {
		int[] cur;
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
		dist[st] = 0;
		pq.offer(new int[] {0, st});
		
		while (!pq.isEmpty()) {
			cur = pq.poll();
			if (dist[cur[1]] == cur[0]) {
				for (int[] e : adjList.get(cur[1])) {
					if (dist[e[0]] > cur[0] + e[1]) {
						dist[e[0]] = cur[0] + e[1];
						pq.offer(new int[] {dist[e[0]], e[0]});
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
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			u = Integer.parseInt(input[0]);
			v = Integer.parseInt(input[1]);
			w = Integer.parseInt(input[2]);
			adjList.get(u).add(new int[] {v, w});
			adjList.get(v).add(new int[] {u, w});
		}
		input = br.readLine().split(" ");
		v1 = Integer.parseInt(input[0]);
		v2 = Integer.parseInt(input[1]);
		
		dist1 = new int[n+1];
		distV1 = new int[n+1];
		distV2 = new int[n+1];
		initDist(dist1);
		initDist(distV1);
		initDist(distV2);
		
		dijkstra(1, dist1);
		dijkstra(v1, distV1);
		dijkstra(v2, distV2);

		int stTov1 = dist1[v1];
		int stTov2 = dist1[v2];
		int v1v2 = distV1[v2];
		int v1Toen = distV1[n];
		int v2Toen = distV2[n];

		int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
		if (stTov1 != Integer.MAX_VALUE && v1Toen != Integer.MAX_VALUE) {
			r1 = stTov1 + v1v2 + v2Toen;
		}
		if (stTov2 != Integer.MAX_VALUE && v2Toen != Integer.MAX_VALUE) {
			r2 = stTov2 + v1v2 + v1Toen;
		}
		
		if (r1 == Integer.MAX_VALUE && r2 == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(r1, r2));
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
