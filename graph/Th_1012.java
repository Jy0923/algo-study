import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static final int[] DX = {0,1,0,-1};
	static final int[] DY = {1,0,-1,0};
	
	static int row;
	static int col;
	
	static int[][] farm;
	static boolean[][] isChecked;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testCases = Integer.parseInt(br.readLine());
		
		StringBuilder answer = new StringBuilder();
		for(int tc=0; tc<testCases; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			int numOfCabbage = Integer.parseInt(st.nextToken());
			
			farm = new int[row][col];
			isChecked = new boolean[row][col];
			
			for(int i=0; i<numOfCabbage; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				farm[x][y] = 1;
			}
			
			int minNumOfWarm = 0;
			for(int i=0; i<row; i++) {
				for(int j=0; j<col; j++) {
					if(farm[i][j] == 0 || isChecked[i][j]) continue;
					check(i,j);
					minNumOfWarm++;
				}
			}
			
			answer.append(minNumOfWarm + "\n");
		}
		System.out.println(answer);
	}
	
	private static void check(int x, int y) {
		Queue<Coor> que = new LinkedList<>();
		
		que.offer(new Coor(x,y));
		
		while(!que.isEmpty()) {
			Coor cur = que.poll();
			
			for(int i=0; i<4; i++) {
				int nx = cur.x + DX[i];
				int ny = cur.y + DY[i];
				
				if(nx<0 || ny<0 || nx>=row || ny>=col)
					continue;
				
				if(farm[nx][ny]==0 || isChecked[nx][ny])
					continue;
				
				isChecked[nx][ny] = true;
				que.offer(new Coor(nx,ny));
			}
		}
	}
	
	private static class Coor {
		int x, y;

		public Coor(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}