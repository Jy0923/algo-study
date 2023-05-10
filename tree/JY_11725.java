import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main{
	
	int n, a, b;
	ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	int[] parent;
	
	public void dfs(int cur, int par) {
		parent[cur] = par;
		for (int nxt : adjList.get(cur)) {
			if (parent[nxt] == 0) {
				dfs(nxt, cur);
			}
		}
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n-1; i++) {
			String[] input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}
		
		parent = new int[n+1];
		dfs(1, -1);
		for (int i = 2; i <= n; i++) {
			bw.write(parent[i] + "\n");
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
