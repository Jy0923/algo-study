import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main{
	
	final int MAX = 100000;
	
	int n, k;
	int[] dist;
	
	public void dijkstra() {
		int[] cur;
		int nx;
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[0] - e2[0]);
		pq.offer(new int[] {0, n});
		dist[n] = 0;
		while (!pq.isEmpty()) {
			cur = pq.poll();
			
			if (dist[cur[1]] == cur[0]) {
				// 1.
				nx = cur[1] - 1;
				if (nx >= 0) {
					if (dist[nx] > cur[0] + 1) {
						dist[nx] = cur[0]+1;
						pq.offer(new int[] {dist[nx], nx}); 
					}
				}
				
				// 2. 
				nx = cur[1] + 1;
				if (nx <= MAX) {
					if (dist[nx] > cur[0] + 1) {
						dist[nx] = cur[0]+1;
						pq.offer(new int[] {dist[nx], nx}); 
					}
				}
				
				// 3.
				nx = cur[1] * 2;
				if (nx <= MAX) {
					if (dist[nx] > cur[0]) {
						dist[nx] = cur[0];
						pq.offer(new int[] {dist[nx], nx}); 
					}
				}
			}
		}
	}
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = sc.nextInt();
		dist = new int[MAX+1];
		
		for (int i = 0; i <= MAX; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dijkstra();
		
		System.out.println(dist[k]);
	}
	
	public static void main(String[] args) {
		new Main().solution();
	}
}
