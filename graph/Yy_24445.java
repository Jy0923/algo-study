package graph.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class No24445_너비우선탐색2 {
	
	static int n, m, r;
	static Map<Integer, List<Integer>> map = new HashMap<>();
	static int[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static int order = 1;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());    // 정점의 수
        m = Integer.parseInt(st.nextToken());    // 간선의 수
        r = Integer.parseInt(st.nextToken());    // 시작 정점
        
        for(int i=1; i<=n; i++) 
            map.put(i, new ArrayList<>());
        
        visited = new int[n+1]; // 방문표시
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            map.get(u).add(v);
            map.get(v).add(u);
        }
        
        for(int i=1; i<=n; i++)
            Collections.sort(map.get(i), Collections.reverseOrder()); // 내림차순으로 방문
        
        bfs(r);
        
        for(int i=1; i<=n; i++)
            System.out.println(visited[i]);
    }

	public static void bfs(int r) {
        q.offer(r); // 시작
        visited[r] = order++; // 시작정점에서 출발
        
        while(!q.isEmpty()) {
            int num = q.poll();
            
            for(int next : map.get(num)) {
            	if(visited[next] == 0) {
            		q.offer(next);
            		visited[next] = order++;
            	}
            }
        }
	}
}