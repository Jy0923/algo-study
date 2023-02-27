package devideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1780_종이의개수 {
	// 이거만 풀고자장
	
	static int[][] map;
	static int n;
	static int minus = 0;
	static int zero = 0;
	static int plus = 0;
	
	public static void recur(int row, int col, int size) {
		
		// 종료조건
		if(colorCheck(row, col, size)) {
			if(map[row][col] == -1)
				minus++;
			else if(map[row][col] == 0)
				zero++;
			else
				plus++;
			
			return;
		}
		
		int halfSize = size / 3;
		recur(row, col, halfSize); 		
		recur(row, col+halfSize, halfSize); 	
		recur(row, col+2*halfSize, halfSize);
		recur(row+halfSize, col, halfSize); 		
		recur(row+halfSize, col+halfSize, halfSize);
		recur(row+halfSize, col+2*halfSize, halfSize);
		recur(row+2*halfSize, col, halfSize);
		recur(row+2*halfSize, col+halfSize, halfSize);
		recur(row+2*halfSize, col+2*halfSize, halfSize);
	}
	
	
	public static boolean colorCheck(int row, int col, int size) {
		boolean isEquals = true;
		int color = map[row][col];
		
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(map[i][j] != color) {
					isEquals = false;
					break;
				}
			}
		}
		
		return isEquals;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recur(0, 0, n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
	}
	
}
