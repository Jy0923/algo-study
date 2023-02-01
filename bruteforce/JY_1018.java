import java.util.Scanner;

public class JY_1018 {
	
	int row;
	int col;
	char[][] arr;
	
	public int getMin(int startRow, int startCol) {
		int wStart = 0;
		int bStart = 0;
		boolean isEven;
		for (int r = startRow; r < startRow+8; r++) {
			for (int c = startCol; c < startCol+8; c++) {
				isEven = (r + c) % 2 == 0; 
				if (isEven) {
					if (arr[r][c] == 'W') {
						bStart++;
					}else {
						wStart++;
					}
				}else {
					if (arr[r][c] == 'W') {
						wStart++;
					}else {
						bStart++;
					}
				}
			}
		}
		return Math.min(wStart, bStart);
	}
	
	public void solution() {
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		arr = new char[row][col]; 
		for (int i = 0; i < row; i++) {
			String s = sc.next();
			for (int j = 0; j < col; j++) {
				arr[i][j] = s.charAt(j);
			}
		}
		
		int answer = 2500;
		for (int i = 0; i < row - 7; i++) {
			for (int j = 0; j < col - 7; j++) {
				answer = Math.min(answer, getMin(i, j));
			}
		}
		
		System.out.println(answer);
	}
	
	public static void main(String[] args) {
		new JY_1018().solution();
	}
}
