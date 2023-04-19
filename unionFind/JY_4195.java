import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main{
	
	int t, f, aId, bId, n;
	HashMap<String, Integer> nameToId;
	int[] par, size;
	String[] input;
	String a, b;
	
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
		
		if (x == y) {
			return; 
		}
		
		if (y > x) {
			par[y] = x;
		} else {
			par[x] = y;
		}
		int s = size[x] + size[y];
		size[x] = s;
		size[y] = s;
	}
	
	public void solution() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {
			f = Integer.parseInt(br.readLine());
			n = 0;
			par = new int[2 * f];
			for (int i = 0; i < 2 * f; i++) {
				par[i] = i;
			}
			size = new int[2 * f];
			Arrays.fill(size, 1);
			nameToId = new HashMap<>();
			for (int i = 0; i < f; i++) {
				input = br.readLine().split(" ");
				a = input[0];
				b = input[1];
				
				if (nameToId.containsKey(a)) {
					aId = nameToId.get(a);
				} else {
					aId = n++;
					nameToId.put(a, aId);
				}
				
				if (nameToId.containsKey(b)) {
					bId = nameToId.get(b);
				} else {
					bId = n++;
					nameToId.put(b, bId);
				}
				union(aId, bId);
				bw.write(size[find(aId)] + "\n");
			}
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
