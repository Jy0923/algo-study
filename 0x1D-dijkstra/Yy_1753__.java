package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	
	int u, v;
	
	public Node(int u, int v) {
		this.u = u;
		this.v = v;
	}
	
	@Override
	public int compareTo(Node o) {
		return this.v - o.v;
	}
}

public class 최단경로 {
	
	static ArrayList<Node>[] list;
	static int[] distance;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V + 1];
		for(int i=1;i<list.length;i++) 
			list[i] = new ArrayList<Node>();
		for(int i=0;i<E;i++) {           
			st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());    //노드1
	        int b = Integer.parseInt(st.nextToken());    //노드2
	        int w = Integer.parseInt(st.nextToken());    // 거리
	        list[a].add(new Node(b,w));		
		}
			
		distance = new int[V+1]; 
		Arrays.fill(distance, Integer.MAX_VALUE); 
		distance[start] = 0; 
		
		dijkstra(start);
		
		final int INF = Integer.MAX_VALUE;
		
		for(int i=1;i<distance.length;i++) 
			System.out.println(distance[i] == INF ? "INF" : distance[i]);
	}
	
	private static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>(); 
		pq.add(new Node(s,0)); 
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			for(Node next : list[now.u]) {
				if(distance[next.u] > now.v + next.v) {
					distance[next.u] = now.v + next.v;
					pq.add(new Node(next.u, distance[next.u]));
				}
			}			
		}
	}
}
