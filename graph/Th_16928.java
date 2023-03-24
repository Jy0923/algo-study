package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_16928_뱀과사다리게임_정태희 {
	
	static int minCnt = Integer.MAX_VALUE;
	static int[] snake, ladder;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] read;
		
		snake = new int[101];
		ladder = new int[101];
		
		isVisited = new boolean[101];
		
		read = br.readLine().split(" ");
		int numOfLadder = Integer.parseInt(read[0]);
		int numOfSnake = Integer.parseInt(read[1]);
		
		for(int i=0; i<numOfLadder; i++) {
			read = br.readLine().split(" ");
			int from = Integer.parseInt(read[0]);
			int to = Integer.parseInt(read[1]);
			ladder[from] = to;
		}
		
		for(int i=0; i<numOfSnake; i++) {
			read = br.readLine().split(" ");
			int from = Integer.parseInt(read[0]);
			int to = Integer.parseInt(read[1]);
			snake[from] = to;
		}
		
		BFS();
		
		System.out.println(minCnt);
	}
	
	private static void BFS() {
		PriorityQueue<Cur> que = new PriorityQueue<>();
		que.offer(new Cur(1,0));
		isVisited[1] = true;
		
		while(!que.isEmpty()) {
			Cur cur = que.poll();
			
			if(cur.num == 100) {
				minCnt = Math.min(minCnt, cur.cnt);
				return;
			}
			
			for(int i=6; i>=1; i--) {
				int next = cur.num + i;
				
				if(next > 100) continue;
					
				if(ladder[next] != 0) next = ladder[next];
				if(snake[next] != 0) next = snake[next];
				
				if(isVisited[next]) continue;
				isVisited[next] = true;
				que.offer(new Cur(next, cur.cnt+1));
			}
		}
	}
	
	private static class Cur implements Comparable<Cur>{
		int num, cnt;

		public Cur(int num, int cnt) {
			this.num = num;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Cur o) {
			if(this.cnt == o.cnt) return o.num - this.num;
			return this.cnt - o.cnt;
		}
	}
}
