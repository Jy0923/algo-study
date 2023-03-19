import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	int n, m, r;
	int cnt = 0;
	String[] input;
	ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	int[] visited;
	Queue<Integer> q = new LinkedList<>();
	
	public void bfs(int r) throws Exception {
		visited[r] = ++cnt;
		q.offer(r);
		int cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			for (int i : list.get(cur)) {
				if (visited[i] != 0) {
					continue;
				}
				visited[i] = ++cnt;
				q.offer(i);
			}
		}
	}
	
	public void solution() throws Exception {
		
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		r = Integer.parseInt(input[2]);
		
		for (int i = 0; i < n+1; i++) {
			list.add(new ArrayList<>());
		}
		
		int a, b;
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		for (int i = 1; i < n+1; i++) {
			list.get(i).sort((e1, e2) -> e2 - e1);
		}
		
		visited = new int[n+1];
		bfs(r);
		for(int i = 1; i < n+1; i++) {
			bw.write(visited[i] + "\n");
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
