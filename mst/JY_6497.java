import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main{
	
	int n, m, x, y, z;
	String[] input;
	ArrayList<int[]> edges;
	int[] par;
	
	public int find(int x) {
		if (par[x] == x) {
			return x;
		}
		par[x] = find(par[x]);
		return par[x];
	}
	
	public void union(int x, int y) {
		x = find(x);
		y = find(y);
		if (y > x) {
			par[y] = x;
		} else {
			par[x] = y;
		}
	}
	
	public int kruskal() {
		par = new int[n];
		for (int i = 0; i < n; i++) {
			par[i] = i;
		}
		edges.sort((e1, e2) -> e1[2] - e2[2]);
		
		int cnt = 0;
		int cost = 0;
		for (int[] e : edges) {
			if (find(e[0]) != find(e[1])) {
				union(e[0], e[1]);
				cost += e[2];
				cnt++;
			}
			if (cnt == n-1) {
				break;
			}
		}
		
		return cost;
	}
	
	public void solution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {			
			input = br.readLine().split(" ");
			n = Integer.parseInt(input[0]);
			m = Integer.parseInt(input[1]);
			if (n == 0 && m == 0) {
				break;
			}
			int sum = 0;
			edges = new ArrayList<>();
			for (int i = 0; i < m; i++) {
				input = br.readLine().split(" ");
				x = Integer.parseInt(input[0]);
				y = Integer.parseInt(input[1]);
				z = Integer.parseInt(input[2]);
				sum += z;
				edges.add(new int[] {x, y, z});
			}
			System.out.println(sum - kruskal());
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
