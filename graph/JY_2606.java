import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main{
	
	int n, m;
	ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	String[] input;
	int answer = 0;
	
	public void bfs() {
		int cur;
		
		boolean[] visited = new boolean[n+1];
		LinkedList<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;
		
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int nxt : list.get(cur)) {
				if (visited[nxt]) {
					continue;
				}
				q.offer(nxt);
				visited[nxt] = true;
				answer++;
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<>());
		}
		
		int u, v;
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			u = Integer.parseInt(input[0]);
			v = Integer.parseInt(input[1]);
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		bfs();
		System.out.println(answer);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
