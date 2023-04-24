import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static int numOfGod, connected;

	static double length;

	static int[] conArr;

	static God[] godArr;

	static PriorityQueue<Distance> disQue = new PriorityQueue<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read;

		length = 0;

		read = br.readLine().split(" ");
		numOfGod = Integer.parseInt(read[0]);
		connected = Integer.parseInt(read[1]);

		godArr = new God[numOfGod + 1];

		for (int i = 1; i <= numOfGod; i++) {
			read = br.readLine().split(" ");
			int x = Integer.parseInt(read[0]);
			int y = Integer.parseInt(read[1]);

			godArr[i] = new God(x, y);
		}

		conArr = new int[numOfGod + 1];

		for (int i = 1; i <= numOfGod; i++) {
			conArr[i] = i;
		}

		for (int i = 0; i < connected; i++) {
			read = br.readLine().split(" ");
			int a = Integer.parseInt(read[0]);
			int b = Integer.parseInt(read[1]);
			union(a, b);
		}

		getDistance();

		getMinDis();

		System.out.printf("%.2f", length);
	}

	private static void getMinDis() {
		while (!disQue.isEmpty()) {
			Distance cur = disQue.poll();
			int a = cur.from;
			int b = cur.to;

			if (find(a) == find(b))
				continue;

			length += cur.dis;
			union(a, b);
			connected++;
		}
	}

	private static void getDistance() {
		for (int i = 1; i <= numOfGod; i++) {
			for (int j = i + 1; j <= numOfGod; j++) {
				God a = godArr[i];
				God b = godArr[j];

				double curDistance = Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));

				disQue.offer(new Distance(i, j, curDistance));
			}
		}
	}

	private static int find(int a) {
		if (conArr[a] == a)
			return a;
		else
			return conArr[a] = find(conArr[a]);
	}

	private static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);

		if (parentA != parentB) {
			if (parentA < parentB) {
				conArr[parentB] = parentA;
			} else {
				conArr[parentA] = parentB;
			}
		}
	}

	private static class Distance implements Comparable<Distance> {
		int from, to;
		double dis;

		public Distance(int from, int to, double dis) {
			this.from = from;
			this.to = to;
			this.dis = dis;
		}

		@Override
		public int compareTo(Distance o) {
			if(this.dis > o.dis) {
				return 1;
			} else if (this.dis == o.dis) {
				return 0;
			}
			return -1;
		}
	}

	private static class God {
		int x, y;

		public God(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}