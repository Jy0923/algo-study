package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Yy1504_특정한최단경로 {
	
	static int N, E; // 정점 개수, 간선 개수
	static int v1, v2;
	static List<List<Node>> list; // 연결리스트
	static int[] d; // 최단 경로 테이블
	static final int INF = Integer.MAX_VALUE;
	
	static class Node implements Comparable<Node> {
		
		int index;
		int cost;
		
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int dijkstra(int start, int end) {
		Arrays.fill(d, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		d[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node pop = pq.poll();
			
			int index = pop.index;
			int cost = pop.cost;
			
			if(d[index] != cost) continue;
			
			for(Node nextNode : list.get(index)) {
				if(d[nextNode.index] > nextNode.cost + cost) {
					d[nextNode.index] = nextNode.cost + cost;
					pq.offer(new Node(nextNode.index, d[nextNode.index]));
				}
			}
		}
		
		return d[end];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i=0; i<=N; i++) 
			list.add(new ArrayList<>());
		
		d = new int[N+1];
		
		int a, b, c;
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c));
			list.get(b).add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int result = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
		int result2 = dijkstra(1, v2) + dijkstra(v1, v2) + dijkstra(v1, N);
		int min = Math.min(Math.abs(result), Math.abs(result2)); // INF + a면 음수가 되니까 절댓값 비교 해주고
		System.out.println(min > INF/2 ? -1 : min); // 대충 크기가 크면 -1 출력
	}
}
