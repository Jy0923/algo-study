import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	static int v, e, k;
	static int distance[];
	static final int max = Integer.MAX_VALUE;
	static ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());

		distance = new int[v+1];

		Arrays.fill(distance, max);

		for (int i = 0; i <= v; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj.get(u).add(new int[] { v, w });
		}

		PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
		queue.offer(new int[] { 0, k });
		distance[k] = 0;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			if (cur[0] == distance[cur[1]]) {
				for (int[] e : adj.get(cur[1])) {
					if (distance[cur[1]] + e[1] < distance[e[0]]) {
						distance[e[0]] = distance[cur[1]] + e[1];
						queue.offer(new int[] { distance[e[0]], e[0] });
					}
				}
			}
		}
		
		for(int i = 1; i <= v ; i++) {
			if(distance[i] == max) {
				System.out.println("INF");
				
			} else {
				System.out.println(distance[i]);
			}
		}

	}

}

// 바킹독에서 오주영으로 갈아탐
