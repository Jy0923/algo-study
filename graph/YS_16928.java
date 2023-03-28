
/**
 *  일반은 -1, 사다리는 -2, 뱀은 -3으로 초기화
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int map[] = new int[101];

	public static void main(String[] args) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Integer, Integer> Ladder = new HashMap<>();
		Map<Integer, Integer> Snake = new HashMap<>();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 101; i++) {
			map[i] = -1;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			Ladder.put(start, end);

			map[start] = -2;

		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			Snake.put(start, end);
			map[start] = -3;

		}
		
		map[1] = 0;
		queue.offer(1);
		while(!queue.isEmpty()) {
			int pivot = queue.poll();
			int temp = pivot;
			for(int i = 0; i < 6; i++) {
				temp++;
				if(temp > 100) continue;
				
				
				if(map[temp] == -2) {
					int next = Ladder.get(temp);
					if(map[next] != -1) continue;
					queue.offer(next);
					map[next] = map[pivot] + 1;
					continue;
				}
				
				if(map[temp] == -3) {
					int next = Snake.get(temp);
					if(map[next] != -1) continue;
					queue.offer(next);
					map[next] = map[pivot] + 1;
					continue;
				}
				
				if(map[temp] == -1) {
					queue.offer(temp);
					map[temp] = map[pivot] + 1;
					
					continue;
				}
				
			}
			
			
		}

		System.out.println(map[100]);
		

	}

}
