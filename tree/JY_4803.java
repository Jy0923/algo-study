import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int n, m, a, b, cnt;
	ArrayList<ArrayList<Integer>> adjList;
	
	public void init() throws Exception {
		String[] input;
		
		input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);
		
		adjList = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			adjList.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			input = br.readLine().split(" ");
			a = Integer.parseInt(input[0]);
			b = Integer.parseInt(input[1]);
			adjList.get(a).add(b);
			adjList.get(b).add(a);
		}
	}
	
	public void getCnt() {
		int cur, parCnt;
		boolean check;
		
		cnt = 0;
		int[] par = new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			if (par[i] != 0) {
				continue;
			}
			check = true;
			LinkedList<Integer> q = new LinkedList<>();
			q.offer(i);
			par[i] = -1;
			while (!q.isEmpty()) {
				cur = q.poll();
				parCnt = 0;
				for (int nxt : adjList.get(cur)) {
					if (par[nxt] != 0) {
						parCnt++;
						continue;
					}
					par[nxt] = cur;
					q.offer(nxt);
				}
				if (parCnt > 1) {
					check = false;
				}
			}
			
			if (check) {
				cnt++;
			}
		}
	}
	
	public void solution() throws Exception {
		int tc = 1;
		while (true) {
			init();
			
			if (n == 0 && m == 0) {
				break;
			}			
			
			getCnt();
			
			if (cnt == 0) {
				System.out.println("Case " + tc + ": No trees.");
			} else if (cnt == 1) {
				System.out.println("Case " + tc + ": There is one tree.");
			} else {
				System.out.println("Case " + tc + ": A forest of " + cnt + " trees.");
			}
			tc++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		new Main().solution();
	}
}
