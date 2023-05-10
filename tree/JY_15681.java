import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main{
	
	int n, r, q, a, b;
	ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	String[] input;
	
	int[] size;
	int[] par;
	
	public int makeTree(int cur, int p) {
		par[cur] = p;
		int s = 1;
		for (int nxt : adjList.get(cur)) {
			if (par[nxt] == 0) {
				s += makeTree(nxt, cur);
			}
		}
		size[cur] = s;
		return s;
	}
	
	public void solution() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		r = Integer.parseInt(input[1]);
		q = Integer.parseInt(input[2]);
		
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		for (int i = 0; i < n-1; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}
		
		size = new int[n+1];
		par = new int[n+1];
		makeTree(r, -1);
		
		for (int i = 0; i < q; i++) {
			bw.write(size[Integer.parseInt(br.readLine())] + "\n");
		}
		bw.flush();
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
