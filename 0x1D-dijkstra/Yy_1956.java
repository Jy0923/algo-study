package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Yy_1956_운동 {
	
	static int v, e; // 마을개수, 도로 개수
	static List<List<Node>> list; // 연결리스트
	static int[] dist; // 최단경로
	static final int INF = Integer.MAX_VALUE;
	static int min = INF;
	
	static class Node implements Comparable<Node>{
		
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
	
	static void dijkstra(int start) {
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node pop = pq.poll();
			
			int index = pop.index;
			int cost = pop.cost;
			
			if(dist[index] != cost) continue;
			
			for(Node next : list.get(index)) {
				if(dist[next.index] > next.cost + cost) {
					dist[next.index] = next.cost + cost;
					pq.offer(new Node(next.index, dist[next.index]));
				}
				
				if(dist[next.index] == 0) {
					dist[next.index] = next.cost + cost;
					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}
		
		boolean isCycle = true;
		for(int i=1; i<=v; i++) {
			if(dist[i] == 0) {
				isCycle = false;
				break;
			}
		}
		
		if(isCycle) 
			min = Math.min(min, dist[start]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i=0; i<=v; i++)
			list.add(new ArrayList<>());
		
		dist = new int[v+1];
		
		int a, b, c;
		for(int i=0; i<e; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b, c)); 
		}
		
		for(int i=1; i<=v; i++) 
			dijkstra(i);
		
		System.out.println(min == INF ? -1 : min);
	}
}
