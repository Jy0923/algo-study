package graph.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class No24479_깊이우선탐색1 {
	
	static int n, m, r; // 정점의 수, 간선의 수, 시작 정점
	static int u, v;
	static List<List<Integer>> list = new ArrayList<>();
	static int[] arr; 
	static Stack<Integer> stack = new Stack<>(); // DFS 는 스택 사용
	static int cnt = 1;
	
	static void dfs(int r) {
		stack.push(r);
		arr[r] = cnt++;
		
		while(!stack.empty()) {
			int pop = stack.pop();
			
			for(int next : list.get(pop)) {
				if(arr[next] == 0) 
					dfs(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=n; i++)
			list.add(new ArrayList<>());
		
		arr = new int[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i=0; i<=n; i++)
			Collections.sort(list.get(i));
		
		dfs(r);
		
		for(int i=1; i<=n; i++) 
			System.out.println(arr[i]);
	}
}


