package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://chb2005.tistory.com/79
public class Yy_11657_타임머신 {
	
	static int N, M; // 도시개수, 버스개수
	static long[] dist; // 최단 거리 테이블
	static ArrayList<Node> list; 
	static final long INF = Long.MAX_VALUE;
	
	static class Node {
		
		int start; // 나가는 정점
		int end; // 들어오는 정점
		int cost;
		
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	
	// 정점의 개수, 간선의 개수, 출발지
	static void bellmanFord() {
		
		// n-1번의 반복작업 시작
		for(int i=1; i<=N; i++) {
			
			for(Node node : list) {
				// 한번도 들른적 없으면 패스
				if(dist[node.start] == INF) continue;
				
				// 버스 도착점까지의 최소거리가 시작점 + 비용보다 길면 갱신
				if(dist[node.end] > dist[node.start] + node.cost) {
					dist[node.end] = dist[node.start] + node.cost;
					
					// n번째 작업에서 값이 변경되면 무한히 되돌아갈 수 있음
					if(i == N) {
						System.out.println(-1);
						System.exit(0);
					}
				}
			}
		}
		
		for(int i=2; i<=N; i++) 
			System.out.println(dist[i] == INF ? -1 : dist[i]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		
		int a, b, c;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			list.add(new Node(a, b, c));
		}
		
		dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
		
		bellmanFord();
	}
}
