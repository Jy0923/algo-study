import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {
	
	// v : 정점의 개수
	// e : 간선의 개수
	// k : 시작 정점의 번호
	static int v, e, k;
	
	// 거리 배열 -> 처음엔 모두 무한으로 초기화한다. -> 자바에선 무한 대신 Integer.MAX_VALUE 값으로
	static int distance[];
	static final int max = Integer.MAX_VALUE;
	
	// 배열리스트에 배열리스트가 하나씩 추가되는데 이 배열리스트에는 좌표쌍이 들어있다.
	static ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());

		// 거리 배열
		distance = new int[v+1];

		// 배열 초기화
		Arrays.fill(distance, max);

		
		// 정점의 개수만큼 배열리스트의 크기를 확보해준다.
		for (int i = 0; i <= v; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			
			// u : 시작 정점
			// v : 도착 정점
			// w : 가중치
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			// 시작 정점의 인덱스에는 배열리스트가 있고
			// 이 배열리스트에 도착 정점과 가중치가 들어있는 쌍을 넣어준다.
			// ex) 1번 정점의 배열리스트 -> [2, 2], [3, 3]
			// 1번은 2번에 연결되어 있고 가중치는 2이다, 1번은 3번에 연결되어 있고 가중치는 3이다.
			adj.get(u).add(new int[] { v, w });
		}

		// 정수배열을 갖는 우선순위 큐를 선언하는데, 0번 인덱스인 도착 정점 순으로 정렬한다.
		PriorityQueue<int[]> queue = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
		
		// 거리 0과 시작 정점 배열을 큐에 넣는다.
		queue.offer(new int[] { 0, k });
		
		// 시작 인덱스의 거리 값은 0
		distance[k] = 0;
		
		// 큐가 빌 때까지
		while (!queue.isEmpty()) {
			// 큐에서 나온 것을 cur 배열이라 하자
			int[] cur = queue.poll();

			// 현재 배열의 가중치와 거리 배열의 가중치가 같다면
			if (cur[0] == distance[cur[1]]) {
				
				// 현재 정점에 연결된 애들을 하나씩 꺼내오는데
				for (int[] e : adj.get(cur[1])) {
					
					// 만약 거리 배열의 현 인덱스 + 연결된 가중치 < 연결된 정점의 거리라면
					if (distance[cur[1]] + e[1] < distance[e[0]]) {
						
						// 연결된 정점의 거리 = 현재 인덱스의 거리 + 가중치로 바꾼다.
						distance[e[0]] = distance[cur[1]] + e[1];
						
						// 큐에 해당 정점까지의 거리와 정점을 넣는다.
						queue.offer(new int[] { distance[e[0]], e[0] });
					}
				}
			}
		}

		for(int i = 1; i <= v ; i++) {
			if(distance[i] == max) {
				System.out.println("INF");

			} else {
				System.out.println(distance[i]);
			}
		}

	}

}
