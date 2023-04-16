package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Bk_1753 {

	// 정점 개수, 간선의 개수
	static int V, E;

	// 시작 정점
	static int start;

	// 인접 리스트
	static List<List<Node>> graph = new ArrayList<>();

	// 최단 거리 테이블
	static int[] distance;

	static final int INF = Integer.MAX_VALUE;

	static class Node implements Comparable<Node> {
		// 정점
		int index;
		// 거리
		int cost;

		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		// 최단 거리 기준 오름차순 정렬
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}

	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		// 정점의 개수
		V = Integer.parseInt(input[0]);
		// 간선의 개수
		E = Integer.parseInt(input[1]);

		// 시작 정점
		start = Integer.parseInt(br.readLine());

		// 그래프 생성
		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}

		// 최단거리 테이블 생성
		distance = new int[V + 1];

		// 최단 거리 테이블 초기화
		Arrays.fill(distance, INF);

		// u에서 v로 가는 가중치 w인 간선
		int u = 0, v = 0, w = 0;
		for (int i = 0; i < E; i++) {
			input = br.readLine().split(" ");
			u = Integer.parseInt(input[0]);
			v = Integer.parseInt(input[1]);
			w = Integer.parseInt(input[2]);

			graph.get(u).add(new Node(v, w));
		}

		dijkstra(start);

		for (int i = 1; i <= V; i++) {
			if(distance[i] == INF) sb.append("INF" + "\n");
			else sb.append(distance[i] + "\n");
		}
		
		System.out.println(sb);
	}

	static void dijkstra(int start) {
		// 최단거리가 갱신된 노드들을 담을 우선순위 큐 생성
		PriorityQueue<Node> Q = new PriorityQueue<>();

		// 최단거리 테이블의 시작지점 노드 값을 0으로 갱신함 - 시작노드에서 시작 노드로 가는 값은 0이다.
		distance[start] = 0;

		// 우선순위 큐에 시작 노드 넣기
		Q.offer(new Node(start, 0));

		// 우선순위 큐에 노드가 존재하면 계속해서 반복
		while (!Q.isEmpty()) {

			// 시작점에서 가장 가까운 노드 꺼내기
			Node node = Q.poll();

			// 꺼낸 노드의 인덱스 및 최단거리 비용
			int index = node.index;
			int cost = node.cost;

			// 만약 지금 꺼낸 노드의 거리가 최단 거리 테이블의 값보다 크다면 해당 노드는 이전에 방문된 노드
			// 해당노드와 연결 된 노드를 탐색하지 않고 큐에서 다음 노드를 꺼냄
			if (cost > distance[index])
				continue;

			// 큐에서 꺼낸 노드에서 이동 가능한 노드들 탐색
			for (Node linkedNode : graph.get(index)) {
				// 현재 해당 노드를 경유해서 다음 노드로 이동한 값이 다음 이동 노드의 최단거리 테이블값보다 작을 떄
				if (cost + linkedNode.cost < distance[linkedNode.index]) {
					// 최단 거리 갱신
					distance[linkedNode.index] = cost + linkedNode.cost;
					// 갱신된 노드를 우선순위에 큐에 넣어줌
					Q.offer(new Node(linkedNode.index, distance[linkedNode.index]));
				}
			}
		}

	}

}
