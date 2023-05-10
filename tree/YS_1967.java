import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static ArrayList<ArrayList<int[]>> tree;
	static int len;
	static int idx;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		tree = new ArrayList<>();
		
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			tree.get(parent).add(new int[] {child, weight});
			tree.get(child).add(new int[] {parent, weight});
		}
		len = 0;
		idx = 0;
		visited = new boolean[n+1];
		dfs(1, 0);
		
		visited = new boolean[n+1];
		len = 0;
		dfs(idx, 0);
		System.out.println(len);
		
	}

	private static void dfs(int start, int length) {
		visited[start] = true;
		if(length > len) {
			len = length;
			idx = start;
		}
		for (int[] temp : tree.get(start)) {
			int next = temp[0];
			int weight = temp[1];
			if(visited[next]) continue;
			dfs(next, length + weight);
		}
		
		
		
		
	}
}
