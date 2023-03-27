import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static final int[] DX = {0,1,0,-1,0,0};
	static final int[] DY = {1,0,-1,0,0,0};
	static final int[] DZ = {0,0,0,0,1,-1};
	
	static int[][][] boxes;
	
	static Queue<Coor> tomatoQue = new LinkedList<>();
	
	static int row,col,height;
	static int minDay = 0;
	static int unRiped = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] read;
		
		read = sc.nextLine().split(" ");
		col = Integer.parseInt(read[0]);
		row = Integer.parseInt(read[1]);
		height = Integer.parseInt(read[2]);
		
		boxes = new int[height][row][col];
		
		for(int i=0; i<height; i++) {
			for(int j=0; j<row; j++) {
				read = sc.nextLine().split(" ");
				for(int k=0; k<col; k++) {
					boxes[i][j][k] = Integer.parseInt(read[k]);
					
					if(boxes[i][j][k] == 1) {
						tomatoQue.offer(new Coor(i,j,k,0));
					} else if(boxes[i][j][k] == 0) {
						unRiped++;
					}
				}
			}
		}
		ripe();
		
		if(unRiped == 0) System.out.println(minDay);
		else System.out.println(-1);
	}
	
	private static void ripe() {
		while(!tomatoQue.isEmpty()) {
			Coor cur = tomatoQue.poll();
			
			minDay = cur.day;
			
			for(int i=0; i<6; i++) {
				int nx = cur.x + DX[i];
				int ny = cur.y + DY[i];
				int nz = cur.z + DZ[i];
				
				if(nx<0||ny<0||nz<0||nx>=row||ny>=col||nz>=height) 
					continue;
				
				if(boxes[nz][nx][ny] == 0) {
					unRiped--;
					boxes[nz][nx][ny] = 1;
					tomatoQue.offer(new Coor(nz,nx,ny,cur.day+1));
					
				}
			}
		}
	}
	
	private static class Coor {
		int z,x,y,day;

		public Coor(int z, int x, int y, int day) {
			super();
			this.z = z;
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
}