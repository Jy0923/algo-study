package graph.bfs.bkd;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1697_숨바꼭질 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 수빈이의 위치
		int k = sc.nextInt(); // 동생의 위치
		
		Queue<Integer> q = new LinkedList<>(); 
		int[] dist = new int[100001];
		for(int i=0; i<100001; i++)
			dist[i] = -1;
		
		// 수빈 위치에서 시작
		q.add(n); 
		dist[n] = 0;
		
		while(!q.isEmpty()) {
			int start = q.poll();
			int[] delta = {-1, 1, start};
			
			for(int i=0; i<3; i++) {
				int move = start + delta[i];
				
				// 범위 벗어나면 패스(원래 200000까지 해야함(생각해보기))
				if(move < 0 || move > 100000) continue;
				
				// 이미 지나갔으면 패스
				if(dist[move] != -1) continue;
				
				// 큐에 넣고 방문표시
				q.add(move);
				dist[move] = dist[start] + 1;
			}
		}
		
		System.out.println(dist[k]);
	}
}
