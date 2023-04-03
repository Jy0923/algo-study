import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	
	int T, n, m, t, s, g, h, a, b, d, gh;
	String[] input;
	ArrayList<ArrayList<int[]>> adjList;
	ArrayList<Integer> cand;
	ArrayList<Integer> ans;
	
	int[] sDist;
	int[] gDist;
	int[] hDist;
	
	public void setDist(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.MAX_VALUE;
		}
	}
	
	public void dijkstra(int[] dist, int st) {
		int[] cur;
		
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
		pq.offer(new int[] {0, st});
		dist[st] = 0;
		while (!pq.isEmpty()) {
			cur = pq.poll();
			if (dist[cur[1]] == cur[0]) {
				for (int[] e : adjList.get(cur[1])) {
					if (e[1] + cur[0] < dist[e[0]]) {
						dist[e[0]] = e[1] + cur[0];
						pq.offer(new int[] {dist[e[0]], e[0]});
					}
				}
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			t = Integer.parseInt(input[2]);

			input = br.readLine().split(" ");
			s = Integer.parseInt(input[0]);
			g = Integer.parseInt(input[1]);
			h = Integer.parseInt(input[2]);
			
			adjList = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				adjList.add(new ArrayList<>());
			}
			
			for (int i = 0; i < m; i++) {
				input = br.readLine().split(" ");
				a = Integer.parseInt(input[0]);
				b = Integer.parseInt(input[1]);
				d = Integer.parseInt(input[2]);
				adjList.get(a).add(new int[] {b, d});
				adjList.get(b).add(new int[] {a, d});
			}
			
			cand = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				cand.add(Integer.parseInt(br.readLine()));
			}
			// s, g, h, cand
			// s, h, g, cand
			sDist = new int[n+1];
			gDist = new int[n+1];
			hDist = new int[n+1];
			setDist(sDist);
			setDist(gDist);
			setDist(hDist);
			
			dijkstra(sDist, s);
			dijkstra(gDist, g);
			dijkstra(hDist, h);
			
			ans = new ArrayList<>();
			int sghe, shge, se;
			for (int e : cand) {
				sghe = sDist[g] + gDist[h] + hDist[e];
				shge = sDist[h] + hDist[g] + gDist[e];
				se = sDist[e];
				if (se == Integer.MAX_VALUE) {
					continue;
				}
				if (se == sghe || se == shge) {
					ans.add(e);
				}
			}
			ans.sort((e1, e2) -> e1 - e2);
			for (int e : ans) {
				bw.write(e + " ");
			}
			bw.newLine();
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
