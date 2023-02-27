package devideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1992_쿼드트리 {

	static int[][] map;
	static StringBuilder sb = new StringBuilder();
	static int cnt;
	
	static void recur(int row, int col, int size) {
		
		// 종료조건
		if(colorCheck(row, col, size)) {
			if(map[row][col] == 0) {
				// 흰색
				sb.append(0);
			}
			else {
				// 검은색
				sb.append(1);
			}
			
			return;
		}
		
		// 만약 재귀없이 한번에 압축이된다면 괄호가 필요없고 재귀가 시작되면 괄호가 필요하다
		// 그리고 전체 사분면 4개를 다돌아야 괄호가 1개로 닫히니까 재귀 앞뒤로 괄호를 붙여준다
		sb.append("(");
		int halfSize = size / 2;
		
		// 재귀
		recur(row, col, halfSize); // 2사분면 (2 - 1 - 3 - 4 순으로 진행해야함)
		recur(row, col+halfSize, halfSize); // 1사분면
		recur(row+halfSize, col, halfSize); // 3사분면
		recur(row+halfSize, col+halfSize, halfSize); // 4사분면
		
		sb.append(")");
	}
	
	
	static boolean colorCheck(int row, int col, int size) {
		int color = map[row][col];
		
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(map[i][j] != color) 
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
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		recur(0, 0, n);
		
		System.out.println(sb);
	}
	
}
