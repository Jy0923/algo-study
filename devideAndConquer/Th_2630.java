import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_2630_색종이만들기 {
	
	static final int WHITE = 0;
	static final int BLUE = 1;
	
	static int[][] confetti;
	static int[] confettiCount = new int[2];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int size = Integer.parseInt(sc.nextLine());
		confetti = new int[size][size];
		
		//색종이 색 정보 입력 받기
		StringTokenizer st;
		for(int i=0; i<size; i++) {
			st = new StringTokenizer(sc.nextLine());
			for(int j=0; j<size; j++) {
				confetti[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//제일 큰 사이즈 확인하고 하나의 색종이 아니면 나누기 시작
		if(!checkColor(0,0,size)) devide(0,0,size);
		
		//출력
		System.out.print(confettiCount[0] + "\n" + confettiCount[1]);
	}
	
	//4등분해서 확인하고
	//아니면 다시 나누기
	private static void devide(int x, int y, int size) {
		if(size == 1) return;
		
		for(int i=0; i<4; i++) {
			int r = x + (i/2)*(size/2);
			int c = y + (i%2)*(size/2);
			if(!checkColor(r, c, size)) {
				devide(r, c, size/2);
			}
		}
	}

	//해당 범위가 색종이가 맞는지 확인
	private static boolean checkColor(int r, int c, int size) {
		int startColor = confetti[r][c];
		
		for(int x=r; x<r+size/2; x++) {
			for(int y=c; y<c+size/2; y++) {
				if(confetti[x][y] != startColor) {
					return false;
				}
			}
		}
		confettiCount[startColor]++;
		return true;
	}
}