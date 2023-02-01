import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yy_2447_ {
	
	static char[][] arr;
	
	
	public static void stars(int n, int startRow, int startCol) {
		
		// 종료조건(최소단위)
		if(n == 3) {
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					if(i == 1 && j == 1) {
						arr[i + startRow][j + startCol] = ' ';
						continue;
					}
					arr[i + startRow][j + startCol] = '*';
				}
			}
			return;
		}

		// 재귀
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(!(i == 1 && j == 1)) {
					stars(n/3, startRow + n/3 * i, startCol + n/3 * j);
				} else {
					makeSpacebar(n/3, startRow + n/3 * i, startCol + n/3 * j);
				}
			}
		}
	}
	
	// 가운데 n/3 X n/3 공백넣기
	public static void makeSpacebar(int n, int startRow, int startCol) {
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i + startRow][j + startCol] = ' ';
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
		arr = new char[n][n];
		
		stars(n, 0, 0);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
		
	}
}
