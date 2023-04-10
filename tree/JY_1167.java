import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Node {
	int v, w;

	Node(int v, int w) {
		this.v = v;
		this.w = w;
	}
}

public class Main {

	int n;
	String[] input;
	ArrayList<ArrayList<Node>> adjList = new ArrayList<>();

	public int[] bfs(int st) {
		int cur;
		int[] visited = new int[n + 1];
		Arrays.fill(visited, -1);
		LinkedList<Integer> q = new LinkedList<>();
		q.offer(st);
		visited[st] = 0;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (Node nxt : adjList.get(cur)) {
				if (visited[nxt.v] == -1) {
					visited[nxt.v] = visited[cur] + nxt.w;
					q.offer(nxt.v);
				}
			}
		}

		int en = 0;
		int maxDist = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			if (visited[i] > maxDist) {
				maxDist = visited[i];
				en = i;
			}
		}

		return new int[] { en, maxDist };
	}

	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			int curNode = Integer.parseInt(input[0]);
			for (int j = 0; j < (input.length - 2) / 2; j++) {
				adjList.get(curNode)
						.add(new Node(Integer.parseInt(input[j * 2 + 1]), Integer.parseInt(input[j * 2 + 2])));
			}
		}

		int[] ans = bfs(1);
		ans = bfs(ans[0]);
		System.out.println(ans[1]);
	}

	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
