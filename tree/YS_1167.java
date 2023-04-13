import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int v;
	static ArrayList<ArrayList<int[]>> tree;
	static boolean[] visited;
	static int[] parent;
	
    public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = Integer.parseInt(br.readLine());
		
		tree = new ArrayList<>();
		visited = new boolean[v+1];
		parent = new int[v+1];
		
		for (int i = 0; i <= v; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i = 1; i <= v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int vertex = Integer.parseInt(st.nextToken());
			while(true) {
				int e = Integer.parseInt(st.nextToken());
				if(e == -1) break;
				int w = Integer.parseInt(st.nextToken());
				tree.get(vertex).add(new int[] {e, w});
			}
			
		}
		
		dfs(1);
		int maxIdx = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= v; i++) {
			if(parent[i] > max) {
				max = parent[i];
				maxIdx = i;
			}
		}
		
		parent = new int[v+1];
		visited = new boolean[v+1];
		dfs(maxIdx);
		
		max = Integer.MIN_VALUE;
		for (int i = 1; i <= v; i++) {
			if(parent[i] > max) {
				max = parent[i];
			}
		}
		System.out.println(max);
		
	}
    
    static void dfs(int vertex) {
    	visited[vertex] = true;
    	for (int[] temp : tree.get(vertex)) {
			int next = temp[0];
			int weight = temp[1];
			if(visited[next]) continue;
			parent[next] = parent[vertex] + weight;
			dfs(next);
		}
    }
    
}
