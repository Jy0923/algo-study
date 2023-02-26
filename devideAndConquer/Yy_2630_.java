package devideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No2630_색종이만들기 {
	
	static int white = 0;
	static int blue = 0;
	static int[][] map;
	
	static void recur(int row, int col, int size) {
		// 종료 조건
		// size * size 구간에서 색이 모두 일치할 때
		if(colorCheck(row, col, size)) {
			// 색이 흰색인지 파란색인지 확인해서 카운트+
			if(map[row][col] == 0)
				white++;
			else
				blue++;
			
			return;
		}
		
		// 전체 색이 일치하지 않았다면 반으로 쪼개서 다시 확인
		int halfSize = size / 2; 
		
		recur(row, col, halfSize); 		 		  // 2사분면
		recur(row, col+halfSize, halfSize); 		  // 1사분면
		recur(row+halfSize, col, halfSize); 		  // 3사분면
		recur(row+halfSize, col+halfSize, halfSize); // 4사분면
	}
	
	
	// size * size 구간에서 모두 색이 일치하는지 확인하기
	static boolean colorCheck(int row, int col, int size) {
		// 첫번째 구간
		int color = map[row][col];
		// 시작점부터 size만큼 확인해서 해당 구간(size * size)에서 색이 다 같은지 확인
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(map[i][j] != color) // 하나라도 다르면 false 리턴
					return false;
			}
		}
		
		return true;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recur(0, 0, n); // 시작점 (0,0)에서부터 재귀함수 시작!
		
		System.out.println(white);
		System.out.println(blue);
	}
	
}
