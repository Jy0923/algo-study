import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	int n, m;
	int[][] adjMat;
	String[] input;
	int[] par;
	int[] path;
	
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
		if (x < y) {
			par[y] = x;
		} else {
			par[x] = y;
		}
	}
	
	public void unionAll() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (adjMat[i][j] == 1) {
					union(i, j);
				}
			}
		}
	}
	
	public boolean possible() {
		for (int i = 1; i < m; i++) {
			if (find(path[i-1]) != find(path[i])) {
				return false;
			}
		}
		return true;
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		adjMat = new int[n+1][n+1];
		path = new int[m];
		for (int r = 1; r <= n; r++) {
			input = br.readLine().split(" ");
			for (int c = 1; c <= n; c++) {
				adjMat[r][c] = Integer.parseInt(input[c-1]);
			}
		}
		
		input = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			path[i] = Integer.parseInt(input[i]);
		}
		
		par = new int[n+1];
		for (int i = 0; i <= n; i++) {
			par[i] = i;
		}
		
		unionAll();
		if (possible()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}

