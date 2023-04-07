import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			tree.get(a).add(b);
			tree.get(b).add(a);

		}
		boolean[] visited = new boolean[n+1];
		int[] parent = new int[n+1];
		parent[1] = 0;
		visited[1] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (Integer next : tree.get(curr)) {
				if(visited[next]) continue;
				visited[next] = true;
				parent[next] = curr;
				queue.offer(next);
			}
		}
		for (int i = 2; i <= n; i++) {
			System.out.println(parent[i]);
		}

	}
}
