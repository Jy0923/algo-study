package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Yy_13549_숨바꼭질3 {
	
	static int n, k; // 수빈이 위치, 동생 위치
	static int[] d; // 최소 경로 테이블
	static List<List<Node>> list; // 연결리스트
	static final int INF = Integer.MAX_VALUE;
	
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
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		d[start] = 0;
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node pop = pq.poll();
			
			int index = pop.index;
			int cost = pop.cost;
			
			if(d[index] < cost) continue;
			
			int next1 = index - 1;
			int next2 = index + 1;
			int next3 = index * 2;
			
			if(next1 >= 0 && d[next1] > cost + 1) {
				d[next1] = Math.min(d[next1], cost + 1);
				pq.offer(new Node(next1, d[next1]));
			}
			
			if(next2 <= 100000 && d[next2] > cost + 1) {
				d[next2] = Math.min(d[next2], cost + 1);
				pq.offer(new Node(next2, d[next2]));
			}
			
			if(next3 <= 100000 && d[next3] > cost) {
				d[next3] = Math.min(d[next3], cost);
				pq.offer(new Node(next3, d[next3]));
			}
		}
		
		System.out.println(d[k]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		k = Integer.parseInt(arr[1]);
		
		list = new ArrayList<>();
		for(int i=0; i<=100000; i++) 
			list.add(new ArrayList<>());
		
		d = new int[100001];
		Arrays.fill(d, INF);
		
		dijkstra(n);
	}
}
