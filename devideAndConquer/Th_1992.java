import java.util.Scanner;

public class BOJ_1992_쿼드트리 {
	
	static StringBuilder compressed = new StringBuilder();
	
	static int[][] video;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = Integer.parseInt(sc.nextLine());
		video = new int[size][size];
		
		//영상 정보 입력 받기
		String read;
		for(int i=0; i<size; i++) {
			read = sc.nextLine();
			for(int j=0; j<size; j++) {
				video[i][j] = read.charAt(j) -'0';
			}
		}
		
		if(!compress(0,0,size))  {
			addBracketAndDivide(0,0,size);
		}
		
		System.out.println(compressed);
	}
	
	private static boolean compress(int x, int y, int size) {
		int startPixel = video[x][y];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(video[i][j] != startPixel) {
					return false;
				}
			}
		}
		compressed.append(startPixel);
		return true;
	}
	
	private static void divide(int x, int y, int size) {
		for(int cnt=0; cnt<4; cnt++) {
			int r = x + (cnt/2)*(size/2);
			int c = y + (cnt%2)*(size/2);
			if(!compress(r, c, size/2)) {
				addBracketAndDivide(r, c, size/2);
			}
		}
	}
	
	private static void addBracketAndDivide(int x, int y, int size) {
		compressed.append('(');
		divide(x,y,size);
		compressed.append(')');
	}
}