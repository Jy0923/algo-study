import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static final int INF = Integer.MAX_VALUE;
	static int start,end,minTime;
	static int[] timeArr;
	static boolean[] isVisited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		start = sc.nextInt();
		end = sc.nextInt();
		minTime = INF;
		
		isVisited = new boolean[100_001];
		timeArr = new int[100_001];
		Arrays.fill(timeArr, INF);
		
		if(start != end) {
			getMinTime();
			System.out.println(timeArr[end]);
		} else {
			System.out.println(0);
		}
	}
	
	private static void getMinTime() {
		PriorityQueue<Pos> pq = new PriorityQueue<>();
		pq.offer(new Pos(start,0));
		
		while(!pq.isEmpty() && timeArr[end] == INF) {
			Pos cur = pq.poll();
			
			if(isVisited[cur.x]) continue;
			isVisited[cur.x] = true;
			
			timeArr[cur.x] = Math.min(timeArr[cur.x], cur.time);
			
			int next;
			if(cur.x>=1 && cur.x <= 100_000) {
				next = cur.x-1;
				pq.offer(new Pos(next, cur.time+1));
			}
			
			if(cur.x<=99_999 && cur.x >= 0) {
				next = cur.x+1;
				pq.offer(new Pos(next, cur.time+1));
			}
			
			if(cur.x*2 <= 100_000 && cur.x >=0) {
				next = cur.x*2;
				pq.offer(new Pos(next, cur.time));
			}
		}
	}
	
	private static class Pos implements Comparable<Pos>{
		int x,time;
		
		public Pos(int x, int time) {
			this.x = x;
			this.time = time;
		}

		@Override
		public int compareTo(Pos o) {
			return this.time - o.time;
		}
	}
}