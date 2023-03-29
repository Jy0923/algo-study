import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int e;
	static int u;
	static int v;
	static ArrayList<ArrayList<int[]>> list = new ArrayList<>();
	static PriorityQueue<int[]> queue;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 무방향 그래프라서 두 정점을 모두 연결해줘야 한다.
			list.get(a).add(new int[] { b, c });
			list.get(b).add(new int[] { a, c });
		}

		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		queue = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);

		long sum1 = 0;
		long sum2 = 0;

		// 1번 -> 2번 경로
		// 2번 -> 1번 경로
		sum1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, n);
		sum2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, n);

		long sum = Math.min(sum1, sum2);

		// 표현할 수 있는 값이 초과해서 음수가 나오거나, 최대값보다 같거나 크다면 -1 출력
		if (sum < 0 || sum >= 200000000) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
		}

	}

	private static long dijkstra(int start, int end) {
		distance = new int[n + 1];

		// 간선의 개수는 최대 200,000개
		// 최대 길이는 1,000
		// 둘을 곱한 200,000,000을 최대로
		Arrays.fill(distance, 200000000);
		distance[start] = 0;

		// 중복 방문을 피하기 위한 visited 배열
		boolean[] visited = new boolean[n + 1];
		queue.offer(new int[] { 0, start });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			// poll을 한 값을 방문했으면 continue;
			if (visited[cur[1]])
				continue;
			visited[cur[1]] = true;

			if (cur[0] == distance[cur[1]]) {
				for (int[] e : list.get(cur[1])) {

					// 다음에 보고 있는 정점의 거리가 여기서 가는 것보다 길게 되어 있으면 갱신
					// 이미 방문한 정점이면 continue;
					if ((distance[cur[1]] + e[1] <= distance[e[0]]) && !visited[e[0]]) {
						distance[e[0]] = distance[cur[1]] + e[1];
						queue.offer(new int[] { distance[e[0]], e[0] });
					}
				}
			}

		}

		// end까지의 거리를 출력
		return distance[end];

	}
}
