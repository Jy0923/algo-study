package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class No24480_깊이우선탐색2 {
	
	static int n, m, r;
	static Map<Integer, List<Integer>> map = new HashMap<>();
	static int[] visited;
	static int order = 1;
	
	static void dfs(int r) {
		visited[r] = order++;
		
		for(int next : map.get(r)) {
			if(visited[next] == 0) 
				dfs(next);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=n; i++)
			map.put(i, new ArrayList<>());
		
		visited = new int[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map.get(u).add(v);
			map.get(v).add(u);
		}
		
		for(int i=1; i<=n; i++)
			Collections.sort(map.get(i), Collections.reverseOrder()); // 내림차순
		
		dfs(r);
		
		for(int i=1; i<=n; i++)
			System.out.println(visited[i]);
	}

}
