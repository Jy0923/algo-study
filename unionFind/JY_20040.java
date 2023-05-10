import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	
	int n, m, a, b;
	String[] input;
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
	
	public boolean sameSet(int x, int y) {
		x = find(x);
		y = find(y);
		return x==y ? true : false;
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		par = new int[n];
		for (int i = 0; i < n; i++) {
			par[i] = i;
		}
		
		for (int i = 1; i <= m; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			if (sameSet(a, b)) {
				System.out.println(i);
				System.exit(0);
			} else {
				union(a, b);
			}
		}
		System.out.println(0);
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
