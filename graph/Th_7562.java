import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static final int[] DX = {-1,-2,-2,-1,1,2,2,1};
	static final int[] DY = {-2,-1,1,2,2,1,-1,-2};
	
	static int size;
	
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCases = sc.nextInt();
		
		StringBuilder answer = new StringBuilder();
		for(int tc=0; tc<testCases; tc++) {
			size = sc.nextInt();
			
			startX = sc.nextInt();
			startY = sc.nextInt();
			endX = sc.nextInt();
			endY = sc.nextInt();
			
			answer.append(BFS() + "\n");
		}
		System.out.println(answer);
	}
	
	private static int BFS() {
		Queue<Coor> que = new LinkedList<>();
		que.offer(new Coor(startX, startY, 0));
		
		boolean[][] isVisited = new boolean[size][size];
		isVisited[startX][startY] = true;
		
		while(!que.isEmpty()) {
			Coor cur = que.poll();
			
			if(cur.x==endX && cur.y==endY)
				return cur.cnt;
			
			for(int i=0; i<8; i++) {
				int curCnt = cur.cnt;
				
				int nx = cur.x + DX[i];
				int ny = cur.y + DY[i];
				
				if(nx<0||ny<0||nx>=size||ny>=size)
					continue;
				
				if(isVisited[nx][ny])
					continue;
				
				isVisited[nx][ny] = true;
				que.offer(new Coor(nx,ny,cur.cnt+1));
			}
		}
		return 0;
	}
	
	private static class Coor {
		int x, y, cnt;

		public Coor(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
}