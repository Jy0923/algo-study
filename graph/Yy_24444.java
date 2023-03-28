package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class No24444_너비우선탐색1 {
	
	static List<List<Integer>> list = new ArrayList<>(); // 연결 노드 나타낼 리스트
	static boolean[] isVisit;
	static int n, m, r;
	static Queue<Integer> q = new LinkedList<>();
	static int[] arr;
	static int cnt = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); // 정점의 수
		m = Integer.parseInt(st.nextToken()); // 간선의 수
		r = Integer.parseInt(st.nextToken()); // 시작정점
		
		for(int i=0; i<n+1; i++) 
			list.add(new ArrayList<>());
		
		arr = new int[n+1];
		isVisit = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i=0; i<n; i++) 
			Collections.sort(list.get(i));
		
		q.offer(r); // 시작점 큐에 삽입(인덱스라서 -1)
		isVisit[r] = true; // 방문 표시
		
		// 큐가 빌때까지 반복
		while(!q.isEmpty()) {
			int point = q.poll(); // 큐에서 뺀 정점
			arr[point] = cnt++;
			
			List<Integer> tmpList = list.get(point);
			
			for(int i=0; i<tmpList.size(); i++) {
				int nextNum = tmpList.get(i);
				
				// 이미 방문했으면 패스
				if(isVisit[nextNum]) continue;
				
				q.offer(nextNum);
				isVisit[nextNum] = true;
			}
		}
		
		for(int i=1; i<=n; i++) {
			System.out.println(arr[i]);
		}
	}
	
}
