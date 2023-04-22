import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Edge{
	int a, b;
	double d;
	Edge(int a, int b, double d){
		this.a = a;
		this.b = b;
		this.d = d;
	}
}

public class Main{
	
	int n;
	int[] par;
	String[] input;
	double[][] stars;
	ArrayList<Edge> edges;
	
	public double getDist(int i, int j) {
		double x = stars[i][0] - stars[j][0];
		double y = stars[i][1] - stars[j][1];
		return Math.sqrt(x * x + y * y);
	}
	
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
		edges.sort((e1, e2) -> {
			if (e1.d == e2.d) {
				return 0;
			} else if (e1.d > e2.d) {
				return 1;
			} else {
				return -1;
			}
		});
		
		par = new int[n];
		for (int i = 0; i < n; i++) {
			par[i] = i;
		}
		
		double weight = 0;
		int cnt = 1;
		
		for (Edge e : edges) {
			if (find(e.a) != find(e.b)) {
				union(e.a, e.b);
				cnt++;
				weight += e.d;
			}
			if (cnt == n) {
				break;
			}
		}
		
		return weight;
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		stars = new double[n][2];
		for (int i = 0; i < n; i++) {
			input = br.readLine().split(" ");
			stars[i][0] = Double.parseDouble(input[0]);
			stars[i][1] = Double.parseDouble(input[1]);
		}
		
		edges = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				edges.add(new Edge(i, j, getDist(i, j)));
			}
		}
		
		System.out.println(kruskal());
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
