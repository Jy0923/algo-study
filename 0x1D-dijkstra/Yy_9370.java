package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Yy_9370_미확인도착지 {
	
	static StringBuilder sb = new StringBuilder();
	static int n, m, t; // 교차로, 도로, 목적지 후보의 개수
	static int s, g, h; // 출발지, g와 h 교차로 사이에 있는 도로를 지나감
	static List<List<Node>> list; // 연결리스트
	static final int INF = Integer.MAX_VALUE;
	static int[] dist, tmp;
	static int[] goals; // 목적지 후보들
	
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
	
	static int dijkstra(int start, int end) {
		
		Arrays.fill(dist, INF);
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[start] = 0;
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node pop = pq.poll();
			
			int index = pop.index;
			int cost = pop.cost;
			
			if(dist[index] != cost) continue;
			
			for(Node next : list.get(index)) {
				if(dist[next.index] > next.cost + cost) {
					dist[next.index] = next.cost + cost;
					pq.add(new Node(next.index, dist[next.index]));
				}
			}
		}
		
		return dist[end];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 교차로
			m = Integer.parseInt(st.nextToken()); // 도로 
			t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			list = new ArrayList<>();
			for(int i=0; i<=n; i++)
				list.add(new ArrayList<>());
			
			dist = new int[n+1];
			tmp = new int[n+1];
			
			int a, b, d; // a와 b 사이에 길이 d의 양방향 도로가 있다는 뜻
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken());
				
				list.get(a).add(new Node(b, d));
				list.get(b).add(new Node(a, d));
			}
			
			// 실제 시작정점 -> 목적지까지 최소 경로를 구하기 위해 s ~ n 으로 다익스트라 돌리고
			dijkstra(s, n);
			// 임시배열에 저장해놓기
			tmp = Arrays.copyOf(dist, dist.length);
			
			goals = new int[t];
			for(int i=0; i<t; i++) {
				goals[i] = Integer.parseInt(br.readLine());
			}
			
			Arrays.sort(goals); // 출력을 위해 오름차순 정렬
			
			for(int i=0; i<t; i++) {
				// 시작정점(s) -> g -> h -> i번 목적지
				int result1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, goals[i]); 
				// 시작정점(s) -> h -> g -> i번 목적지
				int result2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, goals[i]);
				// 둘중 최솟값이
				int min = Math.min(result1, result2);
				
				// 실제 시작정점 -> i번 목적지로 가는 최솟값과 동일하면 출력
				if(min == tmp[goals[i]])
					sb.append(goals[i]).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
