package day0424;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 다익스트라랑 유니온파인드 합치면될듯
public class Yy1774 {
	
	static int n, m; // 우주신들의 개수, 이미 연결된 신들과의 통로의 개수
	static Point[] gods; // 신 좌표
	static int[] parent; // 부모저장
	static PriorityQueue<Node> pq;
	
	static class Node implements Comparable<Node> {
		
		int start;
		int end;
		double cost;
		
		public Node(int start, int end, double cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return (int)(this.cost - o.cost);
		}
	}
	
	// 점사이 거리 반환
	static double distance(Point start, Point end) {
		return Math.sqrt(Math.pow(start.x - end.x, 2) + Math.pow(start.y - end.y, 2));
	}
	
	// 부모 찾기
	static int find(int x) {
		if(x == parent[x])
			return x;
		
		return parent[x] = find(parent[x]);
	}
	
	// 합치기
	static void union(int x, int y) {
		x = find(x);
		y = find(y); 
		
		if(x == y) return;
		
		if(x < y)
			parent[y] = x;
		else
			parent[x] = y;
	}
	
	static double kruskal(int n) {
		int cnt = m;
		double answ = 0;
		
		while(!pq.isEmpty()) {
			Node pop = pq.poll();
			int start = pop.start;
			int end = pop.end;
			
			if(find(start) != find(end)) {
				answ += pop.cost;
				
				if(++cnt == n) break;
			}
			
			union(start, end);
		}
		
		return answ;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n+1];
		for(int i=1; i<=n; i++)
			parent[i] = i; // 부모 자신으로 초기화
		
		gods = new Point[n+1];
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			gods[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		pq = new PriorityQueue<>();
		for(int i=1; i<=n; i++) {
			for(int j=i+1; j<=n; j++) {
				double dist = distance(gods[i], gods[j]);
				
				pq.offer(new Node(i, j, dist));
			}
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			union(start, end);
		}
		
		
		double answ = kruskal(n);
		
		System.out.printf("%.2f\n", answ);
	}
	
}
