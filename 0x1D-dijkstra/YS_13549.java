import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int k;
	static int[] map;

	static PriorityQueue<Point> queue;
	static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[100005];

		queue = new PriorityQueue<>();
		distance = new int[200005];

		Arrays.fill(distance, Integer.MAX_VALUE);

		queue.offer(new Point(n, 0));
		distance[n] = 0;

		while (!queue.isEmpty()) {

			Point cur = queue.poll();

			int currentVer = cur.x;
			int currentDis = cur.y;

			int next = currentVer + 1;
			int cost = currentDis + 1;
			if (next <= 100000 && cost < distance[next]) {
				distance[next] = cost;
				queue.offer(new Point(next, cost));
			}

			next = currentVer - 1;
			cost = currentDis + 1;
			if (0 <= next && cost < distance[next]) {
				distance[next] = cost;
				queue.offer(new Point(next, cost));
			}

			next = currentVer * 2;
			cost = currentDis;
			if (next <= 100000 && cost < distance[next]) {
				distance[next] = cost;
				queue.offer(new Point(next, cost));
			}

		}

		System.out.println(distance[k]);

	}

	static class Point implements Comparable<Point> {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Point that) {
			if (this.y > that.y) {
				return 1;
			} else if (this.y < that.y) {
				return -1;
			}
			return 0;
		}
	}
}
