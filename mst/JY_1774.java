import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Pos{
	int x, y;
	double dist;
	Pos(int x, int y){
		this.x = x;
		this.y = y;
	}
	static double getDist(Pos a, Pos b) {
		double x = a.x - b.x;
		double y = a.y - b.y;
		return Math.sqrt(x * x + y * y);
	}
}

public class Main{
	
	int cnt = 0;
	int n, m;
	String[] input;
	Pos[] gods;
	int[] par;
	ArrayList<double[]> edges;
	
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
	
	public double kruskal() {
		double dist = 0;
		for (double[] e : edges) {
			int a = (int)e[0];
			int b = (int)e[1];
			if (find(a) != find(b)) {
				union(a, b);
				cnt++;
				dist += e[2];
			}
			if (cnt == n-1) {
				break;
			}
		}
		return dist;
	}
	
	public void solution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		gods = new Pos[n+1];
		for (int i = 1; i <= n; i++) {
			input = br.readLine().split(" ");
			gods[i] = new Pos(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}
		
		par = new int[n+1];
		for (int i = 1; i <= n; i++) {
			par[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			if (find(a) != find(b)) {
				cnt++;
				union(a, b);
			}
		}
		
		edges = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				edges.add(new double[] {i, j, Pos.getDist(gods[i], gods[j])});
			}
		}
		edges.sort((e1, e2) -> {
			if (e1[2] == e2[2]) {
				return 0;
			} else if (e1[2] > e2[2]) {
				return 1;
			} else {
				return -1;
			}
		});
		
		double ans = kruskal();
		System.out.printf("%.2f", ans);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
