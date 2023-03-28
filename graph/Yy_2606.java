package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class No2606_바이러스 {
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 컴터개수
		int m = Integer.parseInt(br.readLine()); // 네트워크에 연결된 컴터 쌍의 수
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i=1; i<=n; i++) 
			map.put(i, new ArrayList<>());
		
		StringTokenizer st;
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map.get(u).add(v);
			map.get(v).add(u);
		}
		
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		
		q.add(1);
		visited[1] = true;
		
		while(!q.isEmpty()) {
			int next = q.poll();
			
			for(int i : map.get(next)) {
				if(!visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		
		int cnt = 0;
		for(int i=2; i<=n; i++) {
			if(visited[i]) cnt++;
		}
		
		System.out.println(cnt);
	}
}
