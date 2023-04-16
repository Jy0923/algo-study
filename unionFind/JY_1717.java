import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main{
	
	int n, m, cmd, a, b;
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
		if (x < y) {
			par[y] = x;
		} else {
			par[x] = y;
		}
	}
	
	public void solution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		par = new int[n+1];
		for (int i = 0; i <= n; i++) {
			par[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			cmd = Integer.parseInt(input[0]);
			a = Integer.parseInt(input[1]);
			b = Integer.parseInt(input[2]);
			if (cmd == 0) {
				union(a, b);
			} else {
				a = find(a);
				b = find(b);
				if (a == b) {
					bw.write("YES\n");
				} else {
					bw.write("NO\n");
				}
			}
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
