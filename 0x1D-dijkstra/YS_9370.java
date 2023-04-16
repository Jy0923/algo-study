import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n, m, t;
	static int s, g, h;
	static int a, b, d;
	static int dest[];
	static int dist[];
	static PriorityQueue<int[]> queue;
	static ArrayList<ArrayList<int[]>> list;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			list = new ArrayList<>();
			queue = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);

			for (int i = 0; i <= n; i++) {
				list.add(new ArrayList<>());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());

				list.get(a).add(new int[] { b, d });
				list.get(b).add(new int[] { a, d });

			}

			dest = new int[t];

			for (int j = 0; j < dest.length; j++) {
				dest[j] = Integer.parseInt(br.readLine());
			}
			int min = Integer.MAX_VALUE;

			dijkstra(s);
			int[] dist1 = Arrays.copyOf(dist, dist.length);
			
			int first = dist[g];
			dijkstra(g);
			first += dist[h];
			dijkstra(h);

			int[] dist2 = Arrays.copyOf(dist, dist.length);
			
			dijkstra(s);
			int second = dist[h];
			dijkstra(h);
			second += dist[g];
			dijkstra(g);

			int[] dist3 = Arrays.copyOf(dist, dist.length);
			Arrays.sort(dest);
			
			for (int e : dest) {
				if((dist2[e] + first == dist1[e]) || (dist3[e] + second == dist1[e])) {
					System.out.print(e + " ");
				}
			}


		}

	}

	private static void dijkstra(int start) {
		dist = new int[n + 1];

		int max = Integer.MAX_VALUE;

		Arrays.fill(dist, max);
		queue.offer(new int[] { start, 0 });

		dist[start] = 0;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			int curr = temp[0];
			int distance = temp[1];
			if (dist[curr] == distance) {
				for (int[] next : list.get(curr)) {
					if (dist[next[0]] > dist[curr] + next[1]) {
						dist[next[0]] = dist[curr] + next[1];
						queue.offer(new int[] { next[0], dist[next[0]] });
					}
				}

			}

		}


	}
}
