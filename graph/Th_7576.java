import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	static Queue<Tomato> riped = new LinkedList<>();
	
	static final int[] DX = {1,-1,0,0};
	static final int[] DY = {0,0,1,-1};
	
	static int[][] box;
	static int maxDay;
	static boolean[][] isRiped;
	
	static int numOfTomato = 0;
	
	static int N;
	static int M;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st;
		
		st = new StringTokenizer(sc.nextLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		box = new int[M][N];
		isRiped = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(sc.nextLine());
			for(int j=0; j<N; j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				
				if(box[i][j] == 1) {
					riped.offer(new Tomato(i,j,1));
					isRiped[i][j] = true;
				}
			}
		}
		
		ripe();
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(box[i][j] == 0) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		System.out.println(maxDay-1);
		sc.close();
	}
	
	private static void ripe() {
		while(!riped.isEmpty()) {
			Tomato cur = riped.poll();
			int curDay = cur.day;
			box[cur.x][cur.y] = curDay;
			maxDay = Math.max(maxDay, curDay);
			
			int nx, ny;
			for(int i=0; i<4; i++) {
				nx = cur.x + DX[i];
				ny = cur.y + DY[i];
				
				if(nx < 0 || ny < 0 || nx >= M || ny >= N)
					continue;
				
				if(box[nx][ny] == -1)
					continue;
				
				if(box[nx][ny] == 0 && !isRiped[nx][ny]) {
					riped.offer(new Tomato(nx,ny,curDay+1));
					isRiped[nx][ny] = true;
				}
			}
		}
	}
	
	private static class Tomato {
		int x, y, day;
		
		public Tomato(int x, int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
}