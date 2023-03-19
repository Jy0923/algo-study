package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Bk_11286 {

	static int N;

	static class Node implements Comparable<Node> {
		int num;
		int absNum;

		public Node(int num, int absNum) {
			this.num = num;
			this.absNum = absNum;
		}

		@Override
		public int compareTo(Node o) {
			if (absNum == o.absNum) {
				return num - o.num;
			}
			return absNum - o.absNum;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		int x = 0;
		for (int i = 0; i < N; i++) {
			x = Integer.parseInt(br.readLine());
			if (x != 0)
				queue.add(new Node(x, Math.abs(x)));
			else {
				Node node = queue.poll();
				if (node == null)
					sb.append(0 + "\n");
				else
					sb.append(node.num + "\n");
			}
		}

		System.out.println(sb);
	}

}
